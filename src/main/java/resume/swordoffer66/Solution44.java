package resume.swordoffer66;

/**
 * Created By
 * 翻转字符串中单词
 *
 * @author :   zhangj
 * @date :   2019-01-09
 */
public class Solution44 {


    // java String是传值类型,函数内只是一个副本.
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


    public String ReverseSentence(String str) {
        String res = "";
        String temp = "";
        for (int i = 0; i < str.length(); i++) {
            if (i == str.length() - 1) {
                temp += str.charAt(i);
                res += reverse(temp, 0, temp.length() - 1);
                break;
            }
            if (str.charAt(i) != ' ') {
                temp += str.charAt(i);
            } else {
                res += reverse(temp, 0, temp.length() - 1);
                res += " ";
                temp = "";
            }
        }
        System.out.println(res + "|");

        return reverse(res, 0, res.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution44().ReverseSentence("I am a student.") + "|");
    }

}
