
package javacore.jdk18.a0_function.t0_function;

import lombok.extern.slf4j.Slf4j;

import java.util.function.BiFunction;
import java.util.function.Function;

@Slf4j
public class Test {

    public static void main(String[] args) {

        // 默认的 Function.apply
        defaultFunctionApply();
        System.out.println("--------------------");

        // 默认的 BiFunction.apply
        defaultBiFunctionApply();
        System.out.println("--------------------");


        // 自定义函数式接口
        testFunctionalInterface();
        System.out.println("--------------------");
    }


    /**
     * Function<T, R>
     * 入参 1个, 返回参数 1个
     */
    private static void defaultFunctionApply() {
        // 乘以2
        Function<Integer, String> doubleValue = new Function<Integer, String>() {
            @Override
            public String apply(Integer input) {
                return input * 2 + "";
            }
        };
        log.info("5乘以2:" + doubleValue.apply(5));
    }

    /**
     * BiFunction<T, U, R>
     * 入参 2个, 返回参数 1个
     */
    private static void defaultBiFunctionApply() {
        BiFunction<Integer, Integer, String> multi = new BiFunction<Integer, Integer, String>() {
            @Override
            public String apply(Integer input1, Integer input2) {
                return input1 * input2 + "";
            }
        };

        log.info("2*3乘积:" + multi.apply(2, 3));
    }

    /**
     * 自定义函数式接口
     */
    private static void testFunctionalInterface() {
        MyFunctionalInterface myFunctionalInterface = new MyFunctionalInterface() {
            @Override
            public int operator(int a, int b) {
                return 0;
            }
        };
        System.out.println(myFunctionalInterface.operator(1, 2));
    }
}
