package javacore.base.juc.t3_daemon_thread;

import javacore.base.juc.t3_multi_thread.t0_runnable_thread.ThreadFactoryImpl;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
@Data
public class DamonThreadTask implements Runnable, DisposableBean {

    /**
     * 后台线程池
     */
    private ExecutorService executor = new ThreadPoolExecutor(1,
            1, 1, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(1),
            new ThreadFactoryImpl("Daemon"));

    /**
     * 线程执行条件
     */
    private volatile boolean runStatus = false;

    private String threadName = "";

    public DamonThreadTask(String threadName) {
        this.threadName = threadName;
    }

    /**
     * 用start()启动,不要直接调用 run() 方法
     */
    public void start() {
        synchronized (this) {
            if (runStatus) {
                log.info(this.getThreadName() + " is already run. please check it.");
                return;
            }
            runStatus = true;
            executor.execute(this);
        }
    }

    @Override
    public void run() {
        // 持续后台匿名执行, 直到 runStatus=false
        while (runStatus) {
            try {
                Thread.sleep(500);
                log.info(this.getThreadName() + " is running.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.info("Daemon condition is false, Thread is stop running.(Thread pool not down)");
        executor.shutdown();
        log.info("Thread pool is closing");
    }

    /**
     * 如果是 @Bean, 销毁的时候停止线程,关闭线程池
     */
    @Override
    public void destroy() throws Exception {
        runStatus = false;
        // 停止接受新任务,当已有任务将执行完,关闭线程池[非阻塞]
        executor.shutdown();
        log.info("Daemon condition is set false,Thread pool is closing");
    }
}
