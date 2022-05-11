package javacore.base.juc.t3_multi_thread.t5_futuretask.t2_executorservice_submit_block;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by
 *
 * @date :   2018-08-22
 */

@Slf4j
public class Run {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // 实际上 ExecutorService.submit 还是用 FutureTask
        Future<String> future = executorService.submit(new MyRunnable("My MyRunnable.", 3000), "成功");

        try {
            // 设置线程超时时间,会阻塞主线程,除非线程完成或者超时
            String s = future.get(1000, TimeUnit.MILLISECONDS);
            System.out.println(s);
        } catch (InterruptedException | ExecutionException e) {
            log.error("异常");
            e.printStackTrace();
        } catch (TimeoutException e) {
            log.error("超时");
            // 尝试中断线程,否则新开线程会继续执行该任务,直到完成
            future.cancel(true);
        } finally {
            // 停止接受新任务,试图中断已有任务,返回未执行任务列表
            executorService.shutdownNow();
        }
        System.out.println("Threads Have Finished");
    }
}
