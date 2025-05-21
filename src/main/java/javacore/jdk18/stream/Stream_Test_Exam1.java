package javacore.jdk18.stream;

import java.util.Arrays;

public class Stream_Test_Exam1 {
    public static void main(String[] args) {
        System.out.println("-------1.不会输出(无终结和短路操作)-------");
        int[] arr = new int[]{1, 2, 3, 4};
        // filter: Intermediate[聚合操作——中间]
        // 需要
        // 1.Terminal[聚合操作——终结] 来执行的
        // 2.Short-circuiting[聚合操作——短路] 来执行的
        Arrays.stream(arr).filter(n -> {
            if (n % 2 == 0) {
                System.out.println("filter:" + n);
                return true;
            }
            return false;
        });

        System.out.println("-------2.(终结操作,流式输出)-------");

        Arrays.stream(arr).filter(n -> {
            if (n % 2 == 0) {
                System.out.println(n);
                return true;
            }
            return false;
        }).forEach(System.out::println);

        System.out.println("-------3.(短路操作,流式输出)-------");

        Arrays.stream(arr).filter(n -> {
            if (n % 2 == 0) {
                System.out.println("filter:" + n);
                return true;
            }
            return false;
        }).anyMatch(n -> {
            if (isJudge(n)) {
                System.out.println("anyMatch:" + n);
                return true;
            }
            return false;
        });
    }

    public static boolean isJudge(int n) {
        return n % 2 == 0;
    }
}
