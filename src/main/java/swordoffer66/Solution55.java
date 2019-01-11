package swordoffer66;

/**
 * Created By
 * 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 * @author :   zhangj
 * @date :   2019-01-11
 */
public class Solution55 {

    public boolean isNum(char c) {

        if (c > '9' || c < '0') {
            return false;
        }
        return true;
    }

    // start~end之间是没有E/e的
    public boolean solve(char[] str, int start, int end, boolean isRightE) {

        if (start > end || start < 0 || end >= str.length) {
            return false;
        }

        // 如果只有1个字符, 只允许是数值类型
        if (start == end) {
            if (!isNum(str[start])) {
                return false;
            }
        }

        // 表达式中不允许出现2个及以上的小数点'.'
        int countDot = 0;
        for (int i = start; i < end; i++) {
            if (str[i] == '.') {
                countDot++;
            }
        }
        if (countDot > 1) {
            return false;
        }

        // E/e的右边是不允许出现小数的
        if (countDot > 0 && isRightE) {
            return false;
        }

        // 如果有符号位,符号位只可能出现在表达式的首位置
        int i = start;
        if (str[start] == '+' || str[start] == '-') {
            start = start + 1;
        }

        // 只有一个符号位+,-
        if (start > end) {
            return false;
        }

        for (i = start; i <= end; i++) {
            // '.'前面已判断最多出现一次 ('.'出现在哪里已经不重要了 +.12, -32., etc.. ), 但是前后必须至少有一个是数字
            if (str[i] == '.') {
                int index = (i == start ? (start + 1) : (i == end ? end - 1 : i));
                if (index == i) {
                    if (!isNum(str[index - 1]) && !isNum(str[index + 1])) {
                        return false;
                    }
                } else {
                    if (!isNum(str[index])) {
                        return false;
                    }
                }
            }
            if (!isNum(str[i]) && str[i] != '.') {
                return false;
            }
        }
        return true;
    }

    public boolean isNumeric(char[] str) {

        int[] eArray = new int[str.length];
        int j = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'E' || str[i] == 'e') {
                eArray[j++] = i;
            }
        }

        // 如果含有E/e
        if (j > 0) {
            if (eArray[j - 1] == str.length - 1) {
                return false;
            } else {
                // 最后一个e, 后面的表达式不为空
                eArray[j++] = str.length;

            }

            boolean flag = true;
            boolean isRightE = false;
            int start = 0;
            int end;
            for (int i = 0; i < j; i++) {
                if (flag == false) {
                    return false;
                }
                end = eArray[i];
                flag &= solve(str, start, end - 1, isRightE);
                start = end + 1;
                isRightE = true;
            }
            if (flag == false) {
                return false;
            }
        } else {
            return solve(str, 0, str.length - 1, false);
        }
        return true;
    }


    public static void main(String[] args) {

        String str = "12E";
        char[] a = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            a[i] = str.charAt(i);
        }
        System.out.println(a);
        System.out.println(new Solution55().isNumeric(a));
        System.out.println();
    }
}
