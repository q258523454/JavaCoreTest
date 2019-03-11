package javacore.multi_thread.multi_thread_threadpool_futuretask.threadPoolWaitAll_AwaitTermination;

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
        Runnable worker = new MyRunnable("Task By Zhang", countDownLatch);

        // 创建5个线程, 提交到线程池
        for (int i = 0; i < theadNum; i++) {
            executorService.execute(worker);
        }

        // 关闭线程池
        executorService.shutdown();

        /***
         * 	shutdown()			: [非阻塞]	停止接受新任务,已有任务执行完
         *  shutdownNow()		: [非阻塞]	停止接受新任务,试图中断已有任务,返回未执行任务列表
         *  awaitTermination()	: [阻塞]		等待所有任务执行完, 或者超时时间到了, 或者线程被中断
         */

        // 等待线程池中所有的任务执行完成
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        System.out.println(theadNum + " Threads Have Finished");
    }
}
