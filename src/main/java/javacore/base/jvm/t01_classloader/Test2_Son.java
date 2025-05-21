package javacore.base.jvm.t01_classloader;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-02-28
 */
public class Test2_Son extends Test2_Father {


    private static int num2 = 0;

    static {
        System.out.println("son static");
    }

    {
        System.out.println("son 普通代码块");
    }

    public Test2_Son() {
        System.out.println("son 构造函数");
    }

    public static void main(String[] args) {
        System.out.println("1111");
        Test2_Son son = new Test2_Son();
        System.out.println("2222");
    }
}
