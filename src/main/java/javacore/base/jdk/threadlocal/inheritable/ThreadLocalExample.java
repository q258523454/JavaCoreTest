package javacore.base.jdk.threadlocal.inheritable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ThreadLocalExample {
    public static void main(String[] args) {
        // 使用 ThreadLocal
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("Value in main thread (ThreadLocal)");
        System.out.println("Value in main thread (ThreadLocal): " + threadLocal.get());

        // 创建线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            // 子线程无法获取父线程中 ThreadLocal 的值
            System.out.println("Value in child thread (ThreadLocal): " + threadLocal.get());
        });
        executorService.shutdown();

        // 使用 InheritableThreadLocal
        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
        inheritableThreadLocal.set("Value in main thread (InheritableThreadLocal)");
        System.out.println("Value in main thread (InheritableThreadLocal): " + inheritableThreadLocal.get());

        // 创建线程池
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        executorService2.submit(() -> {
            // 子线程可以获取父线程中 InheritableThreadLocal 的值
            System.out.println("Value in child thread (InheritableThreadLocal): " + inheritableThreadLocal.get());
        });
        executorService2.shutdown();
    }
}