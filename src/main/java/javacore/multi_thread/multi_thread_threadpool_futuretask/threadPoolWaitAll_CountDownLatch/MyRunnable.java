package javacore.multi_thread.multi_thread_threadpool_futuretask.threadPoolWaitAll_CountDownLatch;


import java.util.concurrent.CountDownLatch;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-08-22
 */

public class MyRunnable implements Runnable {
    private String command;
    private CountDownLatch countDownLatch;

    public MyRunnable(String command, CountDownLatch countDownLatch) {
        this.command = command;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Command = " + command);
        processCommand(Thread.currentThread().getName(), command);
        System.out.println(Thread.currentThread().getName() + " End.");
    }

    private void processCommand(String threadName, String command) {
        System.out.println("线程" + threadName + ":, 正在进行操作:" + command);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            countDownLatch.countDown();
        }
    }
}