package Regulation;
// Created by ZhangJian on 18/1/19.

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckData {

    public static boolean test(String amount) {
//        String regex = "^[1-9]([0-9]{1,23})(\\.[0-9]{1,4})?$";
        String regex = "^[1-9]([0-9]{1,23})(\\.[0-9]{1,4})?$";

        Matcher m = Pattern.compile(regex).matcher(amount);
        if (!m.matches()) {
            return false;
        }
        return true;
    }

    public static boolean test2(String amount, int n) {
        String regex = "^[1-9]([0-9]{1," + (n - 1) + "})([0-9]*([\\.]?)[0-9]*)";
        Matcher m = Pattern.compile(regex).matcher(amount);
        if (!m.matches()) {
            return false;
        }
        return true;
    }

    public static boolean isFloat(String amount) {
        String regex1;
        regex1 = "^[1-9]([0-9]*)(\\.[0-9]+)?";
        String regex2 = "^0";

        Matcher m1 = Pattern.compile(regex1).matcher(amount);
        Matcher m2 = Pattern.compile(regex2).matcher(amount);
        System.out.println(m2.matches());

        if (!m1.matches() && !m2.matches()) {
            System.out.println("不是浮点数");
        }
        return true;
    }

    public static void main(String[] args) {
//        String regex2 = "^([0]\\.)[0-9]+";
//        Matcher m2 = Pattern.compile(regex2).matcher("0..123");
//        System.out.println(m2.matches());
//
//        String t;
//        String t1 = "1234.123";
//        String t2 = "0.12345";
//        System.out.println(t1.indexOf("."));
//        String a = t1.substring(t1.indexOf(".")+1, t1.length());
//        System.out.println(a);
//        a = t1.substring(0,t1.indexOf("."));
//        System.out.println(a);
//        isFloat(t1);
//        String amount = "123.123";
//        amount = "0.123";
//
//        try {
//            System.out.println(passCheckStringDecimal(amount, 1, 4));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        int j=93;
        int A = 65;
        int Z = 90;
        String col = "";
        if (j <= Z && j >= A) {
            col += (char) j;
        } else {
            col = "A";
            col += (char) (j - Z + 64);
        }
        System.out.println(col);
    }

    public static boolean passCheckStringDecimal(String amount, int n, int m) throws Exception{
        //String regex = "^[1-9]([0-9]{1,23})(\\.[0-9]{1,4})?$";
        Matcher matcher;
        String regex;

        if ((n < 0 || m < 0) || (n == 0)) {
            throw new Exception("输入参数错误.");
        }

        String regex1 = "^[1-9]([0-9]*)(\\.[0-9]+)?";   // 整数部分>0的情况, 如果出现"00.12" 这种异常数据呢? 见 regex2
        String regex2 = "^([0]\\.)[0-9]+";              // 整数部分<0, 那一定是 0.123 这种格式
        Matcher matcher1 = Pattern.compile(regex1).matcher(amount);
        Matcher matcher2 = Pattern.compile(regex2).matcher(amount);
        // 首先 amount 必须是一个 正整数或小数
        if (!matcher1.matches() && !matcher2.matches()) {
            throw new Exception("输入参数不是正整数或小数字符串.");
        }

        int indexOfDot = amount.indexOf(".");
        // 如果没有小数点, 表示只包含正整数部分
        if (indexOfDot == -1) {
            // 如果正整数位数大于n
            if (amount.length() > n) {
                return false;
            }
        } else if (indexOfDot >= 1) { // 不管m取值是什么, 只有当有小数点"."的才比较小数范围
            // 整数部分
            String subAmount1 = amount.substring(0, indexOfDot);
            if (subAmount1.length() > n) {
                return false;
            }
            // 小数部分
            String subAmount2 = amount.substring(indexOfDot + 1, amount.length());
            if (subAmount2.length() > m) {
                return false;
            }
        }
        return true;
    }

    public static boolean passCheckStringData(String date) {
        String regex = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\\\/s]?((((0?[13578])|(1[02]))[\\-\\\\/s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\\\/s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\\\/s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\\\/s]?((((0?[13578])|(1[02]))[\\-\\\\/s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\\\/s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\\\/s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1][0-9])|([2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$";
        Matcher matcher = Pattern.compile(regex).matcher(date);
        if (!matcher.matches()){
            return false;
        }
        return true;
    }
}
