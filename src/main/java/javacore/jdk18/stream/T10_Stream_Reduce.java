package javacore.jdk18.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class T10_Stream_Reduce {
    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        // 求和 10
        Optional<Integer> reduce = nums.stream().reduce((x, y) -> x + y);
        System.out.println(reduce.get());
        // 可以指定初始值的求和计算，参数1就是累加器的初始值
        Integer sum2 = nums.stream().reduce(10, (x, y) -> x + y);
        System.out.println(sum2);
    }
}
