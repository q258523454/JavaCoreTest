package javacore.baseimpro.high_concurrency.t2_multi_thread.t9_sequenece.t8_completablefuture;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class ThreadABC {

    /**
     * CompletableFuture (推荐)
     * JDK1.8中 CompletableFuture提供了非常强大的Future的扩展功能，简化异步编程，
     * 提供函数式编程的能力，可帮助我们完成复杂的线程的阶段行编程(CompletionStage)
     * {@link java.util.concurrent.CompletableFuture}
     */
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // 有a,b,c三个线程(任务)
        Runnable a = () -> log.info("A");
        Runnable b = () -> log.info("B");
        Runnable c = () -> log.info("C");

        // 异步执行
        CompletableFuture.runAsync(a, executorService).thenRun(b).thenRun(c);

        log.info("main thread.");
        // 停止接受新任务,当已有任务将执行完,关闭线程池
        executorService.shutdown();
        while (!executorService.isTerminated()) {
            // 等待所有线程执行完成
        }
        System.exit(0);
    }
}
