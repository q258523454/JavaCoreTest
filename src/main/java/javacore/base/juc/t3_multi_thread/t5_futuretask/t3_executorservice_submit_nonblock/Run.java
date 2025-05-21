package javacore.base.juc.t3_multi_thread.t5_futuretask.t3_executorservice_submit_nonblock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;


@Slf4j
public class Run {

    /**
     * futuretask.get()会阻塞执行线程
     * 如果的 子线程 1.有返回值; 2.需要判断超时
     * 则用嵌套子线程来实现非阻塞
     */
    public static void main(String[] args) throws InterruptedException {
        final ExecutorService background = Executors.newSingleThreadExecutor();
        log.info("主线程:开始");

        // 非阻塞 futuretask 建议直接使用: CompletableFuture
        background.execute(new Runnable() {
            @Override
            public void run() {
                ExecutorService executorService = Executors.newFixedThreadPool(1);
                MyRunnable myRunnable = new MyRunnable("ztest", 1000);
                Future<String> future = executorService.submit(myRunnable, "成功");
                log.info("子线程:开始");
                try {
                    // 设置等待线程的超时时间
                    String res = future.get(1000, TimeUnit.MILLISECONDS);
                    log.info("子线程:" + res);
                } catch (InterruptedException e) {
                    log.error("嵌套子线程-被中断");
                } catch (ExecutionException e) {
                    log.error("嵌套子线程-运行异常");
                } catch (TimeoutException e) {
                    log.error("嵌套子线程-超时");
                    // 调用 thread.interrupt() 方法来中断嵌套子线程
                    // 嵌套子线程中必须判断 Thread.currentThread().isInterrupted()
                    future.cancel(true);
                    e.printStackTrace();
                }

                try {
                    String s = future.get();
                    log.info(s);
                } catch (Exception ex) {
                    // TODO
                }
            }
        });
        log.info("主线程-结束");

        // 停止接受新任务,当已有任务将执行完,关闭线程池
        background.shutdown();
        while (!background.isTerminated()) {
            // TODO
        }
        System.exit(0);

    }
}
