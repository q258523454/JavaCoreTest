package resume.question.ACM_huazi.base;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @Description
 * @author zhang
 * @date 2022-04-26 15:18
 * @modify
 */
public class Main_Add_Line_Whit_Input_Count {

    /**
     *
     * 计算 每一行的和
     * 第1行的数字为总行数
     * 第2行开始,第1个数字该行的数字个数
     *
     * 输入:
     * 2
     * 3 1 1 1
     * 4 1 1 1 1
     * 0
     *
     * 输出:
     * 3
     * 4
     *
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        if (sc.hasNextLine()) {
            String[] s = sc.nextLine().split(" ");
            count = Integer.parseInt(s[0]);
        }

        while (0 != count) {
            String[] s = sc.nextLine().split(" ");
            int num = Integer.parseInt(s[0]);
            BigDecimal sum = new BigDecimal(0);
            for (int i = 1; i < s.length; i++) {
                sum = sum.add(new BigDecimal(s[i]));
            }
            System.out.println(sum);
            count--;
        }
    }

}
