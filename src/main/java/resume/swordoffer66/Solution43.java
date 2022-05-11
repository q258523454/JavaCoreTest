package resume.swordoffer66;

/**
 * Created By
 * 左旋转字符串
 * 字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”
 * @author :   zhangj
 * @date :   2019-01-09
 */

public class Solution43 {
    public String LeftRotateString(String str, int n) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        n = n % str.length();
        String str1 = str.substring(0, n );
        String str2 = str.substring(n, str.length());
        return str2 + str1;

    }

    public static void main(String[] args) {
        System.out.println(new Solution43().LeftRotateString("abcdef", 6));
    }
}
