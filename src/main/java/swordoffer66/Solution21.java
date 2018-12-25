package swordoffer66;

/**
 * Created By
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈
 * 的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * <p>
 * 思路: 关键是看相对顺序
 * 例如 压栈:1,2,3,4,5 弹栈:4,3,5,1,2
 * 如果弹栈第一个元素是 4, 那么 根据 1,2,3,4,5 的压栈顺序, 4之前的1,2,3出栈顺序相对顺序一定是: 3□2□1 , 明显4,3,5,1,2中 1,2的相对顺序错了
 * @author :   zhangj
 * @date :   2018-12-25
 */

public class Solution21 {
    public boolean IsPopOrder(int[] pushA, int[] popA) {

        if (popA.length != pushA.length) {
            return false;
        }

        if (popA.length == 1) {
            return popA[0] == pushA[0];
        }

        int head = popA[0];

        int j = 0;
        // 找到第一个弹栈元素在压栈元素中的位置
        while (head != pushA[j] && j < pushA.length) {
            j++;
        }

        // 没找到
        if (j >= pushA.length) {
            return false;
        }

        int i = 1;
        int k = j - 1;

        for (; k >= 0; k--) {
            int search = pushA[k];

            // 确认相对位置
            while (i < popA.length && popA[i] != search) {
                i++;
            }
            if (i >= popA.length) {
                break;
            }
            i++;
        }

        if (k < 0) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int a[] = {1,2};
        int b[] = {2,1};
        System.out.println(new Solution21().IsPopOrder(a, b));
    }
}
