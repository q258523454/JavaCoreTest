package resume.onlineAC.arrylist;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2022-05-25
 */
public class Solution_BigAdd {
    /**
     * NC1 大数加法
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算两个数之和
     *
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public String solve(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();

        // 区分数字长度,以长度长的来做计算
        String longStr = "";
        String shortStr = "";
        if (len1 > len2) {
            longStr = s;
            shortStr = t;
        } else {
            longStr = t;
            shortStr = s;
        }

        int[] result = new int[longStr.length() + 1];
        int j = longStr.length();
        int longIndex = longStr.length() - 1;
        int shortIndex = shortStr.length() - 1;

        while (longIndex >= 0) {

            int a = '0';
            if (shortIndex >= 0) {
                a = shortStr.charAt(shortIndex);
            }

            int b = longStr.charAt(longIndex) - '0';
            a = a - '0';
            int cur = a + b + result[j];

            if (cur < 10) {
                result[j] = cur;
            } else {
                int mod = cur % 10;
                result[j] = mod;
                result[j - 1] = (cur / 10);
            }
            j--;
            longIndex--;
            shortIndex--;
        }

        // 之前多预留了一个进位,如果没有进位需要去掉
        int i = 0;
        while (i < result.length && result[i] == 0) {
            i++;
        }
        // 如果是0000这种,直接返回0
        if (i == result.length) {
            return new String("0");
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (; i < result.length; i++) {
            stringBuilder.append(result[i]);
        }

        return stringBuilder.toString();
    }
}
