package practice.treadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InheritableThreadLocalTest {

    private static final InheritableThreadLocal<String> context = new InheritableThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        // 使用线程池创建子线程（问题场景）
        ExecutorService executor = Executors.newFixedThreadPool(1);
        context.set("父线程 trace=1");

        // 提交任务到线程池
        executor.submit(() -> {
            // 输出: trace=1
            System.out.println("线程池任务: " + context.get());
        });

        // 线程已创建，无法继承新值
        context.set("父线程 trace=2");
        executor.submit(() -> {
            // 输出: trace=1,不会继承新值
            System.out.println("线程池任务: " + context.get());
        });

        executor.shutdown();
    }
}