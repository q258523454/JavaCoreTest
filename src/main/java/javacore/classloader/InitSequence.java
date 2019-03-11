package javacore.classloader;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-02-28
 */
public class InitSequence {


    /*** 初始化先后顺序:
     * 静态属性-->静态块-->普通属性-->普通块-->构造函数-->方法(实例函数)
     */

    
    // 静态变量
    private static String staticField = getStaticField();

    // 静态方法块
    static {
        System.out.println("静态方法块初始化");
    }

    // 普通变量
    private String field = getField();

    // 普通方法块
    {
        System.out.println("普通方法块初始化");
    }

    // 构造函数
    public InitSequence() {
        System.out.println("构造函数初始化");
    }

    public static String getStaticField() {
        System.out.println("静态变量初始化");
        return "静态变量初始化";
    }

    public static String getField() {
        System.out.println("普通变量初始化");
        return "普通变量初始化";
    }

    private void print() {
        System.out.println("普通方法(函数)");
    }

    // 主函数
    public static void main(String[] argc) {
        new InitSequence().print();
    }
}