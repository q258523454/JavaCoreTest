package javacore.base.juc.t3_multi_thread.t2_stop_executorService;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by
 *
 * @date :   2018-08-22
 */
@Slf4j
public class Run {

    public static void main(String[] args) throws InterruptedException {
        int theadNum = 5;
        // CountDownLatch 需要将对象传入需要'等待完成'的线程对象中
        ExecutorService executorService = Executors.newFixedThreadPool(theadNum);

        // 创建5个线程, 提交到线程池
        for (int i = 0; i < theadNum; i++) {
            executorService.execute(new MyRunnable());
        }


        /***
         * 	shutdown()			: [非阻塞]	停止接受新任务,当已有任务将执行完,关闭线程池
         *  shutdownNow()		: [非阻塞]	停止接受新任务,试图中断已有任务,返回未执行任务列表
         *  awaitTermination()	: [阻塞]		等待所有任务执行完, 或者超时时间到了, 或者线程被中断, 注意:不会立即关闭ExecutorService，只是定时检测是否关闭
         *
         *  关闭功能 【从强到弱】 依次是：shuntdownNow() > shutdown() > awaitTermination()
         */


        // 停止接受新任务,当已有任务将执行完,关闭线程池
        executorService.shutdown();

        // 等待线程池中所有的任务执行完成, 前提是执行了 shutdown
        while (!executorService.isTerminated()) {
            // 等待所有线程执行完成
        }
        log.info("executorService.isTerminated():" + executorService.isTerminated());
        log.info("executorService.isShutdown():" + executorService.isShutdown());

        log.info(theadNum + " Threads Have Finished");
    }
}
