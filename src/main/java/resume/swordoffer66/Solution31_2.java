package resume.swordoffer66;


/**
 * Created By
 * 演变: {0,n}的整数中，有多少个整数包含1
 *
 * @author :   zhangj
 * @date :   2018-12-28
 */

public class Solution31_2 {
    public int NumberOf1Between1AndN_Solution(int n) {

        int num = n;
        int high = 1;
        int count = 1;
        while (num / 10 != 0) {
            high *= 10;
            count++;
            num = num / 10;
        }

        num = n;
        int sum = 0;

        int A;
        int w = count;
        while (num != 0) {
            System.out.println("sum=" + sum);
            System.out.println("w=" + w);
            A = num / high;
            if (A == 1) {
                return sum + (pow(10, w - 1) - pow(9, w - 1)) + (num - A * high + 1);
            }
            sum += solver(A, w - 1);
            w--;
            num = num - A * high;
            high = high / 10;
        }

        return sum;
    }

    // a是最高位,w是低位长度(9的个数), 例如5999, a=5, w=3
    public int solver(int A, int w) {
        if (w == 0) {
            return 1;
        }
        // A999..99 含有1的次数是 A*{pow(10,w)-pow(9,w)}+1*pow(10,w)
        return A * (pow(10, w) - pow(9, w)) + 1 * pow(10, w);
    }

    public int pow(int a, int n) {
        if (n == 1) {
            return a;
        }
        return a * pow(a, n - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution31_2().NumberOf1Between1AndN_Solution(13));

    }
}