package resume.question.ACM_huazi.base;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @Description
 * @author zhang
 * @date 2022-04-26 15:15
 * @modify
 */
public class Main_BigDecimal {

    /**
     * 输入:
     * 10
     * 5
     *
     * 输出：
     * a+b=15
     * a-b=5
     * a*b=50
     * a/b=2
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigDecimal a = sc.nextBigDecimal();
        BigDecimal b = sc.nextBigDecimal();

        System.out.println("a+b=" + a.add(b));
        System.out.println("a-b=" + a.subtract(b));
        System.out.println("a*b=" + a.multiply(b));
        System.out.println("a/b=" + a.divide(b));
    }
}
