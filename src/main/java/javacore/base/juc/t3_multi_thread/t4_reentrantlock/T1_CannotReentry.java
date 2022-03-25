package javacore.base.juc.t3_multi_thread.t4_reentrantlock;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-06
 */


// 不可重入锁(模拟)
public class T1_CannotReentry {
    // 默认情况下表示当前锁处于未锁定状态
    private boolean isLocked = false;

    // 对象锁
    public synchronized void lock() throws InterruptedException {
        // 如果其他线程已经获取了锁,则等待
        while (isLocked) {
            wait();
        }
        // 上锁
        isLocked = true;
        //TODO:业务操作
    }

    // 释放锁
    public synchronized void unlock() {
        // 当前线程将锁释放，并将锁设置为未锁定状态
        isLocked = false;
        // 唤醒其他处于等待队列的线程
        notify();
    }
}
