package javacore.multi_thread_base.synchronized_compare;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-02-27
 */
public class Synchronized_CompareFaster {
    public static void main(String[] args) {

        ExecutorService service = Executors.newCachedThreadPool();
        final CountDownLatch callOrder = new CountDownLatch(1);
        final CountDownLatch latch = new CountDownLatch(3);

        final SynchonizedThis sc = new SynchonizedThis();

        for (int i = 0; i < 3; i++) {
            Runnable runnable = new Runnable() {
                public void run() {
                    try {
                        callOrder.await();  // 线程阻塞，等待主线程中执行 callOrder.countDown();
                        sc.started();
                        latch.countDown();  // 每执行一次started()方法，latch 减少1
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            };
            service.execute(runnable);  // 线程池执行其中的线程
        }
        try {
            Thread.sleep((long) (Math.random() * 1000));
            System.out.println("线程" + Thread.currentThread().getName() + "发布执行命令");
            callOrder.countDown();  //让线程池中的线程得以执行，下面主要是统计线程池中的线程得执行时间
            System.out.println("线程" + Thread.currentThread().getName() + "已经发送命令，正在等待结果");

            long beginTime = System.currentTimeMillis();
            latch.await();  //等待线程池中的线程执行完毕
            long endTime = System.currentTimeMillis();
            System.out.println("线程" + Thread.currentThread().getName() + "已收到所有响应结果,所用时间为：" + (endTime - beginTime));
        } catch (Exception e) {
            e.printStackTrace();
        }
        service.shutdown();
    }
}

