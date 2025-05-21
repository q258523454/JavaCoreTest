package designmode.t1_singleton.b_lazy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SingletonLazy {

    private static volatile SingletonLazy instance;

    public static SingletonLazy getSingletonLazy() {
        /*
         * 第一个 instance == null 提升效率: 实例不为空，直接返回该对象
         * 第二个 instance == null 防范作用: 第一层会有许多线程进入,当一个线程执行完后,其他线程也会执行 synchronized 代码块,保证只有
         *                                一个线程执行了初始化.
         */
        if (instance == null) {
            synchronized (SingletonLazy.class) {
                if (instance == null) {
                    log.info("SingletonLazy first init.");
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }
}
