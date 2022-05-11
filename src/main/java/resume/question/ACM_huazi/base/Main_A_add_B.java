package resume.question.ACM_huazi.base;

import java.util.Scanner;

/**
 * @Description
 * @author zhang
 * @date 2022-04-26 15:18
 * @modify
 */
public class Main_A_add_B {

    /**
     * 计算 a+b
     *
     * 输入:
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

        // 方式一
        while (sc.hasNextLine()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a + b);
        }

        // 方式二
        // while (sc.hasNextLine()) {
        //     String s = sc.nextLine();
        //     String[] s1 = s.split(" ");
        //     int a = Integer.parseInt(s1[0]);
        //     int b = Integer.parseInt(s1[1]);
        //     System.out.println(a + b);
        // }
    }

}
