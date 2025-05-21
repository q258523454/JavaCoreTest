package javacore.base.jdk.threadlocal.inheritable;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyInheritableThreadLocalTest {

    /**
     * 嵌套线程共享/传递
     */
    public static MyInheritableThreadLocal InheritableThreadLocal = new MyInheritableThreadLocal();

    /**
     * 当前线程内共享,一般都是static, 避免对象多次new, 不仅消耗内存且导致threadLocal的共享值不一致
     */
    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    static {
        log.info("static 方法初始化 ThreadLocal=1,inheritableThreadLocal=1");
        threadLocal.remove();
        InheritableThreadLocal.set(1);
        threadLocal.set(0);
    }
}
