package javacore.base.jdk.threadlocal.read_error_data;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Run {

    public static void main(String[] args) {
        /**
         * 1.ThreadLocal 脏数据
         * 原因:线程复用,没有及时 ThreadLocal.remove()
         * 下一次线程复用的上一个线程(并不是新建的线程),那么会使用上次线程的ThreadLocal数据
         *
         * 2.ThreadLocal 内存泄露
         * 原因: 没有主动释放 ThreadLocal.remove()
         * 注意 {@link java.lang.ThreadLocal.ThreadLocalMap.Entry} 中弱引用并不是导致内存泄露的原因
         * 根本原因是 ThreadLocalMap 生命周期是跟线程一样长的,只要线程对象没有主动remove, 那ThreadLocalMap就会一直占用内存.
         */
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 2; i++) {
            executorService.execute(new ThreadLocalTest());
        }
        // 停止接受新任务,当已有任务将执行完,关闭线程池
        executorService.shutdown();
        while (!executorService.isTerminated()) {

        }
        System.exit(0);

    }

}