package javacore.baseimpro.high_concurrency.t2_multi_thread.t8_futuretask.t4_completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class T1_Base_Async {


    /**
     * 有后缀 -Async 究竟有什么区别?
     * 以 thenRun 和 thenRunAsync 为例, 功能都是等待线程执行.
     * 区别主要在线程池的使用上:
     * thenRun(Runnable action): 沿用上一个任务的线程池
     * thenRunAsync(Runnable action): 使用公用的 ForkJoinPool 线程池(不推荐使用公用线程池)
     * thenRunAsync(Runnable action,Executor executor): 使用自定义线程池(推荐)
     */
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        //  使用自定义线程池(推荐)
        CompletableFuture<Void> a = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":runAsync: A.");
        }, executorService);

        // 沿用上一个任务的线程池
        a.thenRun(() -> System.out.println(Thread.currentThread().getName() + ":thenRun：B."));
        // 使用公用的 ForkJoinPool 线程池(不推荐使用公用线程池)
        a.thenRunAsync(() -> System.out.println(Thread.currentThread().getName() + ":thenRunAsync：B."));

        System.out.println("main thread:" + Thread.currentThread().getName());
        // 主线程不能立马关闭, 否则子线程会直接中断
        Thread.sleep(1000);
        System.exit(0);
    }
}
