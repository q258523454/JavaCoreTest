package javacore.jdk18.stream;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stream_FlatMap {

    //id
    private Integer id;

    //域名
    private String domain;

    //ip,多个用;分隔
    private String ip;

    public static void main(String[] args) {
        Stream_FlatMap w1 = new Stream_FlatMap(1, "www.localhost.com", "127.0.0.1;localhost");
        Stream_FlatMap w2 = new Stream_FlatMap(2, "www.baidu.com", "192.123.123.1;192.111.111.1");
        Stream_FlatMap w3 = new Stream_FlatMap(3, "www.hao123.com", "localhost");

        List<Stream_FlatMap> list = new ArrayList<>();
        list.add(w1);
        list.add(w2);
        list.add(w3);

        // 将所有 ip 输出为 list, 并去重
        List<String> result = list.stream()
                .map(Stream_FlatMap::getIp)
                .flatMap(v -> Arrays.stream(v.split(";")))
                .distinct()
                .collect(Collectors.toList());

        System.out.println(result);
    }
}