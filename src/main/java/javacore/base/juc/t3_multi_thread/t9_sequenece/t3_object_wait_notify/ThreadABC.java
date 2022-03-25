package javacore.base.juc.t3_multi_thread.t9_sequenece.t3_object_wait_notify;

import lombok.AllArgsConstructor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadABC {

    public static void main(String[] args) {

        ThreadC threadC = new ThreadC();
        ThreadB threadB = new ThreadB(threadC);
        ThreadA threadA = new ThreadA(threadB);

        // 线程池中 按顺序执行 A->B->C
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        // 注意: 同一个锁的执行顺序一定是 wait()-notify()
        // 因此: 这里一定是先让 线程C执行,然后B,再A, 否则会因为某个线程对象的notify()比wait()还先执行.
        executorService.execute(threadC);
        executorService.execute(threadB);
        executorService.execute(threadA);

        // 停止接受新任务,当已有任务将执行完,关闭线程池
        executorService.shutdown();
        while (!executorService.isTerminated()) {
            // 等待所有线程执行完成
        }
        System.out.println("over");
        System.exit(0);
    }

    @AllArgsConstructor
    static class ThreadA implements Runnable {
        private final Object obj;

        @Override
        public void run() {
            synchronized (obj) {
                System.out.println("A线程开始执行.");
                System.out.println("A线程执行完成.");
                obj.notify();
            }
        }
    }

    @AllArgsConstructor
    static class ThreadB implements Runnable {
        private final Object obj;

        @Override
        public void run() {
            synchronized (this) {
                try {
                    System.out.println("B线程等待A线程 doing");
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // notify()不会立马释放对象锁,释放情景: 1.synchronized代码块执行完成; 2.主动释放 wait();
                this.notify();
                System.out.println("B线程等待A线程 done");
            }
            synchronized (obj) {
                System.out.println("B线程 doing");
                System.out.println("B线程 done");
                obj.notify();
            }
        }
    }


    static class ThreadC implements Runnable {
        @Override
        public void run() {
            synchronized (this) {
                try {
                    System.out.println("C线程等待AB线程 doing.");
                    this.wait();
                    System.out.println("C线程等待AB线程 done");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("C线程执行 done");
            }
        }
    }


}
