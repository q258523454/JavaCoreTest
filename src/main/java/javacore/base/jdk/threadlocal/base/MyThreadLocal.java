package javacore.base.jdk.threadlocal.base;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyThreadLocal implements Runnable {

    /**
     * 实例(对象)变量
     */
    int local = 0;
    /**
     * 静态变量(全局)
     */
    public static int global = 0;
    /**
     * 线程共享变量, 一般都是static, 避免对象多次new, 不仅消耗内存且导致threadLocal的共享值不一致
     */
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    @Override
    public void run() {
        synchronized (this) {
            if (0 == local) {
                local = (int) (Math.random() * 100D);
            }
            if (0 == global) {
                global = (int) (Math.random() * 100D);
            }
            log.info("local:" + local);
            log.info("global:" + global);
        }
        if (null == threadLocal.get()) {
            threadLocal.set((int) (Math.random() * 100D));
        }
        log.info(Thread.currentThread() + ":threadLocal:" + threadLocal.get());

    }
}