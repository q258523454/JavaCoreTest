package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum BigDecimalUtil {
    ;

    private static final Logger logger = LoggerFactory.getLogger(BigDecimalUtil.class);


    /**
     * 判断是否数值类型,至多13位整数,3位小数
     */
    public static boolean isNumeric(BigDecimal num) {
        String numStr = num.toString();
        //  必须是 金额型 字符串, 以 "0"开头的都不是金额型, 规则: 1-9开头,可含小数点(小数点后最多2位 整数位最多13位)
        String regex = "(^[1-9])([0-9]{0,12})(\\.[0-9]{0,3})?$";
        Matcher m = Pattern.compile(regex).matcher(numStr);
        if (m.matches()) {
            return true;
        }
        return false;
    }

    /**
     * 判断 BigDecimal 是不是一个整数值(没有小数位), 忽略小数位的补0
     */
    public static boolean isIntegerValue(BigDecimal bd) {
        // 注意: 100.00 也是属于整数, 小数后面是0的都会忽略
        // signum(): 判断正负数
        // scale(): 判断精度
        // stripTrailingZeros():去掉末尾多余的0
        return bd.signum() == 0 || bd.scale() <= 0 || bd.stripTrailingZeros().scale() <= 0;
    }

    /**
     * 获取小数位的总位数, 忽略小数位的补0
     */
    public static int getNumberOfDecimal(BigDecimal bigDecimal) {
        return bigDecimal.stripTrailingZeros().scale();
    }

    /**
     * 提取小数位部分, 忽略小数位的补0
     */
    public static BigDecimal extractFraction(BigDecimal bigDecimal) {
        // 等价于 bigDecimal.subtract(bigDecimal.setScale(0, BigDecimal.ROUND_DOWN)
        return bigDecimal.remainder(BigDecimal.ONE);
    }

    /**
     * 提取整数部分
     */
    public static BigDecimal extractInteger(BigDecimal bigDecimal) {
        BigInteger bigInteger = bigDecimal.toBigInteger();
        return new BigDecimal(bigInteger.toString());
    }

    /**
     * 判断是否是微信红包,至多2位整数(不超过200),2位小数
     */
    public static boolean isWeChatRedPackage(BigDecimal num) {
        int signum = num.signum();
        int scale = num.stripTrailingZeros().scale();
        // 微信红包必须为正整数,且小数位不能超过2位
        if (signum != 1 || scale > 2) {
            return false;
        }
        // 微信红包不能超过200
        if (num.compareTo(new BigDecimal("200")) > 0) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {

        System.out.println(isIntegerValue(new BigDecimal("123.123")));
        System.out.println(isIntegerValue(new BigDecimal("123.0")));
        System.out.println(isIntegerValue(new BigDecimal("123.")));
        System.out.println(isIntegerValue(new BigDecimal("123")));


    }
}
