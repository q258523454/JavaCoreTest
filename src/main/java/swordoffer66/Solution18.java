package swordoffer66;

/**
 * Created By
 *
 操作给定的二叉树，将其变换为源二叉树的镜像。
 * @author :   zhangj
 * @date :   2018-12-25
 */
public class Solution18 {
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = right;
        root.right = left;

        Mirror(root.left);
        Mirror(root.right);

    }

    public static void main(String[] args) {
        TreeNode A = TreeNode.getTree(new int[]{1,2,3,0,0,4,5});
        TreeNode.printTreeBroad(A);
        Solution18 solution = new Solution18();
        solution.Mirror(A);
        TreeNode.printTreeBroad(A);
    }

}
