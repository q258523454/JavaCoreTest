package javacore.base.juc.t3_multi_thread.t9_sequenece.t5_countdonwlatch_cyclicbarrier;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Slf4j
public class ThreadABC {

    /**
     * CountDownLatch(减数器)/ CyclicBarrier(栅栏)
     * {@link CountDownLatch}
     * {@link CyclicBarrier}
     */
    public static void main(String[] args) {
        // 3个线程需要2两个信号通知,A->B需要一个,B->C需要一个
        CountDownLatch signalAB = new CountDownLatch(1);
        CountDownLatch signalBC = new CountDownLatch(1);

        A a = new A(signalAB);
        B b = new B(signalAB,signalBC);
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
        private CountDownLatch latchAB;

        @SneakyThrows
        @Override
        public void run() {
            log.info("A");
            latchAB.countDown();
        }
    }

    @AllArgsConstructor
    static class B implements Runnable {
        private CountDownLatch latchAB;
        private CountDownLatch latchBC;

        @SneakyThrows
        @Override
        public void run() {
            latchAB.await();
            log.info("B");
            latchBC.countDown();
        }
    }

    @AllArgsConstructor
    static class C implements Runnable {
        private CountDownLatch latchBC;

        @SneakyThrows
        @Override
        public void run() {
            latchBC.await();
            log.info("C");
        }
    }
}
