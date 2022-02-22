package javacore.baseimpro.high_concurrency.t2_multi_thread.t7_wait_semaphore.t3_wait_countdownlatch;

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


    /**
     * CountDownLatch :
     * 减数机制,1个线程等待多个线程执行完成,如果再次使用需要重新初始化 CountDownLatch。
     * 场景:老师等待考生交卷
     *
     * CyclicBarrier
     * 加数机制,多个线程互相等待,可重复使用,无需初始化。
     * 场景:一张桌子吃饭(酒席)，跑步比赛,机场安检(一次进10个)
     */
    public static void main(String[] args) throws InterruptedException {

        log.info("主线程开始执行");
        int theadNum = 5;
        // CountDownLatch 需要将对象传入需要'等待完成'的线程对象中
        CountDownLatch countDownLatch = new CountDownLatch(theadNum);
        ExecutorService executorService = Executors.newFixedThreadPool(theadNum);
        Runnable worker = new CountDownLatchRunnable("Task By Zhang", countDownLatch);

        // 创建5个线程, 提交到线程池
        for (int i = 0; i < theadNum; i++) {
            executorService.execute(worker); // 同一个实例对象
        }
        // 等待所有线程执行完成(线程阻塞)
        countDownLatch.await();

        Thread.sleep(100);
        log.info("主线程完成等待");

        // 关闭线程池,并不是终止线程运行,而是禁止新添加任务
        executorService.shutdown();

    }
}
