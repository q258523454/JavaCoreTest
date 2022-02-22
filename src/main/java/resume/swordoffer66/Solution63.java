package resume.swordoffer66;

/**
 * Created By
 * <p>
 * 二叉树第k小的结点
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 *
 * @author :   zhangj
 * @date :   2019-01-15
 */
public class Solution63 {

    public int count = 0;

    // 中序遍历
    public void midSearch(TreeNode root, int k, TreeNode[] res) {
        if (root == null || count > k) {
            return;
        }
        midSearch(root.left, k, res);
        count++;
        if (count == k) {
            res[0] = root;
        }
        midSearch(root.right, k, res);
    }


    TreeNode KthNode(TreeNode pRoot, int k) {
        TreeNode[] res = new TreeNode[1];
        midSearch(pRoot, k, res);
        TreeNode result = res[0];
        return result;
    }


    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree(new int[]{1, 2, 3, 0, 5, 7, 0});
        TreeNode.printTreeBroad(root);
        TreeNode[] res = new TreeNode[1];
        new Solution63().midSearch(root, 2, res);
        System.out.println(res[0].val);
    }
}
