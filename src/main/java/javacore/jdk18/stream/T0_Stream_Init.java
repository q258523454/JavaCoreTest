package javacore.jdk18.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class T0_Stream_Init {
    public static void main(String[] args) {
        initByArr();
        System.out.println("-------------");
        initByList();
        System.out.println("-------------");
        initByString();
        System.out.println("-------------");
        initByGenerate();
        System.out.println("-------------");
        initByIterate();
    }


    /**
     * Stream 创建 方式1: 基于数组
     */
    public static void initByArr() {
        String[] strArr = {"1", "2", "3"};
        Stream<String> stream = Stream.of(strArr);
        stream.forEach(System.out::println);
    }


    /**
     * Stream 创建 方式2: 基于集合
     */
    public static void initByList() {
        List<String> list = new ArrayList<String>() {{
            add("1");
            add("2");
            add("3");
        }};
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);
    }

    /**
     * Stream 创建 方式3: 基于字符序列
     */
    public static void initByString() {
        String str = "123";
        IntStream stream = str.chars();
        stream.forEach(System.out::println);
    }

    /**
     * Stream 创建 方式4: 基于 generate
     */
    public static void initByGenerate() {
        /*
         * Stream.generate()是无限生成Stream流数据加入到流中
         * 数据为Lambda表达式处理的结果，而Stream对象就是管道，Stream流数据就像里面的水
         */
        Stream<Integer> stream = Stream.generate(() -> new Random().nextInt(100));
        // limit是限制流输出的内容，不加limit则会无限制的输出
        stream.limit(3).forEach(System.out::println);
    }

    /**
     * Stream 创建 方式5: 基于 迭代器
     */
    public static void initByIterate() {
        // iterate()也是无限生成，方法第一个参数规定了流的起始值，第二个参数则是步长
        Stream<Integer> stream = Stream.iterate(1, x -> x + 10);
        // limit是限制流输出的内容，不加limit则会无限制的输出
        stream.limit(3).forEach(System.out::println);
    }

}
