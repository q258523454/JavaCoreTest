package javacore.base.jvm.t01_classloader;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-02-28
 */
public class InitSequence {


    /***
     * 初始化先后顺序:
     * 静态属性-->静态块-->普通属性-->普通块-->构造函数
     * 注意: 普通方法是不会主动初始化的,除非被普通属性调用
     */

    // 静态变量
    private static String staticField = getStaticField();

    // 静态方法块
    static {
        System.out.println("静态方法-块");
    }

    // 普通变量
    private String field = getField();

    // 普通方法块
    {
        System.out.println("普通方法-块");
    }

    // 构造函数
    public InitSequence() {
        System.out.println("构造函数");
    }

    public static String getStaticField() {
        System.out.println("静态-属性");
        return "静态-属性";
    }

    public static String getField() {
        System.out.println("普通-属性");
        return "普通-属性";
    }

    /**
     * 静态方法-不会主动初始化
     */
    public static void staticMethod() {
        System.out.println("静态方法");
    }

    /**
     * 普通方法-不会主动初始化
     */
    private void print() {
        System.out.println("普通方法(函数)");
    }

    // 主函数
    public static void main(String[] argc) {
        new InitSequence();
    }
}