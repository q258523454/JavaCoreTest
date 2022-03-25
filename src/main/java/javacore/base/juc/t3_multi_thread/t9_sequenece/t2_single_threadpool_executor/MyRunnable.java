package javacore.base.juc.t3_multi_thread.t9_sequenece.t2_single_threadpool_executor;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;


@Slf4j
public class MyRunnable implements Runnable {

    /**
     * 自定义线程名
     */
    private String threadName;

    /**
     * CountDownLatch指令
     */
    private CountDownLatch latch;

    public MyRunnable(String threadName, CountDownLatch latch) {
        this.threadName = threadName;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            // 等待 countDownLatch.countDown() 命名
            latch.await();
            System.out.println(threadName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

