package designmode.t1_singleton.statics.a_hungry;

/**
 *
 * 饿汉式——静态属性,类加载机制
 * 优点: 线程安全
 * 缺点: 非懒加载
 */
public class SingletonHungry {
    private static SingletonHungry instance = new SingletonHungry();

    private SingletonHungry() {
    }

    public static SingletonHungry getInstance() {
        return instance;
    }
}
