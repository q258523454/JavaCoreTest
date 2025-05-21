package javacore.base.juc.t3_multi_thread.t4_wait_semaphore.t2_wait_countdownlatch;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;


@Slf4j
public class CountDownLatchRunnable implements Runnable {
    private final String command;
    private final CountDownLatch countDownLatch;

    public CountDownLatchRunnable(String command, CountDownLatch countDownLatch) {
        this.command = command;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        log.info(Thread.currentThread().getName() + " start. Command = " + command);
        processCommand(command);
        log.info(Thread.currentThread().getName() + " finish.");
    }

    private void processCommand(String command) {
        log.info(Thread.currentThread().getName() + ":, doing work:" + command);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }
    }
}
