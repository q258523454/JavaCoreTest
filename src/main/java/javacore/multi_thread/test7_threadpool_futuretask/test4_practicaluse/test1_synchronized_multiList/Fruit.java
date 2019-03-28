package javacore.multi_thread.test7_threadpool_futuretask.test4_practicaluse.test1_synchronized_multiList;

import java.util.List;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-02-27
 */
public class Fruit {
    // (synchronized 作用:1.未被static修饰, 同实例对象多线程不能同时访问,但是不同实例可以; 2.被static修饰,所有实例都不能同时访问;)
    // 总结一句话: 归根结底是看线程拿的是哪个对象的还是哪个类的锁, 对象和类都只有一把同步锁, 但互不影响, 类线程锁——所有对象都互斥, 对象线程锁——只对改对象的线程互斥
    void func(String threadName, List<String> data){
        System.out.println("Fruit");
    }
}
