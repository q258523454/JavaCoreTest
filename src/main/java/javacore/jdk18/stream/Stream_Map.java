package javacore.jdk18.stream;


import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream_Map {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数
        List<Integer> list = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.println(JSON.toJSONString(list));
    }
}