package javacore.jdk18.optional;

import java.util.Optional;

/**
 * @Date: 2019-07-24
 * @Version 1.0
 */
public class RunTest {
    public static void main(String[] args) {
        // jdk 1.7
        String s = null;
        if (null != s) {
            System.out.println("不为空");
        } else {
            System.out.println("为空");
        }

        // jdk 1.8
        Optional<String> os = Optional.ofNullable(s);
        if (os.isPresent()) {
            System.out.println("不为空");
        } else {
            System.out.println("为空");
        }
    }


}
