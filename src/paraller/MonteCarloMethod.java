package paraller;
// Created by ZhangJian on 17/12/22.

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MonteCarloMethod {
    private ConcurrentMap<Integer, Double> map = new ConcurrentHashMap<>();
    private int threadCount = Runtime.getRuntime().availableProcessors();
    private ExecutorService pool = Executors.newFixedThreadPool(threadCount);

    public static void main(String[] args) {
        // 执行次数
        long count = 100000000L;
        MonteCarloMethod bean = new MonteCarloMethod();
        bean.loop(count);
        bean.print();
    }

    private void loop(long count) {
        // 每个线程执行的个数
        long taskPerThread = count / threadCount;
        List<Future> futures = new ArrayList<>(threadCount);
        for (int i = 0; i < threadCount; i++) {
            futures.add(pool.submit(getTask(count, taskPerThread)));
        }
        // 等待执行完成
        futures.forEach(future -> {
            try {
                future.get();
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        pool.shutdown();
    }

    /**
     * 获取每个线程的执行任务
     *
     * @param count         总的任务数
     * @param taskPerThread 每个线程的任务数
     * @return 执行任务
     */
    private Runnable getTask(long count, long taskPerThread) {
        return () -> {
            double data = 1.0 / count;
            for (int i = 0; i < taskPerThread; i++) {
                map.compute(doTask(), (key, value) -> {
                    if (value == null)
                        return data;
                    else
                        return value + data;
                });
            }
        };
    }

    /**
     * 获取2个随机1到6的数字之和
     *
     * @return 随机数之和
     */
    private int doTask() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int first = random.nextInt(1, 7);
        int second = random.nextInt(1, 7);
        return first + second;
    }

    /**
     * 打印map内容
     */
    private void print() {
        map.entrySet().forEach(System.out::println);
    }
}