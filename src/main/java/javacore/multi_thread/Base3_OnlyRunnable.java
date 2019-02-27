package javacore.multi_thread;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-08-22
 */

// Runnable接口避免了单继承的局限性,实现Runnable接口的方式，更加的符合面向对象，线程分为两部分，一部分:线程对象，一部分:线程任务
// 而继承Thread类，线程对象和线程任务耦合在一起。一旦创建Thread类的子类对象，既是线程对象，又有线程任务。
public class Base3_OnlyRunnable implements Runnable {


    @Override
    public synchronized void run() {
        String runnableName = Thread.currentThread().getName();
        func(runnableName);
    }

    public void func(String runnableName) {
        for (int i = 0; i < 10; i++) {
            // Thread.currentThread().getName() : 当前线程名称
            System.out.println("线程" + runnableName + ", Runable :" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Base3_OnlyRunnable onlyRunnable = new Base3_OnlyRunnable();

        // thread1和thread2操作的是同一个对象,且run()加了synchronized, 则互斥操作,A-1执行完成之后才有A-2
        Thread thread1 = new Thread(onlyRunnable, "A-1");
        Thread thread2 = new Thread(onlyRunnable, "A-2");
        thread1.start();
        thread2.start();
        Thread.sleep(1000); // 主线程阻塞

        // thread3和thread4操作的是不同一个对象, 且没有类锁, 不存在互斥
        Thread thread3 = new Thread(new Base3_OnlyRunnable(), "B");
        Thread thread4 = new Thread(new Base3_OnlyRunnable(), "C");
        thread3.start();
        thread4.start();

        System.out.println("主线程结束.");
    }
}
