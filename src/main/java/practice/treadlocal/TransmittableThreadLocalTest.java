package practice.treadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TransmittableThreadLocalTest {

    private static final TransmittableThreadLocal<String> context = new TransmittableThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        ttlExecutorsTest();
        ttlRunnableTest();
    }

    /**
     * 方法一: 使用 TtlExecutors 来
     */
    private static void ttlExecutorsTest() {
        ExecutorService executor = TtlExecutors.getTtlExecutorService(Executors.newFixedThreadPool(1));
        // 设置父线程变量值
        context.set("父线程 trace=1");
        executor.submit(() -> System.out.println("ttlExecutorsTest 第1次任务: " + context.get()));

        // 修改父线程变量值
        context.set("父线程 trace=2");
        executor.submit(() -> System.out.println("ttlExecutorsTest 第2次任务: " + context.get()));
        executor.shutdown();
    }


    private static void ttlRunnableTest() {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        // 设置父线程变量值
        context.set("父线程 trace=1");
        executor.submit(TtlRunnable.get(() -> {
            System.out.println("ttlRunnableTest 第1次任务: " + context.get());
        }));

        // 修改父线程变量值
        context.set("父线程 trace=2");
        executor.submit(TtlRunnable.get(() -> {
            System.out.println("ttlRunnableTest 第2次任务: " + context.get());
        }));
        executor.shutdown();
    }
}