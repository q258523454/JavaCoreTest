package resume.onlineAC.c1_tree;

import com.alibaba.fastjson.JSON;

import resume.swordoffer66.base.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * 后序遍历(非递归)
 *          1
 *       2     3
 *     4   5
 *       6   7
 *     9
 * 后续遍历: 4,9,6,7,5,2,3,1
 */
public class T3_AfterSearchPro {


    private final Stack<TreeNode> stack = new Stack<>();

    private final List<Integer> list = new ArrayList<>();

    private final Set<TreeNode> treeNodeSet = new HashSet<>();


    public void afterSearch(TreeNode treeNode) {
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
        TreeNode pop = stack.peek();
        // 已经访问过 或者 无右节点
        if (treeNodeSet.contains(pop) || null == pop.right) {
            list.add(pop.val);
            stack.pop();
        } else {
            treeNodeSet.add(pop);
            pushStack(pop.right);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTree(new int[]{1, 2, 3, 4, 5, 0, 0, 0, 0, 6, 7, 0, 0, 0, 0});
        // TreeNode treeNode = TreeNode.getTree(new int[]{1, 2, 3});
        T3_AfterSearchPro solution = new T3_AfterSearchPro();
        solution.afterSearch(treeNode);
        System.out.println(JSON.toJSONString(solution.list));
    }
}
