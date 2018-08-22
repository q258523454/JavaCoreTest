package javacore.MultiThread;

import javax.naming.Name;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-08-22
 */

// Runnable接口避免了单继承的局限性,实现Runnable接口的方式，更加的符合面向对象，线程分为两部分，一部分:线程对象，一部分:线程任务
// 而继承Thread类，线程对象和线程任务耦合在一起。一旦创建Thread类的子类对象，既是线程对象，又有线程任务。
public class OnlyRunnable implements Runnable {


    @Override
    public synchronized void run() {
        func("");
    }

    public void func(String threadName) {
        for (int i = 0; i < 10; i++) {
            // Thread.currentThread().getName() : 当前线程名称
            System.out.println("线程" + Thread.currentThread().getName() + ", Runable :" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        OnlyRunnable onlyRunnable = new OnlyRunnable();
        Thread thread1 = new Thread(onlyRunnable,"A-1");
        Thread thread2 = new Thread(onlyRunnable, "A-2");
        Thread thread3 = new Thread(new OnlyRunnable(),"B");
        Thread thread4 = new Thread(new OnlyRunnable(),"C");
        thread1.start();
        thread2.start();
        Thread.sleep(1000);
        thread3.start();
        thread4.start();
        System.out.println("主线程结束.");
    }
}
