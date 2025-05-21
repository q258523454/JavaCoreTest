package javacore.base.jvm.t01_classloader;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-02-28
 */
public class Test1 {
    private static Test1 test1 = new Test1();
    public static int count1;
    public static int count2 = 0;

    private Test1() {
        count1++;
        count2++;
    }

    public static Test1 getInstance() {
        return test1;
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
        Test1 test1 = Test1.getInstance(); // count1=1,count2=0
        System.out.println("count1=" + Test1.count1);
        System.out.println("count2=" + Test1.count2);
    }
}
