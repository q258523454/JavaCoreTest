package javacore.baseimpro.high_concurrency.t2_multi_thread.t6_wait_notify.t3_reentrantlock_condition;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


@Slf4j
public class ReentrantLockCondition implements Runnable {


    public static ReentrantLock lock = new ReentrantLock();

    public static Condition condition = lock.newCondition();

    @Override
    public void run() {
        lock.lock();
        try {
            // 线程等待5秒, 除非被主动唤醒
            boolean await = condition.await(5, TimeUnit.SECONDS);
            log.info(Thread.currentThread().getName() + " await:" + await);
            log.info(Thread.currentThread().getName() + " finished.");
        } catch (Exception ex) {
            // TODO
        } finally {
            lock.unlock();
        }
    }

    @SneakyThrows
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new ReentrantLockCondition()).start();
        }

        // 等待100毫秒,让上面的线程都进入await状态
        TimeUnit.MILLISECONDS.sleep(1000);

        lock.lock();
        try {
            /**
             * 默认随机唤醒 condition等待队列中的一个
             * 如果设置的是公平锁 new ReentrantLock(true), 则FIFO释放
             */
            condition.signal();

            /**
             * 唤醒 condition等待队列中的所有
             */
            // condition.signalAll();
        } catch (Exception ex) {

        } finally {
            lock.unlock();
        }

    }
}
