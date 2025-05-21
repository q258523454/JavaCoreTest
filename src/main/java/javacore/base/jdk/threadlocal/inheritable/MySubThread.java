package javacore.base.jdk.threadlocal.inheritable;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MySubThread extends Thread {
    @Override
    public void run() {
        log.info("在[子线程]中取值 inheritableThreadLocal=" + MyInheritableThreadLocalTest.InheritableThreadLocal.get());
        log.info("在[子线程]中取值 integerThreadLocal=" + MyInheritableThreadLocalTest.threadLocal.get());
    }
}