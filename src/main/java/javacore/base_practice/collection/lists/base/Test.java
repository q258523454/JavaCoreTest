
package javacore.base_practice.collection.lists.base;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        // 交集
        retainAll();

        // 差集
        removeAll();

        // 并集
        addAll();

        // 并集
        addAll2();

        // 相等
        isEqual();

        // 是否子集
        isSubList();
    }

    /**
     * 交集
     */
    public static void retainAll() {
        System.out.println("------------- 交集 start-------------");
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("3");
        list1.add("3");

        List<String> list2 = new ArrayList<>();
        list2.add("2");
        list2.add("3");

        list1.retainAll(list2);
        System.out.println("list1和list2交集:" + JSON.toJSONString(list1));
        System.out.println("------------- 交集 end-------------");

    }


    /**
     * 差集
     */
    public static void removeAll() {
        System.out.println("------------- 差集 start-------------");
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("1");
        list1.add("2");
        list1.add("2");
        list1.add("3");
        list1.add("3");

        List<String> list2 = new ArrayList<>();
        list2.add("2");
        list2.add("3");
        list2.add("4");
        list2.add("4");

        List<String> temp = new ArrayList<>(list1);
        temp.removeAll(list2);
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);
        System.out.println("list1 与 list2 的差集:" + temp);

        temp = new ArrayList<>(list2);
        temp.removeAll(list1);
        System.out.println("list2 与 list1 的差集:" + temp);
        System.out.println("------------- 差集 end-------------");

    }


    /**
     * 并集(包含重复元素)
     */
    public static void addAll() {
        System.out.println("------------- 并集 start-------------");
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("3");
        list1.add("3");

        List<String> list2 = new ArrayList<>();
        list2.add("2");
        list2.add("3");

        List<String> temp = new ArrayList<>(list1);
        temp.addAll(list2);
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);
        System.out.println("并集: " + JSON.toJSONString(temp));
        System.out.println("------------- 并集 end-------------");
    }

    /**
     * 并集(去重)
     */
    public static void addAll2() {
        System.out.println("------------- 并集(去重) end-------------");
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("3");
        list1.add("3");

        List<String> list2 = new ArrayList<>();
        list2.add("2");
        list2.add("3");
        list2.add("3");

        list1.removeAll(list2);
        list2.addAll(list1);
        List<String> collect = list2.stream().distinct().collect(Collectors.toList());
        System.out.println(JSON.toJSONString(list2));
        System.out.println(JSON.toJSONString(collect));
        System.out.println("------------- 并集(去重) end-------------");
    }

    /**
     * 集合相等
     */
    public static void isEqual() {
        System.out.println("------------- 集合相等 start-------------");
        List<String> list1 = new ArrayList<>();
        list1.add("3");
        list1.add("2");
        list1.add("1");
        list1.add("1");

        List<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("2");
        list2.add("3");
        list2.add("1");


        // 判断两个list集合相同
        // 方法1: 直接使用 collections4 方法(不会更改原来的list结构)
        System.out.println(org.apache.commons.collections4.CollectionUtils.isEqualCollection(list1, list2));
        System.out.println(JSON.toJSONString(list1));
        System.out.println(JSON.toJSONString(list2));

        // 方法2: 自实现(sort更改了list结构)
        System.out.println(isSame(list1, list2));
        System.out.println(JSON.toJSONString(list1));
        System.out.println(JSON.toJSONString(list2));
        System.out.println("------------- 集合相等 end-------------");
    }

    /**
     * 是否子集
     */
    public static void isSubList() {
        System.out.println("------------- 是否子集 start-------------");
        List<String> list1 = new ArrayList<>();
        list1.add("2");
        list1.add("3");
        list1.add("6");

        List<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("2");
        list2.add("3");
        list2.add("4");
        list2.add("5");

        System.out.println(JSON.toJSONString(list1));
        System.out.println(JSON.toJSONString(list2));
        if (isSubList(list1, list2)) {
            System.out.println("是子集");
        } else {
            System.out.println("不是子集");
        }

        List<Long> longList1 = new ArrayList<>();
        longList1.add(1L);
        longList1.add(2L);
        longList1.add(3L);

        List<Long> longList2 = new ArrayList<>();
        longList2.add(1L);
        longList2.add(2L);
        longList2.add(3L);
        longList2.add(4L);
        if (isSubList(longList1, longList2)) {
            System.out.println("是子集");
        } else {
            System.out.println("不是子集");
        }
        System.out.println("------------- 是否子集 end-------------");
    }


    public static boolean isSame(List<String> list1, List<String> list2) {
        // 同时为空
        if (org.springframework.util.CollectionUtils.isEmpty(list1) && org.springframework.util.CollectionUtils.isEmpty(list2)) {
            return true;
        }

        // 存在1个不为空
        if (org.springframework.util.CollectionUtils.isEmpty(list1) || org.springframework.util.CollectionUtils.isEmpty(list2)) {
            return false;
        }
        // 先排序
        Collections.sort(list1);
        Collections.sort(list2);
        return list1.equals(list2);
    }

    /**
     * 判断 list1 是否为 list2 的子集
     */
    public static <E> boolean isSubList(List<E> list1, List<E> list2) {
        List<E> subList = new ArrayList<>(list1);
        List<E> parentList = new ArrayList<>(list2);
        int differ = parentList.size() - subList.size();
        parentList.removeAll(subList);
        if (differ > 0 && differ == parentList.size()) {
            return true;
        }
        return false;
    }
}
