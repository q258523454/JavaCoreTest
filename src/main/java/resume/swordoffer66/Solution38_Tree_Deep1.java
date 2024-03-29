package resume.swordoffer66;

import resume.swordoffer66.base.TreeNode;

import java.util.LinkedList;

/**
 * Created By
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度
 *
 * @author :   zhangj
 * @date :   2019-01-07
 */
public class Solution38_Tree_Deep1 {


    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        LinkedList<TreeNode> treeNodeList = new LinkedList<>();
        treeNodeList.add(root);
        root.val = 1;
        int deep = -1;
        TreeNode temp = treeNodeList.getFirst();
        while (temp != null) {
            deep = temp.val;
            if (temp.left != null) {
                temp.left.val = temp.val + 1;
                treeNodeList.add(temp.left);
            }
            if (temp.right != null) {
                temp.right.val = temp.val + 1;
                treeNodeList.add(temp.right);
            }
            treeNodeList.removeFirst();
            if (!treeNodeList.isEmpty()) {
                temp = treeNodeList.getFirst();
            } else {
                temp = null;
            }
        }
        return deep;
    }


    public static void main(String[] args) {
        TreeNode A = TreeNode.getTree(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15});
        TreeNode.printTreeBroad(A);
        System.out.println(new Solution38_Tree_Deep1().TreeDepth(A));
    }


}
