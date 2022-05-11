package resume.question.ACM_huazi.base;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @Description
 * @author zhang
 * @date 2022-04-26 15:18
 * @modify
 */
public class Main_Add_Line {

    /**
     * 计算 每一行的和
     * 第1行第1个数字该行的数字个数, 0 表示结束
     *
     * 输入:
     * 3 1 1 1
     * 4 2 2 2 2
     * 0
     *
     * 输出:
     * 3
     * 6
     *
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] s = sc.nextLine().split(" ");
            int num = Integer.parseInt(s[0]);
            if (0 == num) {
                return;
            }
            BigDecimal sum = new BigDecimal(0);
            for (int i = 1; i < s.length; i++) {
                sum = sum.add(new BigDecimal(s[i]));
            }
            System.out.println(sum);
        }
    }

}
