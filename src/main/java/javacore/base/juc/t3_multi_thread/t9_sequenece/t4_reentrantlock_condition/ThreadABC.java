package javacore.base.juc.t3_multi_thread.t9_sequenece.t4_reentrantlock_condition;


import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


@Slf4j
public class ThreadABC {


    /**
     * ReentrantLock-Condition(重入锁)
     */
    @SneakyThrows
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        final SequenceLock sequenceLock = new SequenceLock();
        Runnable a = () -> sequenceLock.a();
        Runnable b = () -> sequenceLock.b();
        Runnable c = () -> sequenceLock.c();
        executorService.execute(a);
        executorService.execute(b);
        executorService.execute(c);

        Thread.sleep(1000);
        sequenceLock.getLock().lock();
        try {
            // 唤醒A线程,依次执行A,B,C
            sequenceLock.getConditionA().signal();
        } catch (Exception ex) {
            //TODO
        } finally {
            sequenceLock.getLock().unlock();
        }
        System.exit(0);
    }

    @Data
    static class SequenceLock {
        private ReentrantLock lock = new ReentrantLock();
        private Condition conditionA = lock.newCondition();
        private Condition conditionB = lock.newCondition();
        private Condition conditionC = lock.newCondition();

        public void a() {
            lock.lock();
            try {
                log.info("A,wait signal");
                // wait()的执行前提是当前线程获取了对象控制权,否则会报错:java.lang.IllegalMonitorStateException
                conditionA.await();
                log.info("A");
                // 同 notify()一样,并不会立马释放锁,等程序全部执行完,直到 unlock
                conditionB.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void b() {
            lock.lock();
            try {
                log.info("B,wait signal");
                conditionB.await();
                log.info("B");
                conditionC.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void c() {
            lock.lock();
            try {
                log.info("C,wait signal");
                conditionC.await();
                log.info("C");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
