package javacore.equals;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-14
 */
public class StringEqualsTest {
    public static void main(String[] args) {
        // --------------------- String (本身重写了equals) ---------------------
        String str1 = "Hello"; // 堆-方法区-常量区
        String str2 = "Hello";
        // 这里创建了两个对象, 首先Hello在编译期间, 放入常量池, 然后才在堆上分配内存, 栈内存指向该地址
        String str3 = new String("Hello");
        String str4 = str2;

        System.out.println("str1 == str2 is " + (str1 == str2)); // true
        System.out.println("str1 == str3 is " + (str1 == str3)); // false
        System.out.println("str1 == str4 is " + (str1 == str4)); // true

        System.out.println("str1.equals(str2) is " + (str1.equals(str2))); // true
        System.out.println("str1.equals(str3) is " + (str1.equals(str3))); // true
        System.out.println("str1.equals(str4) is " + (str1.equals(str4))); // true

        // --------------------- String.intern() ---------------------
        str3 = str3.intern();
        System.out.println("str3 after intern().");
        System.out.println("str1 == str3 is " + (str1 == str3)); // false


        // --------------------- String 变量拼接的时候, 会在堆内存创建, 而不是常量区 ---------------------
        String a = "a";
        String b = "b";
        String c = "ab";
        String d = a + b;
        System.out.println(c == d);
        System.out.println(c.equals(d));

    }
}
