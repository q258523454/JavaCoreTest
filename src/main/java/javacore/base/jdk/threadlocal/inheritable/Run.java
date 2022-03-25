package javacore.base.jdk.threadlocal.inheritable;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Run {

    public static void main(String[] args) {
        try {
            log.info("在[主线程]中取值 inheritableThreadLocal=" + MyInheritableThreadLocalTest.inheritableThreadLocal.get());
            log.info("在[主线程]中取值 integerThreadLocal=" + MyInheritableThreadLocalTest.integerThreadLocal.get());
            Thread.sleep(500);
            // MyInheritableThreadLocalTest 静态变量值会初始化一次, 子类线程 ThreadLocal无法共享内存,因此值是null
            MySubThread t = new MySubThread();
            t.start();
            // 等待线程执行完毕
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
