package javacore.multi_thread_base.synchronized_reentrantlock;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-06
 */


// 不可重入锁(模拟)
public class CannotReentry {
    //默认情况下表示当前锁处于未锁定状态
    private boolean isLocked = false;

    // 上锁
    public synchronized void lock() throws InterruptedException {
        // 上锁,如果其他线程已经获取了锁,则等待释放
        while (isLocked) {
            wait();
        }
        // 锁定
        isLocked = true;
    }

    // 释放锁
    public synchronized void unlock() {
        // 当前线程将锁释放，并将锁设置为未锁定状态
        isLocked = false;
        // 唤醒其他处于等待队列的线程
        notify();
    }
}
