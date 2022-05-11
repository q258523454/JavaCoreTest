package javacore.jdk18.func;

import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Date: 2019-07-23
 * @Version 1.0
 */
public class RunTest {

    public static void main(String[] args) {
        String[] strings = new String[]{"aa", "bb", "ca"};
        PrintNameWithA.print(Arrays.asList(strings), s -> s.contains("a"));
    }

    /**
     * 函数式接口
     */
    static class PrintNameWithA {
        public static void print(List<String> stringList, Predicate<String> predicate) {
            for (String str : stringList) {
                System.out.println(predicate.test(str) ? str : "no a");
            }
        }
    }
}
