package util;

import com.ibm.icu.text.Transliterator;
import org.apache.commons.lang3.math.NumberUtils;

import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Date: 2019-07-11
 * @Version 1.0
 */
public enum StringUtil {
    ;

    /**
     * 去除多余的回车换行空格符
     */
    public static String delAllSpace(String sql) {
        return sql.trim().replace("\n", "").
                replace("\\n", "").
                replace("\r", "").
                replace("\\r", "").
                replace("\t", "").
                replace("\\t", "").
                replace("\f", "").
                replace("\\f", "").
                replace(" ", "");
    }

    /**
     * 去所有空白字符
     */
    public static String delAllBlank(String str) {
        if (!"".equals(str)) {
            return str.replaceAll("\\s*", "");
        }
        return str;
    }

    /**
     * 判断字符串是否只包含数字(不包含小数)
     */
    public static boolean isAllInteger(String str) {
        // 必须是 金额型 字符串, 以 "0"开头的都不是金额型, 规则: 1-9开头,可含小数点
        // String regex = "^[1-9][0-9]*(.[0-9]*)?$";
        // 必须是 金额型 字符串, 以 "0"开头的都默认是金额型, 规则: 1-9开头,可含小数点
        String regex = "^[0-9][0-9]*";
        Matcher m = Pattern.compile(regex).matcher(str);
        return m.matches();
    }

    /**
     * 整数和小数
     */
    public static boolean isNumeric(String str) {
        // 下面这种写法 小数点左边必须含有值
        // return str.matches("-?\\d+(\\.\\d+)?");
        return NumberUtils.isCreatable(str);
    }

    /**
     * 判断字符串是否包含中文
     */
    public static boolean containsChinese(String str) {
        int i = 0;
        while (i < str.length()) {
            int codePointAt = str.codePointAt(i);
            // 判断是否包含中文
            if (Character.UnicodeScript.of(codePointAt) == Character.UnicodeScript.HAN) {
                return true;
            }
            i += Character.charCount(codePointAt);
        }
        return false;
    }

    /**
     * 按字节长度截取字符串(指定字符编码)
     * 避免出现半个字符, 必须向下取整, 因此截取后对应的byte[]可能小于目标字节数。
     *
     * @param s             字符串
     * @param byteLength    目标长度（字节数）
     * @param charset       截取后的字符串
     * @return String
     */
    public static String cut(String s, int byteLength, Charset charset) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        // 优化:字节长度为byteLength的字符, 它的字符长度按最少的单字节算是length=byteLength, 即截取后的长度不会超过 byteLength
        // 因此先按输入字节长度来截取字符串,减少循环次数
        if (s.length() > byteLength) {
            char c = s.charAt(byteLength - 1);
            // 字符串s中可能输入emoji表情,这种字符需要占用2个连续的字符位. 例如一个表情为 '\uD83D\uDC33'
            // 特殊字符可能会占2字符长度(例如:emoji表情, 2个字节:高字节位+低字节位)，避免截出半个字符
            // 如果最后一个字节是高位,说明字符串中的最后一个字符是半个emoji,必须去掉
            if (Character.isHighSurrogate(c)) {
                s = s.substring(0, byteLength - 1);
            } else {
                s = s.substring(0, byteLength);
            }
        }
        while (charset.encode(s).limit() > byteLength) {
            char lastChar = s.charAt(s.length() - 1);
            // 字符串s中可能输入emoji表情,这种字符需要占用2个连续的字符位. 例如一个表情为 '\uD83D\uDC33'
            // 特殊字符可能会占2字符长度(例如:emoji表情, 2个字节:高字节位+低字节位)，避免截出半个字符
            // 只有当前字符是特殊字符(emoji)低位时候,需要往前移动2个字符位,其他的全部一个一个往前cut
            if (Character.isLowSurrogate(lastChar)) {
                s = s.substring(0, s.length() - 2);
            } else {
                s = s.substring(0, s.length() - 1);
            }
        }
        return s;
    }

    /**
     * 全半角转换
     */
    public static final class StringTransform {
        /**
         * 半角转全角 "ABC"->"ＡＢＣ"
         */
        public static String half2Full(String str) {
            Transliterator literator = Transliterator.getInstance("Halfwidth-Fullwidth");
            return literator.transliterate(str);
        }

        /**
         * 全角转半角 "コンニチハ"->"ｺﾝﾆﾁﾊ"
         */
        public static String full2Half(String str) {
            Transliterator literator = Transliterator.getInstance("Fullwidth-Halfwidth");
            return literator.transliterate(str);
        }
    }

    /**
     * 大写首字母
     */
    public static String captureName(String text) {
        if (text.length() > 0) {
            text = text.substring(0, 1).toUpperCase() + text.substring(1);
        }
        return text;
    }

    public static void main(String[] args) {
        String half = "ABC:､;";
        String full = "ＡＢＣ：、；";


        String jFull = "ｺﾝﾆ:、；";
        String jHalf = "コンニ：､;";

        System.out.println("转全角 " + StringUtil.StringTransform.half2Full(half));
        System.out.println("转全角 " + StringUtil.StringTransform.half2Full(full));
        System.out.println("转全角 " + StringUtil.StringTransform.half2Full(jHalf));
        System.out.println("转全角 " + StringUtil.StringTransform.half2Full(jFull));

        System.out.println();

        System.out.println("转半角 " + StringUtil.StringTransform.full2Half(half));
        System.out.println("转半角 " + StringUtil.StringTransform.full2Half(full));
        System.out.println("转半角 " + StringUtil.StringTransform.full2Half(jHalf));
        System.out.println("转半角 " + StringUtil.StringTransform.full2Half(jFull));

    }
}
