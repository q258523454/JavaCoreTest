package javacore.base.jvm.t01_jvm_object_header;

import org.openjdk.jol.info.ClassLayout;

public class RunTest {

    // 2 字节
    private char c;

    // 4 字节
    private int i;
    // 2 字节
    private short s;
    // 8 字节
    private long l;

    // 4 字节
    private float f;
    // 8 字节
    private double d;

    // 4 字节
    private long[] arr;

    public static void main(String[] args) {
        /**
         * 参考: https://blog.csdn.net/zwx900102/article/details/108108555
         * 一个对象的内存分三个区域:
         * 1.对象头(header)
         *   1.1.Mark Word(HashCode,锁信息,分代标记)
         *   1.2.类指针(原始的类信息-即类元信息)
         *   1.3.数组长度 (数组特有的)
         * 2.实例数据(instance data)
         * 3.填充(padding)
         *
         * 一个对象的头(Header)包含:
         * 1.Mark Word(分代标记,HashCode等)
         * 2.Class Pointer(原始的类信息-即类元信息)
         * 3.Length (数组特有的)
         * 合计是8字节的倍数,不足会填充.
         *
         * java.lang.Object object internals:
         *  OFFSET  SIZE   TYPE DESCRIPTION
         * OFFSET  SIZE               TYPE DESCRIPTION
         *     ------- 对象头(header)
         *      0     4        (object header) -- Mark Word(分代标记,HashCode等)
         *      4     4        (object header) -- Mark Word(分代标记,HashCode等)
         *      8     4        (object header) -- Class Pointer(原始的类信息-即类元信息)
         *     ------- 实例数据(instance data)
         *     12     4                int Student.id
         *     16     1            boolean Student.flag
         *     17     3                    (alignment/padding gap)
         *     20     4   java.lang.String Student.name
         *     24     4   java.lang.Object Student.object
         *     ------- 填充(padding)
         *     28     4                    (loss due to the next object alignment)-- 对其填充, 按8字节的倍数
         * Instance size: 16 bytes
         */
        Student obj = new Student();
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        System.out.println(ClassLayout.parseInstance(new RunTest()).toPrintable());
    }
}
