

package javacore.jdk18.a0_function.t1_consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerTest {


    /**
     * Consumer 可以看成一个快速定义的方法
     */
    public static void main(String[] args) {
        // 基础使用
        consumeMethod();


        // 拼接多个 consumer
        testAndThen();

    }

    /**
     * 基础使用
     */
    private static void consumeMethod() {
        Consumer<String> myPrintConsumer = (s -> System.out.println(s + ";"));
        myPrintConsumer.accept("zhangsan");
        myPrintConsumer.accept("lisi");
    }


    /**
     * 拼接使用 consumer
     */
    private static void testAndThen() {
        List<Integer> numList = Arrays.asList(3, 4, 5, 6);

        // 注意 Consumer 的类型
        Consumer<List<Integer>> step1 = new Consumer<List<Integer>>() {
            @Override
            public void accept(List<Integer> list) {
                list.replaceAll(integer -> integer * integer);
            }
        };

        Consumer<List<Integer>> step2 = new Consumer<List<Integer>>() {
            @Override
            public void accept(List<Integer> list) {
                for (Integer integer : list) {
                    System.out.println("value:" + integer);
                }
            }
        };

        step1.andThen(step2).accept(numList);
    }
}
