package resume.swordoffer66;

/**
 * Created By
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * @author :   zhangj
 * @date :   2018-12-26
 */
public class Solution26 {

//    public class TreeNode {
//        int val = 0;
//        TreeNode left = null;
//        TreeNode right = null;
//
//        public TreeNode(int val) {
//            this.val = val;
//
//        }
//    }

    /**
     * @param pRootOfTree
     * @param flag        0:首次调用 1:左子树(返回最大节点), 2:右子树(返回最小节点)
     * @return
     */
    public TreeNode SubConvert(TreeNode pRootOfTree, int flag) {

        TreeNode left = pRootOfTree.left;
        TreeNode right = pRootOfTree.right;
        if (left == null && right == null) {
            return pRootOfTree;
        }

        if (left == null) {
            pRootOfTree.right = SubConvert(right, 2);

            pRootOfTree.right.left = pRootOfTree;
            // 右子树,返回双向链表最小的节点
            return pRootOfTree.left == null ? pRootOfTree : pRootOfTree.left;

        }

        if (right == null) {
            pRootOfTree.left = SubConvert(left, 1);
            pRootOfTree.left.right = pRootOfTree;
            // 左子树,返回双向链表最大的节点
            return pRootOfTree.right == null ? pRootOfTree : pRootOfTree.right;
        }

        pRootOfTree.left = SubConvert(left, 1);
        pRootOfTree.left.right = pRootOfTree;
        pRootOfTree.right = SubConvert(right, 2);
        pRootOfTree.right.left = pRootOfTree;

        if (flag == 1) {
            return pRootOfTree.right;
        }
        if (flag == 2) {
            return pRootOfTree.left;
        }

        return pRootOfTree;
    }


    public TreeNode Convert(TreeNode pRootOfTree) {

        if (pRootOfTree == null) {
            return pRootOfTree;
        }

        // 注意此时pRootOfTree是根节点,将下标移至第一个节点位置
        TreeNode treeNode = SubConvert(pRootOfTree, 0);
        while (treeNode.left != null) {
            treeNode = treeNode.left;
        }
        return treeNode;
    }



    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTree(new int[]{4, 2, 6, 1, 3, 5, 7});
        TreeNode.printTreeBroad(treeNode);
        TreeNode temp = new Solution26().Convert(TreeNode.getTree(new int[]{4, 2, 6, 1, 3, 5, 7}));
        while (temp != null) {
            System.out.print(temp.val+".");
            temp = temp.right;
        }
        System.out.println();

        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(2);
        TreeNode treeNode5 = new TreeNode(1);
        treeNode1.left = treeNode2;
        treeNode2.left = treeNode3;
        treeNode3.left = treeNode4;
        treeNode4.left = treeNode5;
//        TreeNode.printTreeBroad(treeNode);
        temp = new Solution26().Convert(treeNode1);
        while (temp != null) {
            System.out.print(temp.val);
            temp = temp.right;
        }
        System.out.println();

        System.out.println(new Solution26().Convert(null));
    }
}
