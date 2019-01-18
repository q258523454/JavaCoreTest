package swordoffer66;

import java.util.Stack;

/**
 * Created By
 * <p>
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * @author :   zhangj
 * @date :   2019-01-18
 */
public class Solution5 {


    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    // 出栈,stack2为空, 则需要倾倒所有stack1,如果同时为空返回0
    public int pop() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return 0;
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
