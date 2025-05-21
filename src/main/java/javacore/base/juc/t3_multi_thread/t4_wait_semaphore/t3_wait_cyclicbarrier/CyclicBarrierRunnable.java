package javacore.base.juc.t3_multi_thread.t4_wait_semaphore.t3_wait_cyclicbarrier;


import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by
 *
 * @date :   2018-08-22
 */

@Slf4j
public class CyclicBarrierRunnable implements Runnable {

    private CyclicBarrier cyclicBarrier;

    public CyclicBarrierRunnable(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @SneakyThrows
    @Override
    public void run() {
        log.info(Thread.currentThread().getName() + "准备吃饭");
        String name = Thread.currentThread().getName();
        String substring = Thread.currentThread().getName().substring(name.length() - 1, name.length());
        Integer integer = Integer.valueOf(substring);
        Thread.sleep(integer * 1000);
        processCommand();
        Thread.sleep(integer * 1000);
        log.info(Thread.currentThread().getName() + " 吃完.");
    }

    private void processCommand() {
        log.info(Thread.currentThread().getName() + "已上座就位");
        try {
            cyclicBarrier.await();
            log.info(Thread.currentThread().getName() + "看到人全部到齐,开始吃饭");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
