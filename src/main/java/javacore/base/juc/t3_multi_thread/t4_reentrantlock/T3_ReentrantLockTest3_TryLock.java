package javacore.base.juc.t3_multi_thread.t4_reentrantlock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;


/**
 * @Description
 * @date 2020-02-06 17:50
 * @modify
 */
public class T3_ReentrantLockTest3_TryLock implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(T3_ReentrantLockTest3_TryLock.class);

    private static int i = 0;

    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        boolean isGetLock = false;
        try {
            logger.info(Thread.currentThread().getName() + " 尝试上锁");
            // 尝试获取锁,最多等待1秒钟.(tryLock()是不会等待的)
            // 注意:tryLock不要使用Lock.lock(), 它会重入
            isGetLock = lock.tryLock(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 只有拿到了锁才需要 unlock()
        if (isGetLock) {
            try {
                logger.info(Thread.currentThread().getName() + " 上锁成功.");
                logger.info(Thread.currentThread().getName() + " start sleep.");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            logger.info(Thread.currentThread().getName() + " sleep out");
        } else {
            logger.info(Thread.currentThread().getName() + " 无法上锁");
        }
    }

    public static void main(String[] args) {
        T3_ReentrantLockTest3_TryLock reentrantLockBaseTest = new T3_ReentrantLockTest3_TryLock();
        Thread thread1 = new Thread(reentrantLockBaseTest);
        Thread thread2 = new Thread(reentrantLockBaseTest);
        thread1.start();
        thread2.start();

    }

}
