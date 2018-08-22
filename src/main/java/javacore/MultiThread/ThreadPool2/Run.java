package javacore.MultiThread.ThreadPool2;

import javacore.MultiThread.ThreadPool.WorkerThread;
import java.util.concurrent.*;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-08-22
 */


public class Run {

    public static void main(String args[]) throws InterruptedException {

        // RejectedExecutionHandler implementation
        RejectedExecutionHandlerImpl rejectionHandler = new RejectedExecutionHandlerImpl();

        // Get the ThreadFactory implementation to use
        ThreadFactory threadFactory = Executors.defaultThreadFactory();

        // creating the ThreadPoolExecutor
        ThreadPoolExecutor executorPool = new ThreadPoolExecutor(2, 10, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(2), threadFactory, rejectionHandler);

        // start the monitoring thread
        MyMonitorThread monitor = new MyMonitorThread(executorPool, 3);
        Thread monitorThread = new Thread(monitor);
        monitorThread.start();

        // 创建10个线程, 提交到线程池
        for (int i = 0; i < 10; i++) {
            executorPool.execute(new WorkerThread("cmd_" + i));
        }

        Thread.sleep(30000);
        //shut down the pool
        executorPool.shutdown();
        //shut down the monitor thread
        Thread.sleep(5000);
        monitor.shutdown();

    }
}
