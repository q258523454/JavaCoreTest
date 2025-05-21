package resume.swordoffer66;

/**
 * Created By
 * 不用加减乘除做加法
 *
 * @author :   zhangj
 * @date :   2019-01-10
 */
public class Solution50_2 {
    public int Add(int num1, int num2) {
        if (num1 > 0) {
            while (num1 != 0) {
                num1--;
                num2++;
            }
        }
        if (num1 < 0) {
            while (num1 != 0) {
                num1++;
                num2--;
            }
        }
        return num2;
    }

    public static void main(String[] args) {
        System.out.println(new Solution50_2().Add(3, 4));
    }
}
