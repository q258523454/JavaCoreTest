package javacore.baseimpro.high_concurrency.t2_multi_thread.t9_sequenece.t6_sephmore;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;


@Slf4j
public class ThreadABC {

    /**
     * Semaphore(信号量)
     * {@link Semaphore}
     */
    public static void main(String[] args) {
        // 3个线程需要2两个信号量,A->B需要一个,B->C需要一个
        Semaphore signalAB = new Semaphore(0);
        Semaphore signalBC = new Semaphore(0);

        A a = new A(signalAB);
        B b = new B(signalAB, signalBC);
        C c = new C(signalBC);

        // 线程池中 按顺序执行 A->B->C
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(b);
        executorService.execute(c);
        executorService.execute(a);

        // 停止接受新任务,当已有任务将执行完,关闭线程池
        executorService.shutdown();
        while (!executorService.isTerminated()) {
            // 等待所有线程执行完成
        }
        System.out.println("over");
        System.exit(0);

    }

    @AllArgsConstructor
    static class A implements Runnable {
        private Semaphore semaphoreAB;

        @SneakyThrows
        @Override
        public void run() {
            log.info("A");
            semaphoreAB.release();
        }
    }

    @AllArgsConstructor
    static class B implements Runnable {
        private Semaphore semaphoreAB;
        private Semaphore semaphoreBC;

        @SneakyThrows
        @Override
        public void run() {
            // semaphore 信号量-1,总数为0的时候会等待
            semaphoreAB.acquire();
            log.info("B");
            // semaphore 信号量+1
            semaphoreBC.release();
        }
    }

    @AllArgsConstructor
    static class C implements Runnable {
        private Semaphore semaphoreBC;

        @SneakyThrows
        @Override
        public void run() {
            semaphoreBC.acquire();
            log.info("C");
        }
    }
}
