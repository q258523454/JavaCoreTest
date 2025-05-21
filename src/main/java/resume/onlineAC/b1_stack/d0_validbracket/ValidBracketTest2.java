package resume.onlineAC.b1_stack.d0_validbracket;

import java.util.Stack;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2022-05-24
 */
public class ValidBracketTest2 {

    Stack<Character> stack = new Stack<>();

    /**
     * NC52 有效括号序列
     * 描述
     * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
     * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
     * <p>
     * 输入：
     * "()[]{}"
     * 返回值：
     * true
     */
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if ('(' == aChar || '{' == aChar || '[' == aChar) {
                stack.push(aChar);
            } else {
                Character pop = stack.pop();
                if (')' == aChar && pop == '(') {
                    continue;
                }
            }
        }

        return true;
    }
}
