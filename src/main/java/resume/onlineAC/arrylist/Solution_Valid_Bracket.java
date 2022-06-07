package resume.onlineAC.arrylist;

import java.util.Stack;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2022-05-24
 */
public class Solution_Valid_Bracket {

    Stack<Character> stack = new Stack<>();

    /**
     * NC52 有效括号序列
     * 描述
     * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
     * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
     *
     * 输入：
     * "()[]{}"
     * 返回值：
     * true
     */
    public boolean isValid(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('(' == c || '{' == c || '[' == c) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                boolean flag1 = (pop == '{' && c == '}');
                boolean flag2 = (pop == '[' && c == ']');
                boolean flag3 = (pop == '(' && c == ')');
                if (!(flag1 || flag2 || flag3)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
