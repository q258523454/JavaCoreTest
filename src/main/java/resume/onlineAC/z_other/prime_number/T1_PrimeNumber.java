
package resume.onlineAC.z_other.prime_number;

import java.util.Scanner;

/**
 * T1_PrimeNumber_CountAll
 *
 * @since 2024-06-05
 */
public class T1_PrimeNumber {
    /**
     * 204. 计数质数
     * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
     * 一个大于1的自然数，除了1和其自身外，不能被别的自然数整除的数叫做质数，否则称为合数，质数又称素数
     * 在10以内有4个质数，分别为2、3、5和7。
     * <p>
     * eg:
     * 130808  -> 12231
     * 1500000 -> 114155
     *
     * @param args args
     */
    public static void main(String[] args) {
        // 时间复杂度 n*logn
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int count = 0;
            int num = in.nextInt();
            for (int i = 2; i < num; i++) {
                if (isPrimeNumber(i)) {
                    System.out.println("质数:"+i);
                    count++;
                }
            }
            System.out.println("总数:"+count);
        }
    }

    /**
     * 是否是素数/质数
     *
     * @param num num
     * @return boolean
     */
    public static boolean isPrimeNumber(int num) {
        if (num == 2) {
            return true;
        }
        // 排除1和偶数(除2以外)
        if (num <= 1 || num % 2 == 0) {
            return false;
        }
        // Math.sqrt(num) 减少迭代次数
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
