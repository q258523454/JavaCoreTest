package javacore.base.juc.t3_multi_thread.t5_futuretask.t1_future_task_call_block;

import lombok.SneakyThrows;

import java.util.concurrent.*;

/**
 * Created By
 *
 * @date :   2018-09-27
 */
public class FutureTaskTest {


    public static String retryGet(FutureTask<String> future) throws InterruptedException, ExecutionException, TimeoutException {
        try {
            // 先等待1秒
            return future.get(1000, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            // 取消任务
            //future.cancel(true);
            System.out.println("1秒内,返回失败！重新等待..");
            // 继续等待2秒,未返回,会抛出 TimeoutException
            return future.get(1000, TimeUnit.MILLISECONDS);
        }
    }

    @SneakyThrows
    public static void main(String[] args) {
        final FutureTask<String> future = new FutureTask<>(
                new Callable<String>() {
                    @Override
                    public String call() throws InterruptedException {
                        System.out.println("Thread wait");
                        Thread.sleep(2000);
                        return "成功返回";
                    }
                });

        // 用一个线程执行
        new Thread(future).start();

        try {
            // 阻塞等待
            System.out.println(retryGet(future));
        } catch (Exception e) {
            System.out.println("规定时间内返回失败.");
            e.printStackTrace();
        }
        System.out.println("结束");
    }

}

