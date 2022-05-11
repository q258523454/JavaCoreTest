package javacore.base.juc.t2_synchronized.compare_this_method;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-02-27
 */
@Slf4j
public class T3_SynchronizedThis_Faster {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(50);

        final CountDownLatch latchOrder = new CountDownLatch(1);
        final CountDownLatch latchStart = new CountDownLatch(50);

        final T1_SynchonizedThis synchonizedThis = new T1_SynchonizedThis();

        for (int i = 0; i < 50; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        // 线程阻塞，等待主线程中执行 callOrder.countDown();
                        // CountDownLatch减数机制,等待 latchOrder=0
                        latchOrder.await();
                        synchonizedThis.started();
                        // 每执行一次started()方法，latch 减少1
                        latchStart.countDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            executor.execute(runnable);  //线程池执行其中的线程
        }
        try {
            Thread.sleep((long) (Math.random() * 1000));
            log.info("线程" + Thread.currentThread().getName() + "发布执行命令");
            // 让线程池中的线程得以执行，下面主要是统计线程池中的线程得执行时间
            latchOrder.countDown();
            log.info("线程" + Thread.currentThread().getName() + "已经发送命令，正在等待结果");

            long beginTime = System.currentTimeMillis();
            // CountDownLatch减数机制,等待 latchStart=0, 即等待线程池中的线程执行完毕
            latchStart.await();
            long endTime = System.currentTimeMillis();
            log.info("线程" + Thread.currentThread().getName() + "已收到所有响应结果,所用时间为：" + (endTime - beginTime));
        } catch (Exception e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }
}

