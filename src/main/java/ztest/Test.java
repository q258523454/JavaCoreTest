
package ztest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int input = in.nextInt();
            if (isSushu(input)) {
                System.out.println("-1 -1");
            } else {
                List<Integer> list = canDivideSushu(input);
                int one = -1;
                int two = -1;
                for (int i = 0; i < list.size(); i++) {
                    for (int j = i + 1; j < list.size(); j++) {
                        if (list.get(i) * list.get(j) == input) {// 两两相乘，等于输入数字,输出
                            one = list.get(i);
                            two = list.get(j);
                        }
                    }
                }
                System.out.println("" + one + " " + two);
            }
        }
    }

    // 返回能整除的素数
    private static List<Integer> canDivideSushu(int input) {
        List<Integer> res = new ArrayList<>();
        for (int i = 2; i < input; i++) {
            if (input % i == 0) {// 如果不是素数（可被整除）
                if (isSushu(i)) {// 整除的数据如果是素数，添加到res集合里
                    res.add(i);
                }
            }
        }
        return res;
    }

    // 是否是素数
    private static boolean isSushu(int a) {
        for (int i = 2; i < a; i++) {
            if (a % i == 0) {// 整除余0，不是素数
                return false;
            }
        }
        return true;
    }
}
