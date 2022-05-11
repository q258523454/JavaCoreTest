package util;

import java.math.BigInteger;

public enum BigIntegerUtil {
    ;

    /**
     * 整数转换为36进制字符串，长度不足则左边补0
     */
    public static String bigIntegerToStr36(BigInteger i, int length) {
        return bigIntegerToStr(36, i, length);
    }

    /**
     * @Description 整数转换为指定进制的字符串，长度不足则左边补0
     * @date 2021年05月19日 15:18
     * @param radix 进制
     * @param i 要转换的整数
     * @param length 目标长度
     * @return 进制表示的字符串
     */
    public static String bigIntegerToStr(int radix, BigInteger i, int length) {

        if (i.compareTo(new BigInteger("0")) < 0) {
            throw new RuntimeException("输入不合法");
        }

        if (length <= 0) {
            throw new RuntimeException("输入不合法");
        }

        // 进制转换
        String s = i.toString(radix);
        int len = s.length();

        if (len == length) {
            return s;
        } else if (len > length) { // 超长，报错
            throw new RuntimeException("期望长度比实际长度小");
        } else {
            // len < length, 需要在左边补零
            StringBuilder sb = new StringBuilder(length);
            for (int j = len; j < length; j++) {
                sb.append('0');
            }
            sb.append(s);
            s = sb.toString();
            return s;
        }
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
