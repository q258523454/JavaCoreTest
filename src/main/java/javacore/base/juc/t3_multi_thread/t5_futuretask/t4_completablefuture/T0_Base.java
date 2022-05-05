package javacore.base.juc.t3_multi_thread.t5_futuretask.t4_completablefuture;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class T0_Base {
    /**
     * JDK1.8新增的
     * {@link java.util.concurrent.CompletableFuture}
     * 功能很强大
     *
     * API方法分类与记忆规律
     * CompletableFuture划分为以下几类：
     *
     * 1.创建类
     * runAsync             异步执行，无返回值
     * supplyAsync          异步执行，有返回值
     * anyOf                任意一个执行完成，就可以进行下一步动作
     * allOf                全部完成所有任务，才可以进行下一步任务
     * ...
     *
     * 2.接续类(回调行为,thenDo),CompletableFuture 最重要的特性，没有这个的话，CompletableFuture就没意义了
     * 每个都有对应的后缀 -Async
     * thenRun
     * thenAccept
     * thenApply
     * thenCombine
     * thenAcceptBoth
     * ...
     *
     * 3.控制类,用于主动控制CompletableFuture的完成行为
     * handle,,
     * complete
     * exceptionally
     * ...
     *
     * 4.状态取值类
     * future.join(): 阻塞的等待(不抛出异常,除非是unchecked)
     * future.get(): 阻塞的等待(有异常则抛出)
     * future.get(1,TimeUnit.Hours): 有异常则抛出异常，最长等待1个小时，一个小时之后，如果还没有数据，则异常。
     * 其他:
     * isCancelled
     * isCompletedExceptionally
     * isDone
     *
     * 记忆规则：
     * -supply  特点: 无输入,有输出
     *          写法: 开头的方法
     *          适用场景: 开头创建
     *
     * -run     特点: 无输入,无输出 (Runnable)
     *          写法: 开头的方法
     *          适用场景: 不关心输入输出
     *
     * -Accept  特点: 有输入,无输出
     *          写法: 开头或者结尾的方法
     *          适用场景: 上一个任务的结果作为下一个任务的输入
     *
     * -Apply   特点: 有输入,有输出
     *          写法: 开头或者结尾的方法
     *          适用场景: 需要输入且需要输出
     *
     * -Async   结尾的方法,两个重载的方法，一个是使用自带的forkjoin线程池，一种是使用自定义线程池
     *          对应无后缀Async 则沿用前一个任务的线程池
     *          例如: thenRun 和 thenRunAsync 为例, 功能都是等待线程执行.
     *          区别主要在线程池的使用上:
     *          thenRun(Runnable action): 沿用上一个任务的线程池
     *          thenRunAsync(Runnable action): 使用公用的 ForkJoinPool 线程池(不推荐使用公用线程池)
     *          thenRunAsync(Runnable action,Executor executor): 使用自定义线程池(推荐)
     *
     * -either  后缀的方法，表示谁先完成就消费谁
     * -both    后缀的方法, 所有任务都完成
     *
     */
    @SneakyThrows
    public static void main(String[] args) {
        // 示例: B 任务等待 A 任务做完后再执行
        // -supply: 无输入,有输出
        CompletableFuture<Object> future = CompletableFuture.supplyAsync(new Supplier<Object>() {
            @Override
            public Object get() {
                System.out.println("A");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "A";
            }
        }, Executors.newFixedThreadPool(5));
        /**
         * future.join(): 阻塞的等待(不抛出异常,除非是unchecked)
         * future.get(): 阻塞的等待(有异常则抛出)
         * future.get(1,TimeUnit.Hours): 有异常则抛出异常，最长等待1个小时，一个小时之后，如果还没有数据，则异常。
         */
        future.join();

        // 无输入,无输出
        thenRunAsync(future);
        // 有输入,无输出
        thenAcceptAsync(future);
        // 有输入, 有输出
        thenApplyAsync(future);

        System.out.println("main thread.");
        // 主线程不能立马关闭, 否则子线程会直接中断
        Thread.sleep(1000);

        System.exit(0);
    }

    // -Run, 无输入,无输出
    public static void thenRunAsync(CompletableFuture<Object> a) {
        CompletableFuture<Void> b = a.thenRunAsync(new Runnable() {
            @Override
            public void run() {
                System.out.println("thenRunAsync");
            }
        }, Executors.newFixedThreadPool(1));
    }

    // -Accept, 有输入,无输出
    public static void thenAcceptAsync(CompletableFuture<Object> a) {
        CompletableFuture<Void> b = a.thenAcceptAsync(new Consumer<Object>() {
            @SneakyThrows
            @Override
            public void accept(Object o) {
                System.out.println("thenAcceptAsync: 输入:" + o.toString());
            }
        }, Executors.newFixedThreadPool(1));
    }

    // -Apply, 有输入,有输出
    public static void thenApplyAsync(CompletableFuture<Object> a) {
        CompletableFuture<String> b = a.thenApplyAsync(new Function<Object, String>() {
            @Override
            public String apply(Object o) {
                String res = "B";
                System.out.println("thenApplyAsync: 输入:" + o.toString() + ",输出:" + res);
                return res;
            }
        }, Executors.newFixedThreadPool(1));
    }
}
