package javacore.baseimpro.high_concurrency.t2_multi_thread.t2_runnable_thread;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description 自定义 ThreadFactory
 * ExecutorService 默认就是 {@link java.util.concurrent.Executors}中的 DefaultThreadFactory
 * @date 2020-06-28 20:07
 * @modify
 */
public class ThreadFactoryImpl implements ThreadFactory {
    private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
    private final ThreadGroup group;
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private final String namePrefix;


    /**
     * 不提供无参构造函数,强制给线程取名字
     * 好的线程组名称可帮助我们更快的 jstack 定位问题
     */
    public ThreadFactoryImpl(String name) {
        SecurityManager s = System.getSecurityManager();
        group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
        namePrefix = "pool-" + POOL_NUMBER.getAndIncrement() + "-thread-" + name;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
        if (t.isDaemon()) {
            t.setDaemon(false);
        }
        if (t.getPriority() != Thread.NORM_PRIORITY) {
            t.setPriority(Thread.NORM_PRIORITY);
        }
        return t;
    }
}
