package javacore.baseimpro.high_concurrency.t2_multi_thread.t6_wait_notify.t2_object_wait_notify;

import lombok.SneakyThrows;

public class ObjectNotify {

    @SneakyThrows
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        new Thread(myRunnable).start();

        Thread.sleep(1000);

        // notify(),wait() 必须获取对象锁,否则会报错:java.lang.IllegalMonitorStateException
        synchronized (myRunnable) {
            // 若对象有多个等待,随机唤醒
            myRunnable.notify();
        }
        System.exit(0);
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            synchronized (this) {
                try {
                    System.out.println("Thread run");
                    // 释放锁资源,进行等待
                    this.wait();
                    System.out.println("Thread stop");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
