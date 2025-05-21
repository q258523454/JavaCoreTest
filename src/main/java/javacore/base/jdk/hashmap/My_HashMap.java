package javacore.base.jdk.hashmap;

import java.util.HashMap;

public class My_HashMap {
    public static void main(String[] args) {

        HashMap<Integer, String> hashMap1 = new HashMap<>();

        /**
         * 基础知识:
         * initialCapacity=16
         * capacity 是2的次数方,向上取整
         * 默认 loadFactor=0.75f
         *
         * 特点:
         * 若链表节点长度大于8，且数组容量大于64，则链表进化为红黑树
         * 键和值位置都可以是null,但是键位置只能是一个null
         * 数组长度上限：2^30
         *
         * HashMap为什么线程不安全？
         * 1.多线程扩容—死循环
         *   原因:'头插法'导致扩容可能形成环形链, jdk1.8改成尾插法,解决了.
         * 2.多线程put—数据丢失
         *   原因:多线程同时执行put,如果索引位置相同, key值可能会被后一个key覆盖.
         * 3.多线程get-NULL数据
         *   原因: 线程1执行put过程中可能扩容,rehash. 导致线程2执行get为null
         */
        HashMap<Integer, String> hashMap2 = new HashMap<>(10);


        HashMap<Integer, String> hashMap3 = new HashMap<>(10, 0.75f);


        hashMap1.put(1, "a");

    }
}
