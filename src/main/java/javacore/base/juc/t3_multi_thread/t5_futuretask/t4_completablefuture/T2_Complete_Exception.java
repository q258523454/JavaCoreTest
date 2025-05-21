package javacore.base.juc.t3_multi_thread.t5_futuretask.t4_completablefuture;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class T2_Complete_Exception {
    @SneakyThrows
    public static void main(String[] args) throws InterruptedException {
        /**
         * 一个CompletableFuture完整的执行流程:
         * 1.创建线程:supply/run
         * 2.成功执行后:thenAccept/thenApply/thenRun
         * 3.不管有无异常都执行:whenComplete(无返回值) /handle (有返回值)
         * 4.出现异常后执行:exceptionally
         */
        System.out.println("-----------");
        whenComplete();
        System.out.println("-----------");

        System.out.println("-----------");
        handleTest();
        System.out.println("-----------");

        Thread.sleep(1000);
        System.exit(0);

    }

    /**
     * 一个CompletableFuture完整的执行流程:
     * 1.创建线程:supply/run
     * 2.成功执行后:thenAccept/thenApply/thenRun
     * 3.不管有无异常都执行:whenComplete(无返回值) /handle (有返回值)
     * 4.出现异常后执行:exceptionally
     */
    public static void whenComplete() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // 创建 a
        CompletableFuture<Integer> a = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int a = 0;
                return 100 / 2;
            }
        }, executorService);
        // a 成功执行后动作(a必须正常执行)
        a.thenAccept(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("thenAccept input:" + integer);
            }
        });

        // a 完成执行后动作(不管a有无异常)
        CompletableFuture<Integer> whenComplete = a.whenComplete(new BiConsumer<Integer, Throwable>() {
            @Override
            public void accept(Integer integer, Throwable throwable) {
                System.out.println("whenComplete input:" + integer);
            }
        });

        // 下面这行代码直接报错, 如果要用, 换成handle(允许返回)
        // whenComplete 是没有返回值的, whenComplete.get() 直接返回的 supplyAsync 结果, 有异常则直接会抛出
        //System.out.println("a任务完成,whenComplete return:" + whenComplete.get());

        // a 出现异常后动作
        CompletableFuture<Integer> exceptionally = a.exceptionally(new Function<Throwable, Integer>() {
            @Override
            public Integer apply(Throwable throwable) {
                System.out.println("error:" + throwable.getMessage());
                return 500;
            }
        });

        System.out.println("出现异常,return:" + exceptionally.get());
    }


    public static void handleTest() throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // 创建 a
        CompletableFuture<Integer> a = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int a = 0;
                return 100 / a;
            }
        }, executorService);
        // a 成功执行后动作(a必须正常执行完)
        a.thenAccept(integer -> System.out.println("thenAccept input:" + integer));

        // a 完成执行后动作(不管a有无异常)
        CompletableFuture<Object> handle = a.handle((integer, throwable) -> {
            System.out.println("handle input:" + integer);
            return 404;
        });

        // 这里换成 whenComplete 执行在则会报错, 因为 whenComplete 没有返回值, whenComplete.get() 返回的是 supplyAsync 执行结果(有异常)
        System.out.println("a任务完成,handle return:" + handle.get());

        // a 出现异常后动作
        CompletableFuture<Integer> exceptionally = a.exceptionally(throwable -> {
            System.out.println("error:" + throwable.getMessage());
            return 500;
        });

        System.out.println("出现异常,return:" + exceptionally.get());
    }


}
