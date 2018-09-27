package javacore.MultiThread.ThreadPoolTimeOut_Block_No;

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
        System.out.println("AA");
        backgroundExecutor.execute(new Runnable() {
            public void run() {
                Callable callable = Executors.callable(new WorkerThread("test", 1000), "子线程-嵌套子线程");
                FutureTask<String> future = new FutureTask(callable);
                Thread thread = new Thread(future);
                thread.start();
                System.out.println("BB");
                try {
                    String res = future.get(2000, TimeUnit.MILLISECONDS);   // 设置等待线程的超时时间
                    log.info("子线程:" + Thread.currentThread().getName() + "完成{" + res + "}任务");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    future.cancel(true);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                    log.error("ExecutionException", e);
                } catch (TimeoutException e) {
                    e.printStackTrace();
                    future.cancel(true);
                } finally {
                    thread.interrupt(); // 中断线程
                }
            }
        });

        // 必须, 否则嵌套线程不会停止
        backgroundExecutor.shutdown(); // 线程池的状态立刻变成STOP状态，此时不能再往线程池中添加新的任务,试图停止所有正在执行的线程，试图终止的方法是调用Thread.interrupt()
        System.out.println("CC");
    }
}
