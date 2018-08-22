package javacore.MultiThread.ThreadPool2;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-08-22
 */

public class MyMonitorThread implements Runnable {

    private ThreadPoolExecutor executor;
    private int seconds;
    private boolean run = true;

    public MyMonitorThread(ThreadPoolExecutor executor, int seconds) {
        this.executor = executor;
        this.seconds = seconds;
    }

    public MyMonitorThread(ThreadPoolExecutor executor, int seconds, boolean run) {
        this.executor = executor;
        this.seconds = seconds;
        this.run = run;
    }


    public void shutdown() {
        this.run = false;
    }

    @Override
    public void run() {
        while (run) {
            System.out.println(
                    String.format("[monitor] [%d/%d] Active: %d, Completed: %d, Task: %d, isShutdown: %s, isTerminated: %s",
                            this.executor.getPoolSize(),
                            this.executor.getCorePoolSize(),
                            this.executor.getActiveCount(),
                            this.executor.getCompletedTaskCount(),
                            this.executor.getTaskCount(),
                            this.executor.isShutdown(),
                            this.executor.isTerminated()));
            try {
                Thread.sleep(seconds * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
