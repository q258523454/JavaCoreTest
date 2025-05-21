package javacore.base.juc.t3_multi_thread.t0_runnable_thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class T3_OnlyRunnable implements Runnable {
    @Override
    public synchronized void run() {
        log.info("线程" + Thread.currentThread().getName());
    }

    /**
     * Runnable
     * Runnable接口避免了单继承的局限性, 实现Runnable接口的方式,更加的符合面向对象.
     * 线程分为两部分:1.线程对象 2.线程任务
     * 而继承Thread类，线程对象和线程任务耦合在一起。一旦创建Thread类的子类对象，既是线程对象，又有线程任务。
     */
    public static void main(String[] args) throws InterruptedException {
        T3_OnlyRunnable onlyRunnable = new T3_OnlyRunnable();
        Thread thread1 = new Thread(onlyRunnable, "A-1");
        thread1.start();
    }
}
