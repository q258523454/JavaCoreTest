package javacore.base.juc.t3_multi_thread.t9_sequenece.t3_object_wait_notify;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class ThreadAB {

    /**
     * object.wait/notify
     */
    @SneakyThrows
    public static void main(String[] args) {
        final Object pv = new Object();

        ThreadB b = new ThreadB();
        ThreadA a = new ThreadA(b);

        // 期望顺序 A->B
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // 这里必须要让B先执行才能正常执行,否则会让B一直处于wait()
        // 原因: 如果A先拿到对象锁,执行notify()无法唤醒B, 因为B还没有拿到对象锁,还没有执行wait()
        // 因此: 同一个锁的执行顺序一定是 wait()-notify()
        executorService.execute(b);
        Thread.sleep(100);
        executorService.execute(a);


        // 停止接受新任务,当已有任务将执行完,关闭线程池
        executorService.shutdown();
        while (!executorService.isTerminated()) {
            // 等待所有线程执行完成
        }
        System.exit(0);
    }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
            synchronized (this) {
                try {
                    log.info("B线程等待A线程 doing");
                    // wait()的执行前提是当前线程获取了对象控制权,否则会报错:java.lang.IllegalMonitorStateException
                    this.wait();
                    log.info("B线程等待A线程 done");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("B线程执行完成.");
            }
        }
    }

    @AllArgsConstructor
    static class ThreadA implements Runnable {
        private final Object obj;

        @SneakyThrows
        @Override
        public void run() {
            synchronized (obj) {
                // notify()不会立马释放对象锁,释放情景: 1.synchronized代码块执行完成; 2.主动释放 wait();
                obj.notify();
                log.info("A线程开始执行.");
                log.info("A线程执行完成.");
            }
        }
    }
}
