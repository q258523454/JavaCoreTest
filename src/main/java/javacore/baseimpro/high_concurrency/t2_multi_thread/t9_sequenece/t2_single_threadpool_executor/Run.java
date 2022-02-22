package javacore.baseimpro.high_concurrency.t2_multi_thread.t9_sequenece.t2_single_threadpool_executor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Run {


    /**
     * SingleThreadExecutor(单线程池)
     * {@link java.util.concurrent.LinkedBlockingQueue} 保证了FIFO顺序
     */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        // CountDownLatch减数机制,countDown触发await,达到同时执行的目的
        CountDownLatch latch = new CountDownLatch(1);

        List<String> threadNameList = Arrays.asList("A", "B", "C");
        for (int i = 0; i < 3; i++) {
            executorService.execute(new MyRunnable(threadNameList.get(i), latch));
        }

        latch.countDown();
        executorService.shutdown();
        while (!executorService.isTerminated()) {
            // 等待所有线程执行完成
        }
        System.exit(0);
    }

}
