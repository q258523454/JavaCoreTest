package javacore.multi_thread_base.synchronized_reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-06
 */
public class MyReentrantLock {
    ReentrantLock lock = new ReentrantLock();

    //Lock lock = new Lock();
    public void print() throws InterruptedException {
        try {
            lock.lock();
            System.out.println("print....");
            doAdd();
        } finally {
            lock.unlock();
        }
    }

    public void doAdd() throws InterruptedException {
        lock.lock();
        System.out.println("doAdd....");
        lock.unlock();
    }

    public static void main(String[] args) {
        // 可重入锁
        MyReentrantLock myReentrantLock = new MyReentrantLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    myReentrantLock.print();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}