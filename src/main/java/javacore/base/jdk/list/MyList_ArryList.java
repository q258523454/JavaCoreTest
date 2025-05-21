package javacore.base.jdk.list;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author zhang
 */
@Slf4j
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
         */
        shadowCopy();
    }

    /**
     * 线程不安全测试
     */
    public static void safeTest() {
        List<String> temp = new ArrayList<>();
        // 线程不安全, 并发add异常: ConcurrentModificationException
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                temp.add(UUID.randomUUID().toString().substring(0, 8));
                log.info(JSON.toJSONString(temp));
            }).start();
        }
    }

    /**
     * 浅拷贝 addAll() / new ArrayList<>(list)
     * 注意： 如果是基本类型，会体现出深拷贝
     */
    public static void shadowCopy() {
        List<Student> list1 = new ArrayList<>();
        list1.add(new Student(1, "zhangsan"));
        list1.add(new Student(2, "lisi"));
        log.info("list1:" + JSON.toJSONString(list1));
        List<Student> list2 = new ArrayList<>(list1);
        log.info("修改 list1 前");
        log.info("list1:" + JSON.toJSONString(list1));
        log.info("list2:" + JSON.toJSONString(list2));

        log.info("修改 list1 后");
        list1.get(1).setName("wangwu");
        log.info("list1:" + JSON.toJSONString(list1));
        log.info("list2:" + JSON.toJSONString(list2));
    }

}
