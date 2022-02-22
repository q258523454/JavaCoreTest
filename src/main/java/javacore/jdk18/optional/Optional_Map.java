package javacore.jdk18.optional;

import java.util.Optional;
import java.util.function.Function;

public class Optional_Map {
    public static void main(String[] args) {
        String str = " test ";
        System.out.println(demo2(str));
    }

    /**
     * 相当于以下代码：
     */
    public static String demo2(String str) {
        Optional<String> opt = Optional.of(str).map(String::trim)
                .filter(t -> t.length() > 1);
        return opt.map(s -> s + "_zhangxiaofan").orElse(str);
    }

    /**
     * 相当于以下代码：
     */
    public static void demo(String str) {
        if (str != null) {
            str = str.trim();
            if (str.length() > 1) {
                str += "1234";
                System.out.println(str);
            }
        }
    }

}
