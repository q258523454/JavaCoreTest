package javacore.base.juc.t3_multi_thread.t4_wait_semaphore.t2_wait_countdownlatch;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by
 *
 * @date :   2018-08-22
 */


@Slf4j
public class Run {

    public static void main(String[] args) throws InterruptedException {

        log.info("主线程开始执行");
        int theadNum = 5;
        // CountDownLatch 需要将对象传入需要'等待完成'的线程对象中
        CountDownLatch countDownLatch = new CountDownLatch(theadNum);
        ExecutorService executorService = Executors.newFixedThreadPool(theadNum);
        Runnable worker = new CountDownLatchRunnable("Task", countDownLatch);

        // 创建5个线程, 提交到线程池
        for (int i = 0; i < theadNum; i++) {
            executorService.execute(worker); // 同一个实例对象
        }
        // 等待所有线程执行完成(线程阻塞)
        countDownLatch.await();

        Thread.sleep(100);
        log.info("主线程完成等待");

        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }
        log.info("结束");
    }
}
