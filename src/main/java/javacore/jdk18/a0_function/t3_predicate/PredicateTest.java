package javacore.jdk18.a0_function.t3_predicate;


import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Slf4j
public class PredicateTest {

    public static void main(String[] args) {
        String[] strings = new String[]{"aa", "bb", "ca"};
        PrintNameWithA.print(Arrays.asList(strings), new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("a");
            }
        });
    }

    /**
     * 函数式接口 只有用的时候才会执行, 注意,写bean初始化的时候,是用到的时候才会执行函数式接口
     */
    static class PrintNameWithA {
        public static void print(List<String> stringList, Predicate<String> predicate) {
            for (String str : stringList) {
                log.info(predicate.test(str) ? str : "no a");
            }
        }
    }
}
