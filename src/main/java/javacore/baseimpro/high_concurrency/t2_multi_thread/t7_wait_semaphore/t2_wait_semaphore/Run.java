package javacore.baseimpro.high_concurrency.t2_multi_thread.t7_wait_semaphore.t2_wait_semaphore;

import javacore.baseimpro.high_concurrency.t2_multi_thread.t2_runnable_thread.ThreadFactoryImpl;

import java.util.concurrent.*;

public class Run {

    /**
     * 模拟 10个学生排队,3个取餐窗口
     */
    public static void main(String[] args) {

        // 取餐窗口3个
        int foodWindowsNum = 3;
        Semaphore semaphore = new Semaphore(foodWindowsNum);

        // 学生10个
        int studentNum = 10;
        ExecutorService executor = new ThreadPoolExecutor(studentNum, 200, 2, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(1024), new ThreadFactoryImpl("student-"));

        for (int i = 0; i < studentNum; i++) {
            executor.execute(new MyRunable(semaphore));
        }


    }
}
