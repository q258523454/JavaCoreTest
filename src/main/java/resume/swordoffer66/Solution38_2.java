package resume.swordoffer66;

/**
 * Created By
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度
 * @author :   zhangj
 * @date :   2019-01-07
 */
public class Solution38_2 {

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDeep = TreeDepth(root.left) + 1;
        int rightDeep = TreeDepth(root.right) + 1;

        return leftDeep > rightDeep ? leftDeep : rightDeep;
    }

    public static void main(String[] args) {
        resume.swordoffer66.TreeNode A = resume.swordoffer66.TreeNode.getTree(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15});
        resume.swordoffer66.TreeNode.printTreeBroad(A);
        System.out.println(new Solution38_2().TreeDepth(A));
    }

}
