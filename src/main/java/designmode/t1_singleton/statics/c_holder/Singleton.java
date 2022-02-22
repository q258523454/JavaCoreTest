package designmode.t1_singleton.statics.c_holder;


import lombok.extern.slf4j.Slf4j;


/**
 * 静态内部类 Holder 方式
 * 总结一句话：静态方法调用静态内部类的静态属性
 */
@Slf4j
public class Singleton {

    private Singleton() {
    }

    /**
     * JVM类加载机制,类中的方法(不论是普通方法还是静态方法)和内部类 是不会在类创建实例的时候初始化的
     * 类中的方法在加载或实例化的时候, 只会执行初始化(静态)属性和(静态)代码块,以及构造函数
     * 由于:
     * 1.静态方法不会主动加载(调用)
     * 2.静态内部类不会主动加载
     * 3.静态属性只会在类加载的时候初始化一次
     * 因此,我们可以通过 1->2->3 的方式类完成单例,同时达到了懒加载和单例的目的
     * 总结一句话：静态方法调用静态内部类的静态属性
     */
    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
}
