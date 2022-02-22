package javacore.jdk18.stream;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/***
 * 流操作类型:
 * Intermediate：一个流可以后面跟随零个或多个 intermediate 操作。其目的主要是打开流，做出某种程度的数据映射/过滤，然后返回一个新的流，
 *              交给下一个操作使用。这类操作都是惰性化的（lazy），就是说，仅仅调用到这类方法，并没有真正开始流的遍历。
 *
 * Terminal：一个流只能有一个 terminal 操作，当这个操作执行后，流就被使用“光”了，无法再被操作。所以这必定是流的最后一个操作。
 *          Terminal 操作的执行，才会真正开始流的遍历，并且会生成一个结果，或者一个 side effect。
 *
 * 常用的聚合操作:
 * Intermediate[聚合操作——中间]：
 *          map(mapToInt, flatMap 等), filter, distinct, sorted, peek, limit, skip, parallel, sequential, unordered
 * Terminal[聚合操作——终结]：
 *          forEach, forEachOrdered, toArray, reduce, collect, min, max, count, anyMatch, allMatch, noneMatch, findFirst, findAny, iterator
 * Short-circuiting[聚合操作——短路]：
 *          anyMatch, allMatch, noneMatch, findFirst, findAny, limit
 */
public class RunTest {
    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();

        // map 操作
        integerList = Arrays.asList(1, 2, 3, 4, 1, 2);
        List<Integer> res = integerList.stream().map(integer -> integer + 1).distinct().collect(Collectors.toList());
        res.forEach(System.out::println);

        // filter 操作
        stringList = Arrays.asList("a", "b", "", "c");
        long emptyCount = stringList.stream().filter(s -> s.isEmpty()).count();
        System.out.println("空字符串个数:" + emptyCount);

        // sorted 操作
        integerList = Arrays.asList(1, 2, 3, 6, 5, 4);
        integerList.stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        }).forEach(System.out::println);

        // collect-collecotr 归约操作
        stringList = Arrays.asList("a", "b", "", "c");
        List<String> filterList = stringList.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        String filterJoinList = stringList.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining(","));
        System.out.println(JSON.toJSONString(filterList));
        System.out.println(JSON.toJSONString(filterJoinList));

        // 统计 mapToInt max 操作
        integerList = Arrays.asList(1, 2, 3, 4, 5);
        int max = integerList.stream().mapToInt(x -> x).max().getAsInt();
        int min = integerList.stream().mapToInt(x -> x).min().getAsInt();
        int sum = integerList.stream().mapToInt(x -> x).sum();
        Double average = integerList.stream().mapToInt(x -> x).average().getAsDouble();
        System.out.println("max=" + max);
        System.out.println("min=" + min);
        System.out.println("sum=" + sum);
        System.out.println("average=" + average);


        // parallelStream map 操作
        Random random = new Random();
        integerList = Stream.generate(random::nextInt).limit(4).collect(Collectors.toList());
        long st1 = System.currentTimeMillis();
        integerList.forEach(System.out::println);
        long st2 = System.currentTimeMillis();
        integerList.parallelStream().forEach(System.out::println);
        long st3 = System.currentTimeMillis();
        System.out.println("耗时1 ms:" + (st2 - st1));
        System.out.println("耗时2 ms:" + (st3 - st2));


        // match 操作
        stringList = Arrays.asList("a", "b", "", "c");
        System.out.println(stringList.stream().anyMatch(s -> s.equals("a")));
        System.out.println(stringList.stream().allMatch(s -> s.contains("c")));

    }
}
