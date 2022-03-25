package javacore.base.jdk.threadlocal.read_error_data;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalTest implements Runnable {


    private static boolean flag = false;

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public void refreshThreadLocal() {
        threadLocal.remove();
    }

    @Override
    public void run() {
        System.out.println("当前线程名:" + Thread.currentThread().getName());
        synchronized (this) {
            if (!flag) {
                System.out.println("执行 threadLocal.set()");
                threadLocal.set("123");
                flag = true;
            }
            log.info("threadLocal:" + threadLocal.get());
        }
    }
}