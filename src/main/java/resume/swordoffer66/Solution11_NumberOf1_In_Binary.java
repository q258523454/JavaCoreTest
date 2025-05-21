package resume.swordoffer66;

/**
 * Created By
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * @author :   zhangj
 * @date :   2019-01-18
 */
public class Solution11_NumberOf1_In_Binary {


    public int NumberOf1(int n) {
        int count = 0;

        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(new Solution11_NumberOf1_In_Binary().NumberOf1(-14));
        System.out.println(new Solution11_NumberOf1_In_Binary().NumberOf1(4));
        System.out.println(new Solution11_NumberOf1_In_Binary().NumberOf1(4));
        System.out.println(new Solution11_NumberOf1_In_Binary().NumberOf1(0xffffffff));

    }

}
