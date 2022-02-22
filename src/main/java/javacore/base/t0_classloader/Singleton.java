package javacore.base.t0_classloader;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-02-28
 */
public class Singleton {
    private static Singleton singleton = new Singleton();
    public static int count1;
    public static int count2 = 0;

    private Singleton() {
        count1++;
        count2++;
    }

    public static Singleton getInstance() {
        return singleton;
    }

    public static void main(String[] args) {
//        Singleton singleton = new Singleton(); // count1=2,count2=1
        /**
         * 解析:为什么下面的count1=1,count2=0?
         * 注意:这里不是new实例, 而是单例模型
         * 如果是new, 是按照 静态变量singleton实例化(这里会执行构造函数)-->静态变量count1初始化(没有赋值操作)-->静态变量count2初始化-->构造函数
         * 如果是单例, 是按照 静态变量singleton实例化(这里会执行构造函数)-->静态变量count1初始化(没有赋值操作)-->静态变量count2初始化
         *
         */
        Singleton singleton = Singleton.getInstance(); // count1=1,count2=0
        System.out.println("count1=" + Singleton.count1);
        System.out.println("count2=" + Singleton.count2);
    }
}
