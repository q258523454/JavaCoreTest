package resume.swordoffer66;

import resume.swordoffer66.base.TreeNode;

/**
 * Created By
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * @author :   zhangj
 * @date :   2019-01-07
 */
public class Solution39_2 {

    public boolean IsBalanced_Solution(TreeNode root) {
        boolean[] flag = new boolean[1];
        flag[0] = true;
        int isBlanceTree = getDeep(root, flag);
        return flag[0] == false ? false : true;
    }

    // flag初始值:1  0:非平衡二叉树
    public int getDeep(TreeNode root, boolean[] flag) {
        if (root == null) {
            return 0;
        }

        // 减枝
        if (flag[0] == true) {
            int leftDeep = getDeep(root.left, flag) + 1;
            int rightDeep = getDeep(root.right, flag) + 1;
            int diff = leftDeep - rightDeep;
            diff = diff > 0 ? diff : 0 - diff;
            if (diff > 1) {
                flag[0] = false;
            }
            return leftDeep > rightDeep ? leftDeep : rightDeep;
        }
        return -1;

    }

    public static void main(String[] args) {
//        resume.swordoffer66.base.TreeNode A = resume.swordoffer66.base.TreeNode.getTree(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15});
        TreeNode A = TreeNode.getTree(new int[]{1, 2, 3, 4, 5, 0, 0, 0, 0, 6});
        TreeNode.printTreeBroad(A);
        System.out.println(new Solution39_2().IsBalanced_Solution(A));
    }
}
