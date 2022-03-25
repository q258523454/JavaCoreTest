package designmode.t1_singleton.b_lazy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SingletonLazy {

    private static volatile SingletonLazy instance;

    public static SingletonLazy getSingletonLazy() {
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
