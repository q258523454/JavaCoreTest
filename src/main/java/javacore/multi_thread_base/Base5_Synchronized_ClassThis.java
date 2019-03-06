package javacore.multi_thread_base;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-02-27
 */
public class Base5_Synchronized_ClassThis {
    /***
     * 前言:
     * synchronized 两种锁: this:对象锁(实例锁), Class:类锁
     * 对象锁: 多个线程对同一对象(实例)的操作, 在{全部}synchronized 方法上互斥
     * 同一个对象的对象锁被lock, 该对象的所有sunchronized[方法级]都互斥;
     * 同一类的类锁被lock, 该类的所有sunchronized[类级别]都互斥;
     * 但是对象锁和类锁互不影响
     *
     * 最后还要告别一个误区，相信大家都不会再犯这种错误了，synchronized锁住的是一个对象或者类（其实也是对象），而不是方法或者代码段。
     *
     */

    public void test1() {
        synchronized (this) {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                }
            }
        }
    }

    // 对象锁A
    public synchronized void instanceSyncA() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }
    }

    // 对象锁B
    public synchronized void instanceSyncB() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }
    }

    // 类锁A
    public static synchronized void classSyncA() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }
    }

    // 类锁B
    public static synchronized void classSyncB() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }
    }

    public static void main(String[] args) {
        final Base5_Synchronized_ClassThis myt1 = new Base5_Synchronized_ClassThis();
        final Base5_Synchronized_ClassThis instanceX = new Base5_Synchronized_ClassThis();
        final Base5_Synchronized_ClassThis instanceY = new Base5_Synchronized_ClassThis();

        // ------------ 1.同一个实例, 所有的synchronized方法(对象锁), 互斥 ------------
//        Thread test1 = new Thread(new Runnable() {
//            public void run() {
//                instanceX.instanceSyncA();
//            }
//        }, "test1");
//        Thread test2 = new Thread(new Runnable() {
//            public void run() {
//                instanceX.instanceSyncB();
//            }
//        }, "test2");


        // ------------ 2.不同的实例，同一个synchronized方法(对象锁), 互不影响 ------------
//        Thread test1 = new Thread(new Runnable() {
//            public void run() {
//                instanceX.instanceSyncA();
//            }
//        }, "test1");
//
//        Thread test2 = new Thread(new Runnable() {
//            public void run() {
//                instanceY.instanceSyncA();
//            }
//        }, "test2");

        // ------------ 3.不同的实例，相同的static synchronized方法(类锁), 互斥 ------------
//        Thread test1 = new Thread(new Runnable() {
//            public void run() {
//                instanceX.classSyncA();
//            }
//        }, "test1");
//        Thread test2 = new Thread(new Runnable() {
//            public void run() {
//                instanceY.classSyncA();
//            }
//        }, "test2");

        // ------------ 4.不同的实例，不同的static synchronized方法(类锁), 互斥 ------------
//        Thread test1 = new Thread(new Runnable() {
//            public void run() {
//                instanceX.classSyncA();
//            }
//        }, "test1");
//        Thread test2 = new Thread(new Runnable() {
//            public void run() {
//                instanceY.classSyncB();
//            }
//        }, "test2");


        // ------------ 5.对象锁和类锁互不影响, 即对象锁和类锁属于不同的管理区域 ------------
        Thread test1 = new Thread(new Runnable() {
            public void run() {
                instanceX.instanceSyncA();
            }
        }, "test1");
        Thread test2 = new Thread(new Runnable() {
            public void run() {
                instanceY.classSyncA();
            }
        }, "test2");

        test1.start();
        test2.start();

    }

}
