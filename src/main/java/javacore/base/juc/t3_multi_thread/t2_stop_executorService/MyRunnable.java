package javacore.base.juc.t3_multi_thread.t2_stop_executorService;


import lombok.extern.slf4j.Slf4j;

/**
 * Created by
 *
 * @date :   2018-08-22
 */

@Slf4j
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        log.info(Thread.currentThread().getName() + " Start.");
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info(Thread.currentThread().getName() + " End.");
    }

}
