package javacore.base.juc.t3_multi_thread.t7_wait_semaphore.t2_wait_semaphore;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MyRunable implements Runnable {

    private Semaphore semaphore;

    public MyRunable(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            // semaphore 信号量-1,总数为0的时候会等待
            semaphore.acquire();
            String name = Thread.currentThread().getName();
            String substring = Thread.currentThread().getName().substring(name.length() - 1, name.length());
            Integer integer = Integer.valueOf(substring);
            // 偶数学号学生饭量大，取餐会耗时多一点
            if (integer % 2 == 0) {
                log.info(Thread.currentThread().getName() + ",饭量较大,取餐缓慢C.");
                TimeUnit.MILLISECONDS.sleep(5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // semaphore 信号量+1
            semaphore.release();
            log.info(Thread.currentThread().getName() + ",完成取餐.");
        }
    }
}
