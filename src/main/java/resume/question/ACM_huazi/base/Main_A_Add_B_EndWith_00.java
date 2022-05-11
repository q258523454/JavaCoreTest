package resume.question.ACM_huazi.base;

import java.util.Scanner;

/**
 * @Description
 * @author zhang
 * @date 2022-04-26 15:18
 * @modify
 */
public class Main_A_Add_B_EndWith_00 {

    /**
     * 计算 a+b, 指定组数.
     *
     * 输入:
     * 2
     * 10 2
     * 20 1
     *
     * 输出:
     * 12
     * 21
     *
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        while (i > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a + b);
            i--;
        }
    }

}
