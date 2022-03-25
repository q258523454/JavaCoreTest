package javacore.base.juc.t3_multi_thread.t9_sequenece.t7_futuretask_get;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class ThreadABC {
    /**
     * FutureTask
     * FutureTask 阻塞特性实现
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // 实际上 ExecutorService.submit 还是用的 FutureTask
        Object a = executorService.submit(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                log.info("A");
            }
        }).get();

        Object b = executorService.submit(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                log.info("B");
            }
        }).get();

        Object c = executorService.submit(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                log.info("C");
            }
        }).get();

        log.info("main thread done.");

        System.exit(0);
    }
}
