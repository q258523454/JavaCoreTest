package javacore.baseimpro.high_concurrency.t2_multi_thread.t4_reentrantlock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.ReentrantLock;


/**
 * @Description
 * @date 2020-02-06 17:50
 * @modify
 */
public class T2_ReentrantLockTest2 implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(T2_ReentrantLockTest2.class);

    private static int i = 0;

    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        // 可重入，如果已经被上锁，则等待线程执行完毕, 资源释放。到达暂停效果。此时效果同 synchronize
        lock.lock();
        try {
            for (int j = 0; j < 10; j++) {
                logger.info(Thread.currentThread().getName() + "：" + i);
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T2_ReentrantLockTest2 test2 = new T2_ReentrantLockTest2();
        Thread thread1 = new Thread(test2);
        Thread thread2 = new Thread(test2);
        thread1.start();
        thread2.start();
        // 等待线程执行完毕
        thread1.join();
        thread2.join();
        System.exit(0);

    }

}
