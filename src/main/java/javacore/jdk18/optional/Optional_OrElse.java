package javacore.jdk18.optional;

import com.alibaba.fastjson.JSON;

import java.util.Optional;

public class Optional_OrElse {
    public static void main(String[] args) {
        Optional<Student> opts = Optional.of(new Student(1, "a"));
        System.out.println(JSON.toJSONString(opts));

        // orElse:如果存在就返回原来的,否则返回新
        Student b1 = opts.orElse(new Student(2, "b"));
        System.out.println(JSON.toJSONString(b1));

        // orElseGet:如果存在就返回原来的,否则执行新的函数
        opts = Optional.empty();
        Student b2 = opts.orElseGet(() -> {
            return new Student(2, "b");
        });
        System.out.println(JSON.toJSONString(b2));
    }

}
