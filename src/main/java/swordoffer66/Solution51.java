package swordoffer66;

/**
 * Created By
 * 把字符串转换成整数, 字符串不符合数字要求时返回0
 *
 * @author :   zhangj
 * @date :   2019-01-10
 */
public class Solution51 {
    public int StrToInt(String str) {

        int sum = 0;
        int start = 0;
        boolean isPositive = true;
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            start = 1;
            if (str.charAt(0) == '-') {
                isPositive = false;
            }
        }
        for (int i = start; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return 0;
            }
            sum *= 10;
            int value = str.charAt(i) - '0';
            sum += value;
        }
        return isPositive ? sum : -sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution51().StrToInt("-123"));

    }

}
