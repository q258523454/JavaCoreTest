package javacore.multi_thread.test7_threadpool_futuretask.test3_futuretask.threadPoolTimeOut_Block_No;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-08-22
 */

public class Run {


    // 新开线程, 设置超时时间 [主线程会阻塞, 除非线程完成或者超时]
    public static Logger log = LoggerFactory.getLogger(Run.class);

    // 使用嵌套子线程的方法, 为线程中的线程设置超时时间, 且不影响主线程的运行
    public static void main(String[] args) throws InterruptedException {
        final ExecutorService backgroundExecutor = Executors.newSingleThreadExecutor();
        System.out.println("主线程-A阶段");
        backgroundExecutor.execute(new Runnable() {
            public void run() {
                MyRunnable myRunnable = new MyRunnable("test");
                Callable callable = Executors.callable(myRunnable, "子线程-嵌套子线程");
                FutureTask<String> future = new FutureTask(callable);
                Thread thread = new Thread(future);
                thread.start();

                // 方式二: ExecutorService 执行嵌套子线程
                // ExecutorService executorService = Executors.newSingleThreadExecutor();
                // executorService.execute(future);

                System.out.println("主线程-B阶段");

                try {
                    // TODO 实际上这里并没有因为超时而终止嵌套子线程， 嵌套子线程仍然在运行, 必须在嵌套子线程的方法里面加条件判断,
                    // TODO 然后在嵌套子线程中通过抛异常来终止线程
                    String res = future.get(1000, TimeUnit.MILLISECONDS);   // 设置等待线程的超时时间
                    log.info("子线程:" + Thread.currentThread().getName() + "完成{" + res + "}任务");
                } catch (InterruptedException e) {
                    log.error("嵌套子线程-中断");
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    log.error("嵌套子线程-运行异常");
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    log.error("嵌套子线程-超时");
                    future.cancel(true);  // 经过测试, 里面包含了方法:thread.interrupt()
                    e.printStackTrace();
                }
            }
        });

        // 必须, 否则嵌套线程不会停止
        backgroundExecutor.shutdown(); // 线程池的状态立刻变成STOP状态，此时不能再往线程池中添加新的任务,试图停止所有正在执行的线程，试图终止的方法是调用Thread.interrupt()
        System.out.println("主线程-C阶段-结束");

    }
}
