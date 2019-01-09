package swordoffer66;

/**
 * Created By
 * 左旋转字符串
 * 字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”
 * @author :   zhangj
 * @date :   2019-01-09
 */
public class Solution43_2 {

    // 设X的翻转为XT，XT=cba，同理YT=fed，那么YX=(XTYT)T，三次翻转后可得结果
    public String LeftRotateString(String str, int n) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        int lastIndex = str.length() - 1;
        String A = reverse(str, 0, n - 1);
        String B = reverse(str, n, lastIndex);
        String res = reverse(A + B, 0, lastIndex);
        return res;
    }

    public String reverse(String str, int start, int end) {
        if (start > end) {
            return "";
        }
        int strLen = end - start + 1;
        char[] c = new char[strLen];
        for (int i = start; i <= start + strLen / 2; i++) {
            c[i - start] = str.charAt(end - (i - start));
            c[(strLen - 1) - (i - start)] = str.charAt(i);
        }
        String subStr = "";
        for (int i = 0; i < c.length; i++) {
            subStr += c[i];
        }
        return subStr;
    }


    public static void main(String[] args) {
        String str = "abcdefg";
        System.out.println(new Solution43_2().LeftRotateString(str, 1));
    }
}
