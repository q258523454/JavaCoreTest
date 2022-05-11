package javacore.base.jvm.t01_classloader;

/**
 * 类加载:加载静态属性(变量)-静态代码块
 *      静态变量赋值为new Class的时候, 相当于实例化加载, 此时如果静态变量未初始化, 用默认值
 * 实例化:普通属性(变量)-普通造代码块-构造函数
 */
public class InitSequence2 {

    // 第1个加载
    public static int kk = 0;

    /**
     * 第2个加载，因为是new一个实例
     * 首先初始化jj,打印   1:jj ii=0 nn=0
     * 执行构造块,打印     2:构造快 ii=1 nn=1
     * 执行构造方法,打印    3:t1 ii=2 nn=2
     */
    public static InitSequence2 t1 = new InitSequence2("t1");


    /**
     * 第3个加载 (之前的nn是默认值0, 现在被初始化赋值=99)
     */
    public static int nn = 99;


    /**
     * 第4个加载
     * 首先初始化j 打印    4:jj ii=3 nn=99
     * 执行构造块打印      5:构造快 ii=4 nn=100
     * 执行构造方法打印     6:t2 ii=5 nn=101
     */
    public static InitSequence2 t2 = new InitSequence2("t2");

    /**
     * 第5个加载
     * 打印出  7:ii ii=6 nn=102 (注意此时ii被初始化成了103)
     */
    public static int ii = print("ii");


    /**
     * 此变量在类加载的时候并不初始化，在实例化类的时候初始化
     */
    public int jj = print("jj");

    {
        print("构造快");
    }

    /**
     * 第6个加载
     * 8:静态块 ii=7 nn=103
     */
    static {
        print("静态块");
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
        System.out.println((++kk) + ":" + str + " ii=" + ii + " nn=" + nn);
        ++nn;
        ++ii;
    }

    /**
     * 这个应该是最先加载 但是，加载不等于执行
     * 因为如果不加载此函数，静态变量是无法初始化的
     */
    public static int print(String str) {
        System.out.println((++kk) + ":" + str + " ii=" + ii + " nn=" + nn);
        ++ii;
        return ++nn;
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