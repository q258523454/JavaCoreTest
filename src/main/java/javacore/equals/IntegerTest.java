package javacore.equals;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-14
 */
public class IntegerTest {

    public static void main(String[] args) {
        test1();
        System.out.println("---------------------------------------");
        test2();
    }

    public static void test1() {
        // Integer在[-128,127]使用常量池
        Integer i1 = 100;                   // 装箱, 等价于 valueOf()
        Integer i2 = Integer.valueOf(100);  // 装箱
        Integer i3 = new Integer(100);      // 这是新建一个对象
        System.out.println(i1 == i2);   // -128<num<127 true, 否则为false
        System.out.println(i1 == i3);   // 一直为false, i3是新对象
    }

    public static void test2() {
        // Integer在[-128,127]使用常量池
        Integer i1 = 300;                   // 装箱, 等价于 valueOf()
        Integer i2 = Integer.valueOf(300);  // 装箱
        Integer i3 = new Integer(300);      // 这是新建一个对象
        System.out.println(i1 == i2);   // -128<num<127 true, 否则为false
        System.out.println(i1 == i3);   // 一直为false, i3是新对象
    }

}
