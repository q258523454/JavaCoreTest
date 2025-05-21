package javacore.jdk18.stream;


import com.alibaba.fastjson.JSON;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@Slf4j
public class T1_Stream_Map2_Practice {
    // id
    private Integer id;

    // 域名
    private String domain;

    // ip,多个用;分隔
    private String ip;

    /**
     * map VS flatMap
     * map：将输入类型变成另一个类型。
     * flatMap：扁平化的，将多维集合，变成一个集合，相当于压缩，俗称扁平化。
     *
     * <p>
     * 参考文章： https://www.cnblogs.com/wangjing666/p/9999666.html
     */
    public static void main(String[] args) {

        // ------------------ map 操作 -----------------------
        // map 操作: 求平方
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> squareList = numbers.stream()
                .map(i -> i * i)
                .distinct()
                .collect(Collectors.toList());
        log.info("求平方:" + JSON.toJSONString(squareList));

        // map 操作: 获取student的姓名list
        Student student1 = new Student(1, "zhangsan");
        Student student2 = new Student(2, "lisi");
        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        List<String> nameList = studentList.stream()
                .map(x -> x.getName())
                .collect(Collectors.toList());
        log.info("获取student的姓名list:" + JSON.toJSONString(nameList));
        log.info("------------------------------------------------");

        // ------------------ flatMap 操作 -----------------------
        // flatMap 操作 : 地址去重
        T1_Stream_Map2_Practice w1 = new T1_Stream_Map2_Practice(1, "www.localhost.com", "127.0.0.1;localhost");
        T1_Stream_Map2_Practice w2 = new T1_Stream_Map2_Practice(2, "www.baidu.com", "192.123.123.1;192.111.111.1");
        T1_Stream_Map2_Practice w3 = new T1_Stream_Map2_Practice(3, "www.hao123.com", "localhost");
        List<T1_Stream_Map2_Practice> list = new ArrayList<>();
        list.add(w1);
        list.add(w2);
        list.add(w3);
        // 将所有 ip 输出为 list, 并去重
        List<String> result = list.stream()
                .map(T1_Stream_Map2_Practice::getIp)
                .flatMap(v -> Arrays.stream(v.split(";")))
                .distinct()
                .collect(Collectors.toList());
        log.info("ip去重:" + result.toString());
        log.info("------------------------------------------------");

        // ------------------ map VS flatMap  -----------------------
        log.info("-----------------rightUse -------------------------");
        rightUse();
        log.info("-----------------erroUse -------------------------");
        erroUse();
    }

    public static void rightUse() {
        // 对两个单词的中的字符去重
        List<String> wordList = Arrays.asList("aabb", "bbcc");

        // flatMap 正确实现
        List<String> flatMapCollection = wordList.stream()
                .flatMap(x -> Arrays.stream(x.split("")))
                .distinct()
                .collect(Collectors.toList());
        // ["a","b","c"]
        flatMapCollection.forEach(x -> {
            log.info(JSON.toJSONString(x));
        });
    }

    public static void erroUse() {
        // 对两个单词的中的字符去重
        List<String> wordList = Arrays.asList("aabb", "bbcc");

        // map 错误实现
        List<String[]> mapCollection = wordList.stream()
                .map(x -> x.split(""))
                .distinct()
                .collect(Collectors.toList());

        // 打印出来的是
        // ["a","a","b","b"]
        // ["b","b","c","c"]
        mapCollection.forEach(x -> {
            log.info(JSON.toJSONString(x));
        });
    }
}