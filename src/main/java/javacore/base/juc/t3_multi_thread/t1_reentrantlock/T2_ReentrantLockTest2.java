package javacore.base.juc.t3_multi_thread.t1_reentrantlock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;


/**
 * @Description
 * @date 2020-02-06 17:50
 * @modify
 */
@Slf4j
public class T2_ReentrantLockTest2 implements Runnable {

    private static int current = 0;

    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        // 可重入，如果已经被上锁，则等待线程执行完毕, 资源释放。到达暂停效果。此时效果同 synchronize
        log.info("线程-" + Thread.currentThread().getName() + "开始获取重入锁.");
        lock.lock();
        log.info("线程-" + Thread.currentThread().getName() + "获取重入锁成功.");
        try {
            for (int i = 0; i < 10; i++) {
                log.info("线程-" + Thread.currentThread().getName() + "：" + current);
                current++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            log.info("线程-" + Thread.currentThread().getName() + "释放.");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T2_ReentrantLockTest2 test2 = new T2_ReentrantLockTest2();
        Thread thread1 = new Thread(test2);
        Thread thread2 = new Thread(test2);
        thread1.start();
        thread2.start();
        log.info("等待线程执行完毕");
        // 等待线程执行完毕
        thread1.join();
        thread2.join();
        System.exit(0);

    }

}
