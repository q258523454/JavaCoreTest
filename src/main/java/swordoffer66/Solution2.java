package swordoffer66;

/**
 * Created By
 * <p>
 * 替换空格
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * @author :   zhangj
 * @date :   2019-01-18
 */
public class Solution2 {

    // 如果不允许开辟新的空间, 用这个. 
    public String replaceSpace(StringBuffer str) {
        int length = str.length() - 1;
        for (int i = length; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                str.append("20");
                // 后移
                for (int j = str.length() - 1; j > i + 2; j--) {
                    str.setCharAt(j, str.charAt(j - 2));
                }
                str.setCharAt(i, '%');
                str.setCharAt(i + 1, '2');
                str.setCharAt(i + 2, '0');
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer(" a b c d ");
        System.out.println(new Solution2().replaceSpace(stringBuffer));
    }
}
