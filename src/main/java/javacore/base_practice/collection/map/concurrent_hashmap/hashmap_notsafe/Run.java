package javacore.base_practice.collection.map.concurrent_hashmap.hashmap_notsafe;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import javacore.base.juc.t3_multi_thread.t0_runnable_thread.ThreadFactoryImpl;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

@Slf4j
public class Run {

    public static void main(String[] args) throws InterruptedException {
        HashMap<String, String> hashMap = new HashMap<>(1000);
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>(1000);

        for (int i = 0; i < 10; i++) {
            // HashMap 线程不安全
            test(hashMap);
        }
        for (int i = 0; i < 10; i++) {
            // ConcurrentHashMap 线程安全
            test(concurrentHashMap);
        }
        System.exit(0);
    }

    public static void test(Map<String, String> map) throws InterruptedException {
        final CountDownLatch startSignal = new CountDownLatch(1);
        final CountDownLatch doneSignal = new CountDownLatch(10);
        ExecutorService executor = new ThreadPoolExecutor(10, 200, 2, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(1024), new ThreadFactoryImpl("hashmap_notsafe"));
        for (int i = 0; i < 10; i++) {
            HashMapNotSafeRunnable runnableTest = new HashMapNotSafeRunnable("name_" + i, map, startSignal, doneSignal);
            executor.execute(runnableTest);
        }
        // 开始执行
        startSignal.countDown();
        // 等待所有线程执行完毕
        doneSignal.await();
        log.info(String.valueOf(map.size()));
    }
}
