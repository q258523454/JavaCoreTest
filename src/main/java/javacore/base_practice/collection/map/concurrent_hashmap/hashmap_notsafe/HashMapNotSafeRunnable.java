package javacore.base_practice.collection.map.concurrent_hashmap.hashmap_notsafe;


import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.CountDownLatch;

@Slf4j
public class HashMapNotSafeRunnable implements Runnable {

    private String threadName = "";
    private Map<String, String> map = null;
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;

    public HashMapNotSafeRunnable(String threadName, Map<String, String> map, CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.map = map;
        this.threadName = threadName;
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    @Override
    public void run() {
        // 等待执行命令
        try {
            startSignal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 1000; i++) {
            map.put(threadName + "_" + i, i + "");
        }
        // 统计命令减1,用来判断是否所以线程执行完成
        doneSignal.countDown();
    }
}
