package javacore.baseimpro.high_concurrency.t2_multi_thread.t8_futuretask.t2_executorservice_submit_block;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

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
            e.printStackTrace();
            System.out.println("出现异常");
        } catch (TimeoutException e) {
            log.error("已超时");
            // 尝试中断线程,否则新开线程会继续执行该任务,直到完成
            future.cancel(true);
        } finally {
            executorService.shutdownNow(); // 关闭线程池
        }

        System.out.println("Threads Have Finished");
    }
}
