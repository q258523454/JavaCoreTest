package javacore.base.juc.t3_multi_thread.t3_wait_notify.t1_object_wait_notify;

import lombok.SneakyThrows;

public class ObjectNotify {

    @SneakyThrows
    public static void main(String[] args) {
        final MyRunnable myRunnable = new MyRunnable();
        new Thread(myRunnable).start();

        Thread.sleep(2000);

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
                    System.out.println("Thread run.等待..");
                    // 释放锁资源,进行等待
                    this.wait();
                    System.out.println("Thread stop");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("1111111");
            }
        }
    }
}
