package resume.swordoffer66;

/**
 * Created By
 * 不用加减乘除做加法
 *
 * @author :   zhangj
 * @date :   2019-01-10
 */
public class Solution50_3 {


    //  异或^:计算加法 (不包含进位), &:计算进位
    public int Add(int num1, int num2) {
        // temp存储每次计算的进位
        int temp = num2;
        while (temp != 0) {
            temp = (num1 & temp) << 1;
            num1 = num1 ^ num2; // 计算加法 (不包含进位)
            num2 = temp;
        }
        return num1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution50_3().Add(3, 4));
    }
}
