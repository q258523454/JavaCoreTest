package javacore.jdk18.stream;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Data
public class T3_Stream_Sum {

    public static void main(String[] args) {
        sumTest();
    }

    public static void sumTest() {
        List<String> list = Arrays.asList("1", "2", "3", "4", "5");
        int sum = list.stream()// 获取Stream对象
                .mapToInt(Integer::parseInt)// 映射将每一个对象转换为int
                .filter(n -> n % 2 == 0)// filter对流中数据进行过滤
                .sum();
        System.out.println(sum);
    }
}