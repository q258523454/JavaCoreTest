package javacore.baseimpro.high_concurrency.t2_multi_thread.t7_wait_semaphore.t3_wait_countdownlatch;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

/**
 * Created by
 *
 * @date :   2018-08-22
 */

@Slf4j
public class CountDownLatchRunnable implements Runnable {
    private String command;
    private CountDownLatch countDownLatch;

    public CountDownLatchRunnable(String command, CountDownLatch countDownLatch) {
        this.command = command;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        log.info(Thread.currentThread().getName() + " 开始执行. Command = " + command);
        processCommand(command);
        log.info(Thread.currentThread().getName() + " 执行完成.");
    }

    private void processCommand(String command) {
        log.info("线程" + Thread.currentThread().getName() + ":, 正在进行操作:" + command);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }
    }
}
