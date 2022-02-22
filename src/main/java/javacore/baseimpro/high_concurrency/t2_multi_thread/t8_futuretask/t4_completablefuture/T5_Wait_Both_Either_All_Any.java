package javacore.baseimpro.high_concurrency.t2_multi_thread.t8_futuretask.t4_completablefuture;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class T5_Wait_Both_Either_All_Any {


    /**
     * -combine/both        适用场景: c等待a,b都执行完
     * 输入输出参考 -run,-accept,-apply
     * runAfterBothAsync    特点: 无输入,无输出
     * thenAcceptBothAsync  特点: 有输入,无输出
     * thenCombineAsync     特点: 有输入,有输出
     *
     * -either  后缀的方法,只要有1个执行完,就立马消费
     * 输入输出参考 -run,-accept,-apply
     * runAfterEitherAsync  特点: 无输入,无输出
     * acceptEitherAsync    特点: 有输入,无输出
     * applyToEitherAsync   特点: 有输入,有输出
     *
     * -allOf 等待所有future执行完成, 无返回值
     * -anyOf 等待某一个future执行完, 返回最快future值(Object)
     *
     */
    @SneakyThrows
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Object> a = CompletableFuture.supplyAsync(() -> {
            System.out.println("A");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("A执行完成.");
            return "A";
        }, Executors.newFixedThreadPool(5));

        CompletableFuture<Object> b = CompletableFuture.supplyAsync(() -> {
            System.out.println("B");
            return "B";
        }, Executors.newFixedThreadPool(5));


        // both/allOf
        CompletableFuture<Void> both = both(a, b);
        CompletableFuture<Void> allOf = allOf(a, b);
        System.out.println("main thread.");
        /**
         * future.join(): 阻塞的等待(不抛出异常,除非是unchecked)
         * future.get(): 阻塞的等待(有异常则抛出)
         * future.get(1,TimeUnit.Hours): 有异常则抛出异常，最长等待1个小时，一个小时之后，如果还没有数据，则异常。
         */
        both.get();
        allOf.get();

        System.out.println("----------------------------------------");

        // either/anyOf
        CompletableFuture<Void> either = either(a, b);
        CompletableFuture<Object> anyOf = anyOf(a, b);
        either.get();
        anyOf.get();

        // 主线程不能立马关闭, 否则子线程会直接中断
        Thread.sleep(2000);
        System.exit(0);
    }

    @SneakyThrows
    public static CompletableFuture<Void> both(CompletableFuture<Object> a, CompletableFuture<Object> b) {
        CompletableFuture<Void> both = a.thenAcceptBothAsync(b, new BiConsumer<Object, Object>() {
            @Override
            public void accept(Object o, Object o2) {
                System.out.println("both,输入:" + o.toString() + ",输出:" + o2.toString());
            }
        }, Executors.newFixedThreadPool(5));

        return both;
    }

    @SneakyThrows
    public static CompletableFuture<Void> allOf(CompletableFuture<Object> a, CompletableFuture<Object> b) {
        CompletableFuture<Void> allOf = CompletableFuture.allOf(a, b);
        allOf.thenAccept(new Consumer<Void>() {
            @Override
            public void accept(Void aVoid) {
                System.out.println("allOf,无输入输出");
            }
        });
        return allOf;
    }

    @SneakyThrows
    public static CompletableFuture<Void> either(CompletableFuture<Object> a, CompletableFuture<Object> b) {
        CompletableFuture<Void> either = a.acceptEitherAsync(b, new Consumer<Object>() {
            @Override
            public void accept(Object o) {
                System.out.println("either,输入:" + o.toString());
            }
        }, Executors.newFixedThreadPool(5));
        return either;
    }

    @SneakyThrows
    public static CompletableFuture<Object> anyOf(CompletableFuture<Object> a, CompletableFuture<Object> b) {
        CompletableFuture<Object> anyOf = CompletableFuture.anyOf(a, b);
        anyOf.thenAccept(new Consumer<Object>() {
            @Override
            public void accept(Object o) {
                System.out.println("anyOf,输入:" + o.toString());
            }
        });
        return anyOf;
    }

}
