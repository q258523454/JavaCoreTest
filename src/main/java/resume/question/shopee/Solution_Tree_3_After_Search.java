package resume.question.shopee;

import com.alibaba.fastjson.JSON;
import resume.swordoffer66.base.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 *
 * 二叉树中序遍历,非递归
 *          1
 *       2     3
 *     4   5
 *       6   7
 *     9
 * 中序遍历: 4,2,9,6,5,7,1,3
 */
public class Solution_Tree_3_After_Search {


    private Stack<TreeNode> stack = new Stack<>();

    private List<Integer> middleList = new ArrayList<>();

    private Set<TreeNode> logicDeleteSet = new HashSet<>();


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
            temp = temp.left;
        }
    }

    /**
     * 弹栈
     * 然后再 把弹出节点的右节点 执行 pushStack()操作
     */
    public void popStack() {
        if (!stack.isEmpty()) {
            TreeNode pop = stack.peek();
            // 已经访问过
            if (logicDeleteSet.contains(pop)) {
                middleList.add(pop.val);
                stack.pop();
                return;
            }

            // 无右节点
            if (null == pop.right) {
                middleList.add(pop.val);
                stack.pop();
            } else {
                logicDeleteSet.add(pop);
                pushStack(pop.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTree(new int[]{1, 2, 3, 4, 5, 0, 0, 0, 0, 6, 7, 0, 0, 0, 0});
        // TreeNode treeNode = TreeNode.getTree(new int[]{1, 2, 3});
        Solution_Tree_3_After_Search solution = new Solution_Tree_3_After_Search();
        solution.middleSearch(treeNode);
        System.out.println(JSON.toJSONString(solution.middleList));
    }
}
