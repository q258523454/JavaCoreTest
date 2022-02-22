package javacore.base.t2_collection.lists.iterator;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Slf4j
public class IteratorTest {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();

        String[] temp1 = {"1", "2", "3", "4", "5"};
        String[] temp2 = {"1", "2", "3", "4", "5"};
        String[] temp3 = {"1", "2", "3", "4", "5"};

        Collections.addAll(list1, temp1);
        Collections.addAll(list2, temp2);
        Collections.addAll(list3, temp3);

        testFori(list1, "3");
        testForeach(list2, "3");
        testIterator(list3, "3");

        log.info(JSON.toJSONString(list1));
        log.info(JSON.toJSONString(list2));
        log.info(JSON.toJSONString(list3));

    }

    /**
     * 遍历方式1: fori (禁止add/remove)
     * 坑: 删除元素后,整个list会往前移,size()会减小.可以在remove()后下标减一的方式解决。
     */
    public static void testFori(List<String> list, String target) {
        for (int i = 0; i < list.size(); i++) {
            log.info("当前:" + list.get(i) + ", list.size():{}", list.size());
            if (target.equals(list.get(i))) {
                log.info("删除:{}", list.get(i));
                list.remove(list.get(i));
            }
        }
    }

    /**
     * 遍历方式2: foreach (禁止add/remove)
     * 坑一: foreach 循环中 add/remove(非倒数第二个元素), 抛异常 ConcurrentModificationException
     * 坑二: foreach 循环中 remove(倒数第二个元素), 能正常运行, 但会导致最后一个元素不被遍历
     */
    public static void testForeach(List<String> list, String target) {
        for (String s : list) {
            if (target.equals(s)) {
                list.remove(s);
                log.info("foreach即使删除成功");
                log.info("1.是倒数第二个元素,下一次遍历会遗漏最后一个元素");
                log.info("2.不是倒数第二个元素,下一次遍历会抛 checkForComodification");
            }
        }
    }

    /**
     * 遍历方式3: Iterator 迭代器(正确)
     * 注意1: 是使用迭代器的接口 iterator.remove(), 不是 list.remove()
     * 注意2: remove()操作之前一定要先next()
     */
    public static void testIterator(List<String> list, String target) {
        list.add("c");
        Iterator<String> iterator = list.iterator();
        int i = 0;
        // 禁止foreach 循环里进行元素的 remove/add 操作, 要用 iterator
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (target.equals(next)) {
                iterator.remove();
            }
            i++;
        }
    }

}
