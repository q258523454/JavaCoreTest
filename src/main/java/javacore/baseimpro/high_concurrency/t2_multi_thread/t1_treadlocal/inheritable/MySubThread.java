package javacore.baseimpro.high_concurrency.t2_multi_thread.t1_treadlocal.inheritable;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MySubThread extends Thread {
    @Override
    public void run() {
        log.info("在[子线程]中取值 inheritableThreadLocal=" + MyInheritableThreadLocalTest.inheritableThreadLocal.get());
        log.info("在[子线程]中取值 integerThreadLocal=" + MyInheritableThreadLocalTest.integerThreadLocal.get());
    }
}