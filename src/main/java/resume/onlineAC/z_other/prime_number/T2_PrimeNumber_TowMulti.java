
package resume.onlineAC.z_other.prime_number;

import java.util.Arrays;
import java.util.Scanner;

public class T2_PrimeNumber_TowMulti {
    /**
     * 题目描述：
     * RSA加密算法在网络安全世界中无处不在，它利用了极大整数因数分解的困难度，数据越大，安全系数越高
     * 给定一个32位正整数，请对其进行因数分解，找出是哪两个素数的乘积。
     * 输入描述：
     * 一个正整数num
     * 0 < num <= 2147483647
     * 输出描述：如果成功找到，以单个空格分割，从小到大输出两个素数，分解失败，请输出-1 -1
     *
     * 示例1
     * 输入：15
     * 输出：3 5
     * 说明：因数分解后，找到两个素数3和5，使得3*5=15，按从小到大排列后，输出3 5
     *
     * 示例2
     * 输入：27
     * 输出：-1 -1
     * 说明：通过因数分解，找不到任何素数，使得他们的乘积为27，输出-1 -
     *
     * 700036991
     * 7001 99991
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int num = in.nextInt();
            int[] primeArr = getPrimeArray(num);
            boolean existPrimeMulti = false;
            for (int i = 0; i <= primeArr.length / 2; i++) {
                // 乘积只需要访问到 1...sqrt(n)
                if (i * i < primeArr.length && primeArr[i] == 1) {
                    if (num % i == 0 && primeArr[num / i] == 1) {
                        existPrimeMulti = true;
                        System.out.println(i + " " + (num / i));
                    }
                }
            }
            if (!existPrimeMulti) {
                System.out.println("-1 -1");
            }
        }


    }

    /**
     * 返回 n 内所有的质数
     * a[i]=1 表示 i 为质数
     */
    public static int[] getPrimeArray(int n) {
        // 最大下标n
        int len = n + 1;
        int[] primeArr = new int[len];
        // 注意 primeArr[0],primeArr[1] 都不是质数
        Arrays.fill(primeArr, 1);
        primeArr[0] = 0;
        primeArr[1] = 0;
        for (int i = 2; i < len; i++) {
            if (primeArr[i] == 1) {
                // x 是质数，那么大于 x 的 x 的倍数 2x,3x,…2x,3x,… 一定不是质数
                for (int j = i + i; j < n + 1; j += i) {
                    primeArr[j] = 0;
                }
            }
        }
        return primeArr;
    }

}
