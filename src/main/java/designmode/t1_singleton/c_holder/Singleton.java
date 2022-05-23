package designmode.t1_singleton.c_holder;


import lombok.extern.slf4j.Slf4j;


/**
 * 静态内部类 Holder 方式
 * 总结一句话：静态方法(公有)调用 静态内部类(私有)的静态属性(私有)
 */
@Slf4j
public class Singleton {

    private Singleton() {
        log.info("Singleton first init.");
    }

    /**
     * JVM类加载机制,类中的方法(不论是普通方法还是静态方法)和内部类 是不会在类创建实例的时候初始化的
     * 根据JVM机制,类只会在用到的时候加载一次，并且:
     * 类加载和实例化 不管是静态变量还是成员变量, 都只会执行初始化 属性和代码块,默认不会执行方法
     * 总结:
     * 1.静态方法和静态内部类不会主动加载(保证懒加载)
     * 2.静态属性只会在类加载的时候初始化一次(保证单例)
     * 因此,我们可以通过 1->2 的方式类完成单例,同时达到了懒加载和单例的目的
     * 总结一句话：静态方法调用 静态内部类(私有)的静态属性(私有)
     */
    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
}
