package javacore.jdk18.stream;


import com.alibaba.fastjson.JSON;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Data
public class T4_Stream_Sort {

    public static void main(String[] args) {
        List<String> ids = Arrays.asList("101", "10", "102", "49", "103");
        List<Integer> collect = ids.stream()
                .filter(s -> s.length() > 2)
                .distinct()
                .map(Integer::valueOf)
                .sorted((x, y) -> Integer.compare(x, y)) // x>y就交换, 降序排列
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect));
    }

}