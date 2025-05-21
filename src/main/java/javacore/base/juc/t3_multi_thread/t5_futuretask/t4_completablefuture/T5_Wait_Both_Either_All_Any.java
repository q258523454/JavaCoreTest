package javacore.base.juc.t3_multi_thread.t5_futuretask.t4_completablefuture;

import lombok.SneakyThrows;

import org.springframework.util.StopWatch;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class T5_Wait_Both_Either_All_Any {


    /**
     * -combine/both        适用场景: c等待a,b都执行完
     * 输入输出参考 -run,-accept,-apply
     * runAfterBothAsync    特点: 无输入,无输出
     * thenAcceptBothAsync  特点: 有输入,无输出
     * thenCombineAsync     特点: 有输入,有输出
     * <p>
     * -either  后缀的方法,只要有1个执行完,就立马消费
     * 输入输出参考 -run,-accept,-apply
     * runAfterEitherAsync  特点: 无输入,无输出
     * acceptEitherAsync    特点: 有输入,无输出
     * applyToEitherAsync   特点: 有输入,有输出
     * <p>
     * -allOf 等待所有future执行完成, 无返回值
     * -anyOf 等待某一个future执行完, 返回最快future值(Object)
     */
    @SneakyThrows
    public static void main(String[] args) throws InterruptedException {
        StopWatch stopWatch = new StopWatch();

        CompletableFuture<Object> bothA = FutureUtil.getFuture("A", 1000, 5);
        CompletableFuture<Object> bothB = FutureUtil.getFuture("B", 500, 5);
        CompletableFuture<Void> both = both(bothA, bothB);
        stopWatch.start("both");
        both.get();
        stopWatch.stop();

        CompletableFuture<Object> allOfA = FutureUtil.getFuture("A", 1000, 5);
        CompletableFuture<Object> allOfB = FutureUtil.getFuture("B", 500, 5);
        CompletableFuture<Void> allOf = allOf(allOfA, allOfB);
        stopWatch.start("allOf");
        allOf.get();
        stopWatch.stop();

        CompletableFuture<Object> eitherA = FutureUtil.getFuture("A", 500, 5);
        CompletableFuture<Object> eitherB = FutureUtil.getFuture("B", 1000, 5);
        CompletableFuture<Void> either = either(eitherA, eitherB);
        stopWatch.start("either");
        either.get();
        stopWatch.stop();

        CompletableFuture<Object> anyOfA = FutureUtil.getFuture("A", 1000, 5);
        CompletableFuture<Object> anyOfB = FutureUtil.getFuture("B", 500, 5);
        CompletableFuture<Object> anyOf = anyOf(anyOfA, anyOfB);
        stopWatch.start("anyOf");
        anyOf.get();
        stopWatch.stop();

        // 主线程不能立马关闭, 否则子线程会直接中断
        Thread.sleep(5000);
        System.out.println(stopWatch.prettyPrint());
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


    private static CompletableFuture<Object> getFuture() {
        return CompletableFuture.supplyAsync(new Supplier<Object>() {
            @Override
            public Object get() {
                System.out.println("A start");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("A end");
                return "A";
            }
        }, Executors.newFixedThreadPool(5));
    }
}
