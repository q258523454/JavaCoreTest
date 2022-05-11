package javacore.base.jdk.list;

import java.util.LinkedList;
import java.util.UUID;

/**
 * @Description
 * @author zhang
 * @date 2022-03-07 19:32
 * @modify
 */
public class MyList_LinkedList {

    public static void main(String[] args) {

        /**
         * linkedList
         * 双向链表
         */
        LinkedList<String> list = new LinkedList<>();
        // LinkedList线程不安全, 并发add异常: ConcurrentModificationException
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }).start();
        }
    }

}
