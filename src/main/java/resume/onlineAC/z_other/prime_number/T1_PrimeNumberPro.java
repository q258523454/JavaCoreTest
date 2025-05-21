
package resume.onlineAC.z_other.prime_number;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

public class T1_PrimeNumberPro {
    /**
     * 204.
     * 计数质数
     * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
     * 一个大于1的自然数，除了1和其自身外，不能被别的自然数整除的数叫做质数，否则称为合数，质数又称素数
     * 在10以内有4个质数，分别为2、3、5和7。
     * eg:
     * 130808  -> 12231
     * 1500000 -> 114155
     * 素数: 1499977,199999991
     */
    public static void main(String[] args) {
        // 足够版
        System.out.println(countPrimes(200000000));
    }

    /**
     * 进阶, 足够.
     * 时间复杂度: nloglogn
     */
    public static int countPrimes(int n) {
        int[] isPrime = new int[n];
        // x 是质数，那么大于 x 的 x 的倍数 2x,3x,…2x,3x,… 一定不是质数
        Arrays.fill(isPrime, 1);
        // 注意 isPrime[0],isPrime[1] 都不是质数范围，质数范围是是大于1的自然数
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == 1) {
                count += 1;
                for (int j = i + i; j < n; j += i) {
                    isPrime[j] = 0;
                }
            }
        }
        for (int i = isPrime.length-1; i >0; i--) {
            if (isPrime[i] == 1) {
                System.out.println(i);
                break;
            }
        }
        return count;
    }

    /**
     * 高阶
     */
    public static int countPrimesImprove(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == 1) {
                count += 1;
                // 优化1: i*i<n
                if ((long) i * i < n) {
                    // 优化2: 从i*i开始, 因为2i,3i....之前已经都标记过了
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return count;
    }
}
