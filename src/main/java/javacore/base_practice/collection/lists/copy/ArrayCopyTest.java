package javacore.base_practice.collection.lists.copy;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

public class ArrayCopyTest {

    public static void main(String[] args) {
        systemArrayCopyTest();
        arrayCopyOfTest();
    }

    /**
     * 数组拷贝：方法1
     */
    public static void systemArrayCopyTest() {
        int[] src = {1, 2, 3, 4, 5};
        int[] dest = new int[src.length];
        System.arraycopy(src, 0, dest, 0, 5);
        System.out.println(JSON.toJSONString(dest));
    }

    /**
     * 数组拷贝：方法2
     * <p>
     * Arrays.copy(): 实际上浅拷贝(基本类型、String本身都是深拷贝)
     * 一维数组，且数组元素为基本类型或 String(类型本身是final修饰,每次都是新对象,不存在深浅拷贝的说法) 类型时，
     * 数组复制属于[深复制]，即复制后的数组与原始数组的元素互不影响；
     * <p>
     * 多维数组，或一维数组中的元素是引用类型时，数组复制属于[浅复制]，即复制后的数组与原始数组的元素引用指向的是同一个对象。
     */
    public static void arrayCopyOfTest() {
        int[] src = {1, 2, 3, 4, 5};
        int[] dest = Arrays.copyOfRange(src, 0, src.length);
        src[0] = 100;
        System.out.println(JSON.toJSONString(dest));
    }

}
