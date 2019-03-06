package javacore.multi_thread_threadpool_futuretask.futuretask.futureTaskTest;

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
        System.err.println("=====waiting========");
        Thread.sleep(2000);
        return "-- 返回 --";
    }

    private final Thread thread = new Thread(future);

    public void start() {
        thread.start();
    }

    public String get() throws InterruptedException, ExecutionException, TimeoutException {
        try {
            return future.get(1, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            //future.cancel(true); //取消任务
            System.err.println("火速返回，失败！");
            return future.get(10, TimeUnit.SECONDS);
        }
    }

    /**
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     * @throws TimeoutException
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        FutureTaskTest test = new FutureTaskTest();
        test.start();
        System.err.println("=======begin========");
        System.err.println(test.get());
        System.err.println("=======end========");
    }

}

