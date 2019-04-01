package javacore.multi_thread.test7_threadpool_futuretask.test1_threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-08-22
 */

public class Run2 {

    public static void main(String[] args) {
        int theadNum = 5;

        // 方式一: 直接用 Executors 创建 ExecutorService 对象
        // ExecutorService executorService1 = Executors.newFixedThreadPool(theadNum);

        // 方式二: 用 ThreadPoolExecutor 构造方法, 实际上 Executors 也是用的该方法, 只不过构造参数已经帮我们定义好了
        // 【阿里巴巴推荐——方法二】
        // 下面的代码等价于 ExecutorService executorService = Executors.newFixedThreadPool(theadNum);
        ExecutorService executorService2 = new ThreadPoolExecutor(theadNum, theadNum, 0L, TimeUnit.SECONDS, new LinkedBlockingDeque<>());

        Runnable worker = new WorkerThread("Task By Zhang");

        // 创建5个线程, 提交到线程池
        for (int i = 0; i < theadNum; i++) {
            executorService2.execute(worker);
        }

        executorService2.shutdown(); // 关闭线程池, 不会影响已执行的线程的执行

        while (!executorService2.isTerminated()) {
            // 等待所有线程执行完成
        }
        System.out.println(theadNum + " Threads Have Finished");
    }
}
