package javacore.base.jdk.list;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Description
 * @author zhang
 * @date 2022-03-07 19:32
 * @modify
 */
public class MyList_ArryList {

    public static void main(String[] args) {
        /**
         *
         * ArrayList 和 LinkedList 异同:
         * 相同:
         *     有序
         *     线程不安全
         * 不同:
         *     ArrayList 默认长度10 (add 的时候初始化)
         *     ArrayList 每次扩容默认1.5倍(Arrays.copyOf-Native方法)
         *     ArrayList 是数组, LinkedList 是双向链表
         *
         *
         */
        List<String> list = new ArrayList<>();

        // 线程不安全, 并发add异常: ConcurrentModificationException
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }).start();
        }

    }
}
