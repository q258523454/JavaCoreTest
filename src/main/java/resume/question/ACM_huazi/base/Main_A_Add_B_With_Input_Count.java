package resume.question.ACM_huazi.base;

import java.util.Scanner;

/**
 * @Description
 * @author zhang
 * @date 2022-04-26 15:18
 * @modify
 */
public class Main_A_Add_B_With_Input_Count {

    /**
     * 计算 a+b, 0 0 表示结束
     *
     * 输入:
     * 10 2
     * 20 1
     * 0 0
     *
     * 输出:
     * 12
     * 21
     *
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine().trim();
            int a = Integer.parseInt(s.split(" ")[0]);
            int b = Integer.parseInt(s.split(" ")[1]);
            if (0 == a && 0 == b) {
                return;
            }
            System.out.println(a + b);
        }
    }

}
