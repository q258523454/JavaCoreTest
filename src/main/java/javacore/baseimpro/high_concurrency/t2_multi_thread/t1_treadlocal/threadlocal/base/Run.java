package javacore.baseimpro.high_concurrency.t2_multi_thread.t1_treadlocal.threadlocal.base;

public class Run {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new ThreadLocalTest());
        Thread thread2 = new Thread(new ThreadLocalTest());
        thread1.start();
        thread2.start();
    }
}