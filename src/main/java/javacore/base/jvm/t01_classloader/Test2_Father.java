package javacore.base.jvm.t01_classloader;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-02-28
 */
public class Test2_Father {

    private static int num = 0;

    static {
        System.out.println("father static");
    }

    {
        System.out.println("father 普通代码块");
    }

    public Test2_Father() {
        System.out.println("father 构造函数");
    }
}
