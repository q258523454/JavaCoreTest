package javacore.MultiThread.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-08-22
 */

public class Run {

    public static void main(String[] args) {
        int theadNum = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(theadNum);
        Runnable worker = new WorkerThread("Task By Zhang");

        // 创建5个线程, 提交到线程池
        for (int i = 0; i < theadNum; i++) {
            executorService.execute(worker);
        }

        executorService.shutdown(); // 关闭线程池, 不会影响线程的执行

        while (!executorService.isTerminated()) {
            // 等待所有线程执行完成
        }
        System.out.println(theadNum + " Threads Have Finished");
    }
}
