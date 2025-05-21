package javacore.jdk18.stream;


import com.alibaba.fastjson.JSON;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@Slf4j
public class T1_Stream_Map1 {
    public static void main(String[] args) {
        mergeMultiListIntoOne();
    }

    /**
     * 利用 flatmap 将多个list 合并成一个
     */
    private static void mergeMultiListIntoOne() {
        List<List<String>> list = new ArrayList<>();

        List<String> sub1 = new ArrayList<>();
        sub1.add("11");
        sub1.add("22");

        List<String> sub2 = new ArrayList<>();
        sub1.add("33");
        sub1.add("44");

        list.add(sub1);
        list.add(sub2);

        List<Long> collect = list.stream()
                .flatMap(Collection::stream)
                .map(Long::parseLong)
                .collect(Collectors.toList());

        System.out.println(JSON.toJSONString(collect));
    }



}