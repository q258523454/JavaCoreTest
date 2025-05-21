package javacore.base_practice.collection.lists.disjoint;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
@Slf4j
public class DisjointTest {

    /**
     * Collections.disjoint 判断两个元素是否存在相同元素
     * 如果没有相同元素，返回 true
     * 存在相同元素则返回 true
     */
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("3");
        list1.add("3");

        List<String> list2 = new ArrayList<>();
        list2.add("2");
        list2.add("4");

        // 没有共同元素: true, 只要存在1个相同元素:false
        System.out.println(Collections.disjoint(list1, list2));
    }
}