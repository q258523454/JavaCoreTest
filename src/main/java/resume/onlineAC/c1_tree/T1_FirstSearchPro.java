package resume.onlineAC.c1_tree;

import com.alibaba.fastjson.JSON;
import resume.swordoffer66.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * 二叉树先序遍历,非递归
 *          1
 *       2     3
 *     4   5
 *       6   7
 *     9
 * 先序遍历: [1,2,4,5,6,7,3]
 */
public class T1_FirstSearchPro {


    private final Stack<TreeNode> stack = new Stack<>();

    private final List<Integer> list = new ArrayList<>();


    public void middleSearch(TreeNode treeNode) {
        TreeNode head = treeNode;
        pushStack(head);

        while (!stack.isEmpty()) {
            popStack();
        }
    }

    /**
     * 当前节点及其left节点全部压入栈
     */
    public void pushStack(TreeNode treeNode) {
        TreeNode temp = treeNode;
        while (null != temp) {
            stack.push(temp);
            // 先序遍历: 注意 middleList.add 位置
            list.add(temp.val);
            temp = temp.left;
        }
    }

    /**
     * 弹栈
     * 然后再 把弹出节点的右节点 执行 pushStack()操作
     */
    public void popStack() {
        if (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (null != pop.right) {
                pushStack(pop.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTree(new int[]{1, 2, 3, 4, 5, 0, 0, 0, 0, 6, 7, 0, 0, 0, 0});
        // TreeNode treeNode = TreeNode.getTree(new int[]{1, 2, 3});
        T1_FirstSearchPro solution = new T1_FirstSearchPro();
        solution.middleSearch(treeNode);
        System.out.println(JSON.toJSONString(solution.list));
    }
}