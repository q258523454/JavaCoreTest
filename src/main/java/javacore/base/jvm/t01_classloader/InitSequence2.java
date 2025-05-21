package javacore.base.jvm.t01_classloader;

/**
 * 类加载:加载静态属性(变量)-静态代码块
 * 静态变量赋值为new Class的时候, 相当于实例化加载, 此时如果静态变量未初始化, 用默认值
 * 实例化:普通属性(变量)-普通造代码块-构造函数
 */
public class InitSequence2 {

    // 第1个加载
    public static int staticNum1 = 0;

    /**
     * 第2个加载，因为是new一个实例
     * print()函数:str：普通属性 A, staticNum1=1,staticNum2=1,staticNum99=1
     * print()函数:str：普通代码快, staticNum1=2,staticNum2=2,staticNum99=2
     * InitSequence2()构造函数:str：静态属性t1, staticNum1=3,staticNum2=3,staticNum99=3
     */
    public static InitSequence2 t1 = new InitSequence2("静态属性1-调用构造函数");


    /**
     * 第3个加载
     * 此时 staticNum99不再使用默认值, 初始化为:99
     */
    public static int staticNum99 = 99;


    /**
     * 第4个加载
     * 首先初始化j 打印    4:jj ii=3 nn=99
     * 执行构造块打印      5:构造快 ii=4 nn=100
     * 执行构造方法打印     6:t2 ii=5 nn=101
     */
    public static InitSequence2 staticInstance = new InitSequence2("静态属性2-调用构造函数");

    /**
     * 第5个加载
     * print()函数:str：static_I, staticNumK=7,staticNumI=7,staticNum99=103
     */
    public static int staticNum2 = print("静态属性3");

    /**
     * 第6个加载
     * 8:静态块 ii=7 nn=103
     */
    static {
        print("静态块");
    }

    /**
     * 此变量在类加载的时候并不初始化，在实例化类的时候初始化
     */
    public int member_A = print("普通属性 A");

    {
        print("普通代码快");
    }

    //-----------以上属于类加载---------------------
    /**
     * 实例化过程：
     *         首先加载非静态方法集；
     *         初始化非静态变量：9:jj ii=8 nn=100
     *         执行构造块：10:构造快 ii=9 nn=101
     *         执行构造方法:11:init ii=10 nn=102
     * 实例化完成
     */

    /**
     * 执行构造函数  实例化完成
     */
    public InitSequence2(String str) {
        staticNum1++;
        staticNum2++;
        staticNum99++;
        System.out.println("InitSequence2()构造函数:str：" + str + ", staticNum1=" + staticNum1 + ",staticNum2=" + staticNum2 + ",staticNum99=" + staticNum99);

    }

    /**
     * 静态方法
     */
    public static int print(String str) {
        staticNum1++;
        staticNum2++;
        staticNum99++;
        System.out.println("print()函数:str：" + str + ", staticNum1=" + staticNum1 + ",staticNum2=" + staticNum2 + ",staticNum99=" + staticNum99);
        return staticNum99;
    }

    public static void main(String[] args) {
        /**
         * 首先加载类，然后实例化：
         * 类加载过程：静态属性,静态块
         * 实例化过程：普通属性,普通块, 构造函数(实例完毕)
         * 注意: 普通方法是不会主动初始化的,除非被普通属性调用
         */
        InitSequence2 t = new InitSequence2("init");
    }

}