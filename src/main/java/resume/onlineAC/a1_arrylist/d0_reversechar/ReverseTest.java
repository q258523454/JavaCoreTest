package resume.onlineAC.a1_arrylist.d0_reversechar;

import com.google.common.primitives.Chars;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReverseTest {

    public static void main(String[] args) {
        System.out.println(reverseString("abc123"));
        System.out.println(reverseString2("abc123"));
    }

    /**
     * 翻转字符串
     * abc123 ——>321cba
     */
    private static String reverseString(String str) {
        char[] chars = str.toCharArray();
        Chars.reverse(chars);
        return new String(chars);
    }

    private static String reverseString2(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }
        return new String(chars);
    }
}