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
        for (int i = 0; i < theadNum; i++) {
            executorService.execute(worker);
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {
            // wating finished
        }
        System.out.println(theadNum + " Threads Have Finished");
    }
}
