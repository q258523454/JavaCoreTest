package resume.swordoffer66;

/**
 * Created By
 * <p>
 * 对称的二叉树
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 * @author :   zhangj
 * @date :   2019-01-14
 */


public class Solution59 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    boolean isEqual(TreeNode left, TreeNode right) {

        if (left == null) {
            return right == null ? true : false;
        }
        if (right == null) {
            return left == null ? true : false;
        }
        return (left.val == right.val) && isEqual(left.left, right.right) && isEqual(left.right, right.left);

    }

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        TreeNode left = pRoot.left;
        TreeNode right = pRoot.right;
        return isEqual(left, right);
    }

    public static void main(String[] args) {

    }
}
