package javacore.MultiThread.ThreadPoolWaitAll_AwaitTermination;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-08-22
 */

public class Run {

    public static void main(String[] args) throws InterruptedException {
        int theadNum = 5;
        // CountDownLatch 需要将对象传入需要'等待完成'的线程对象中
        CountDownLatch countDownLatch = new CountDownLatch(theadNum);
        ExecutorService executorService = Executors.newFixedThreadPool(theadNum);
        Runnable worker = new WorkerThread("Task By Zhang", countDownLatch);

        // 创建5个线程, 提交到线程池
        for (int i = 0; i < theadNum; i++) {
            executorService.execute(worker);
        }

        // 关闭线程池
        executorService.shutdown();

        // 等待线程池中所有的任务执行完成
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

        System.out.println(theadNum + " Threads Have Finished");
    }
}
