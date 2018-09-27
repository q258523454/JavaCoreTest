package javacore.MultiThread.ThreadPoolTimeOut_Block;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-08-22
 */

public class Run {


    // 新开线程, 设置超时时间 [主线程会阻塞, 除非线程完成或者超时]
    public static Logger log = LoggerFactory.getLogger(Run.class);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<?> future = executorService.submit(new WorkerThread("My WorkerThread.", 1900));

        try {
            future.get(2000, TimeUnit.MILLISECONDS); // 设置线程超时时间, 会阻塞主线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            future.cancel(true);    // 中断线程,否则新开线程会继续执行该任务,直到完成
            log.error("已超时");
            e.printStackTrace();
        }finally {
            executorService.shutdownNow(); // 关闭线程池
        }

        System.out.println("Threads Have Finished");
    }
}
