package javacore.jdk18.stream;


import com.alibaba.fastjson.JSON;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@Slf4j
public class T2_Stream_Collect {
    public static void main(String[] args) {
        List<Student> ids = Arrays.asList(new Student(18, "zhangsan"),
                new Student(20, "lisi"),
                new Student(19, "wangwu"));
        // list
        List<Student> collectList = ids.stream()
                .filter(dept -> dept.getId() > 18)
                .collect(Collectors.toList());
        log.info("collect List:" + JSON.toJSONString(collectList));
        // Set
        Set<Student> collectSet = ids.stream()
                .filter(dept -> dept.getId() > 18)
                .collect(Collectors.toSet());
        log.info("collect Set:" + JSON.toJSONString(collectSet));

        // Map
        Map<Integer, Student> collectMap = ids.stream()
                .filter(dept -> dept.getId() > 18)
                .collect(Collectors.toMap(Student::getId, dept -> dept));
        log.info("collect Map:" + JSON.toJSONString(collectMap));

        // List->Map,不存在重复key
        // listToMap();

        // List->Map,存在重复key
        // listToMapWithDuplicateKey();

        // 集合去重(同时排序)
        log.info("----------- 集合去重(同时排序) -----------------");
        dealDuplicate();
    }


    /**
     * List->Map,不存在重复key
     */
    private static void listToMap() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(Student.builder().id(1).name("zhangsan").build());
        // studentList.add(Student.builder().id(1).name("zhangsan2").build());
        studentList.add(Student.builder().id(2).name("lisi").build());
        // 注意下面这个写法,不能存在重复 key值, 否则会报错
        Map<Integer, Student> collect = studentList.stream()
                .collect(Collectors.toMap(Student::getId, Function.identity()));
        System.out.println(JSON.toJSONString(collect));
    }


    /**
     * List->Map,存在重复key
     */
    private static void listToMapWithDuplicateKey() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(Student.builder().id(1).name("zhangsan").build());
        studentList.add(Student.builder().id(1).name("zhangsan2").build());
        studentList.add(Student.builder().id(2).name("lisi").build());
        // (k1, k2) -> k2 表示存在重复key值的时候,取后者
        Map<Integer, Student> collect = studentList.stream()
                .collect(Collectors.toMap(Student::getId, Function.identity(), (k1, k2) -> k2));
        System.out.println(JSON.toJSONString(collect));
    }

    /**
     * 集合去重(同时排序)
     */
    private static void dealDuplicate() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(Student.builder().id(3).name("wangwu").build());
        studentList.add(Student.builder().id(3).name("wangwu2").build());
        studentList.add(Student.builder().id(1).name("zhangsan").build());
        studentList.add(Student.builder().id(1).name("zhangsan2").build());
        studentList.add(Student.builder().id(2).name("lisi").build());
        studentList.add(Student.builder().id(2).name("lisi2").build());

        TreeSet<Student> newList = new TreeSet<>(Comparator.comparing(Student::getId));
        newList.addAll(studentList);
        System.out.println(JSON.toJSONString(newList));
    }
}