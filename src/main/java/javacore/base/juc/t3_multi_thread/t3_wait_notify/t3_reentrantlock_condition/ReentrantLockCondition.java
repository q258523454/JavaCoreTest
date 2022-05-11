package javacore.base.juc.t3_multi_thread.t3_wait_notify.t3_reentrantlock_condition;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


@Slf4j
public class ReentrantLockCondition implements Runnable {


    // public static ReentrantLock lock = new ReentrantLock();
    public static ReentrantLock lock = new ReentrantLock(true);

    public static Condition condition = lock.newCondition();

    @Override
    public void run() {
        lock.lock();
        try {
            log.info(Thread.currentThread().getName() + " 等待");
            // 线程等待5秒, 除非被主动唤醒
            boolean beCalled = condition.await(2, TimeUnit.SECONDS);
            // 被主动唤醒,beCalled=true
            if (beCalled) {
                log.info(Thread.currentThread().getName() + " 被主动唤醒");
            } else {
                log.info(Thread.currentThread().getName() + " 没有被唤醒,到期结束.");
            }
        } catch (Exception ex) {
            // TODO
        } finally {
            lock.unlock();
        }
    }

    @SneakyThrows
    public static void main(String[] args) {
        // 创建5个线程,并进入等待.
        for (int i = 0; i < 5; i++) {
            new Thread(new ReentrantLockCondition()).start();
        }

        // 等待100毫秒,让上面的线程都进入await状态
        TimeUnit.MILLISECONDS.sleep(1000);

        // 主动唤醒4个线程
        for (int i = 0; i < 4; i++) {
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
                // do something.
            } finally {
                lock.unlock();
            }
        }


    }
}
