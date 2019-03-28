package javacore.multi_thread.test7_threadpool_futuretask.test3_futuretask.test1_futureTaskTest;

import java.util.concurrent.*;

/**
 * Created By
 *
 * @author :   zhangjian
 * @date :   2018-09-27
 */
public class FutureTaskTest {

    private final FutureTask<String> future = new FutureTask<String>(
            new Callable<String>() {
                public String call() throws InterruptedException {
                    return aTask();
                }
            });

    public String aTask() throws InterruptedException {
        System.out.println("=====waiting========");
        Thread.sleep(2000);
        return "成功返回";
    }

    private final Thread thread = new Thread(future);

    public void start() {
        thread.start();
    }

    public String get() throws InterruptedException, ExecutionException, TimeoutException {
        try {
            return future.get(1000, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            //future.cancel(true); //取消任务
            System.out.println("1秒内返回，失败！重新计算时间");
            return future.get(500, TimeUnit.MILLISECONDS); // 会抛出TimeoutException
//            return future.get(5000, TimeUnit.MILLISECONDS);
        }
    }

    /**
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     * @throws TimeoutException
     */
    public static void main(String[] args) {
        FutureTaskTest test = new FutureTaskTest();
        test.start();
        System.out.println("=======begin========");
        try {
            System.out.println(test.get());
        } catch (Exception e) {
            System.out.println("规定时间内返回失败.");
            e.printStackTrace();
        }
        System.out.println("=======end========");
    }

}

