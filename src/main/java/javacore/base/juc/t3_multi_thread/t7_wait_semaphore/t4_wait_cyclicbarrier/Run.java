package javacore.base.juc.t3_multi_thread.t7_wait_semaphore.t4_wait_cyclicbarrier;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


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

        // 一张桌子只能坐3个人
        int tableNum = 3;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(tableNum);

        // 9个人排队吃饭
        int theadNum = 9;
        ExecutorService executorService = Executors.newFixedThreadPool(theadNum);
        Runnable worker = new CyclicBarrierRunnable(cyclicBarrier);
        for (int i = 0; i < theadNum; i++) {
            executorService.execute(worker); // 同一个实例对象
        }

        Thread.sleep(100);
        log.info("主线程完成等待,下一桌人员开始就餐入席（同样等待全部到齐才开席）");

        // 关闭线程池,并不是终止线程运行,而是禁止新添加任务
        executorService.shutdown();

    }
}
