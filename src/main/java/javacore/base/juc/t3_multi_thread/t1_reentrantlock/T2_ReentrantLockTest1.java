package javacore.base.juc.t3_multi_thread.t1_reentrantlock;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-06
 */
@Slf4j
public class T2_ReentrantLockTest1 {
    private static final Logger logger = LoggerFactory.getLogger(T2_ReentrantLockTest1.class);

    private ReentrantLock lock = new ReentrantLock();

    // Lock lock = new Lock();
    public void firstLock() throws InterruptedException {
        lock.lock();
        try {
            logger.info("第一次上锁. 当前锁数:" + lock.getHoldCount());
            doSecondLock();
            logger.info("第一次上锁完成. 当前锁数:" + lock.getHoldCount());
        } finally {
            lock.unlock();
        }
    }

    public void doSecondLock() throws InterruptedException {
        log.info("准备第二次上锁. 当前锁数:" + lock.getHoldCount());
        lock.lock();
        try {
            log.info("第二次上锁完成. 当前锁数:" + lock.getHoldCount());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        // 可重入锁
        T2_ReentrantLockTest1 myReentrantLock = new T2_ReentrantLockTest1();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    myReentrantLock.firstLock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}