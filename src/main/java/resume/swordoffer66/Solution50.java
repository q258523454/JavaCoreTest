package resume.swordoffer66;

/**
 * Created By
 * 不用加减乘除做加法
 *
 * @author :   zhangj
 * @date :   2019-01-10
 */
public class Solution50 {

    public int sumAdd = 0;

    Solution50() {

    }

    Solution50(int num1, int num2) {
        sumAdd = num1 + num2;
    }

    public int Add(int num1, int num2) {
        Solution50 solution50 = new Solution50(num1, num2);
        return solution50.sumAdd;
    }


    public static void main(String[] args) {
        System.out.println(new Solution50().Add(1, 2));
    }

}
