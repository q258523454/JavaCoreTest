package javacore.base_practice.collection.lists.duplicate;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {

    /**
     * 判断list是否存在重复
     *
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 1, 3, 4, 4);
        System.out.println(isExistsDuplicate(list));
        System.out.println(JSON.toJSONString(findDuplicate(list)));
    }

    /**
     * 是否存在重复
     */
    public static boolean isExistsDuplicate(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        // 存在重复
        return set.size() < list.size();
    }

    /**
     * 找到重复元素
     */
    public static List<Integer> findDuplicate(List<Integer> list) {
        return list.stream()
                .filter(i -> Collections.frequency(list, i) > 1) // 出现次数大于1
                .distinct() // 去重
                .collect(Collectors.toList());
    }
}