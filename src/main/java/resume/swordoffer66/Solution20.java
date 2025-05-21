package resume.swordoffer66;

import java.util.Stack;

/**
 * Created By
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））
 *
 * @author :   zhangj
 * @date :   2018-12-25
 */
public class Solution20 {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (minStack.size() == 0) {
            minStack.push(node);
        } else {
            int curMin = minStack.peek();
            if (node < curMin) {
                minStack.push(node);
            } else {
                minStack.push(curMin);
            }
        }
    }

    public void pop() {
        if (stack.size() != 0) {
            stack.pop();
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        solution20.push(5);
        System.out.println(solution20.min());
        solution20.push(3);
        System.out.println(solution20.min());
        solution20.push(6);
        System.out.println(solution20.min());
        solution20.push(2);
        System.out.println(solution20.min());
        solution20.push(19);
        System.out.println(solution20.min());
    }
}
