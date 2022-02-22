package javacore.baseimpro.high_concurrency.t2_multi_thread.t3_synchronized;

import lombok.extern.slf4j.Slf4j;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-02-27
 */
@Slf4j
public class Synchronized_Class_This {
    /***
     * 前言:
     * synchronized 两种锁: this:对象锁(实例锁), Class:类锁
     * synchronized锁住的是一个对象(实例)或者类，而不是方法或者代码段。
     *
     * 同一个对象的对象锁被lock, 该对象的所有synchronized[方法级]都互斥;
     * 同一类的类锁被lock, 该类的所有synchronized[类级别]都互斥;
     * 但是对象锁和类锁互不影响
     *
     */
    public void test1() {
        synchronized (this) {
            int i = 5;
            while (i-- > 0) {
                log.info(Thread.currentThread().getName() + " : " + i);
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
            log.info(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    // 对象锁B
    public synchronized void instanceSyncB() {
        int i = 5;
        while (i-- > 0) {
            log.info(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    // 类锁A
    public static synchronized void classSyncA() {
        int i = 5;
        while (i-- > 0) {
            log.info(Thread.currentThread().getName() + " : " + i);
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
            log.info(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }
    }

    public static void main(String[] args) {
        final Synchronized_Class_This myt1 = new Synchronized_Class_This();
        final Synchronized_Class_This instanceX = new Synchronized_Class_This();
        final Synchronized_Class_This instanceY = new Synchronized_Class_This();

        // ------------ 1.同一个实例, 所有的synchronized方法(对象锁), 互斥 ------------
        Thread test1 = new Thread(new Runnable() {
            @Override
            public void run() {
                instanceX.instanceSyncA();
            }
        }, "test1");
        Thread test2 = new Thread(new Runnable() {
            @Override
            public void run() {
                instanceX.instanceSyncB();
            }
        }, "test2");


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

        // ------------ 4.同一个类的不同的实例，不同的static synchronized方法(类锁), 互斥 ------------
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
//        Thread test1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                instanceX.instanceSyncA();
//            }
//        }, "test1");
//        Thread test2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                T1_Synchronized_Class_This.classSyncA();
//            }
//        }, "test2");

        test1.start();
        test2.start();
    }

}
