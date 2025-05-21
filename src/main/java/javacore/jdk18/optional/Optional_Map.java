package javacore.jdk18.optional;

import java.util.Optional;

public class Optional_Map {
    public static void main(String[] args) {
        String str = " ztest ";
        System.out.println(demo2(str));
    }

    /**
     * 相当于以下代码：
     */
    public static String demo(String str) {
        if (str != null) {
            str = str.trim();
            if (str.length() > 1) {
                str += "1234";
                return str;
            }
        }
        return str;
    }

    public static String demo2(String str) {
        Optional<String> opt = Optional.of(str).map(String::trim)
                .filter(t -> t.length() > 1);
        return opt.map(s -> s + "_zhangxiaofan").orElse(str);
    }


}
