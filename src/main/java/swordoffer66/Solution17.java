package swordoffer66;

/**
 * Created By
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * @author :   zhangj
 * @date :   2018-12-24
 */
public class Solution17 {

    // 判断root2是否为root1的子结构(跟isTotalSubStree是有区别的)
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }

        class ListNode {
            TreeNode treeNode;
            ListNode next = null;

            ListNode(TreeNode treeNode) {
                this.treeNode = treeNode;
            }
        }

        ListNode listNode1 = new ListNode(root1);
        ListNode temp1 = listNode1;

        while (listNode1 != null) {
            if (temp1.treeNode.left != null) {
                temp1.next = new ListNode(temp1.treeNode.left);
                temp1 = temp1.next;
            }

            if (temp1.treeNode.right != null) {
                temp1.next = new ListNode(temp1.treeNode.right);
                temp1 = temp1.next;
            }

            if (listNode1.treeNode.val == root2.val) {
                if (isTotalSubStree(listNode1.treeNode, root2) == true) {
                    return true;
                }
            }
            listNode1 = listNode1.next;
        }
        return false;
    }

    // root2是root1完全子结构(从根节点开始)
    public boolean isTotalSubStree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }

        class ListNode {
            TreeNode treeNode;
            ListNode next = null;

            ListNode(TreeNode treeNode) {
                this.treeNode = treeNode;
            }
        }

        ListNode root1List = new ListNode(root1);
        ListNode root2List = new ListNode(root2);

        ListNode temp1 = root1List;
        ListNode temp2 = root2List;

        while (root2List != null) {

//            System.out.println(root2List.treeNode.val);

            if (root1List == null || root1List.treeNode == null || root1List.treeNode.val != root2List.treeNode.val) {
                return false;
            }

            TreeNode left2 = root2List.treeNode.left;
            TreeNode right2 = root2List.treeNode.right;

            TreeNode left1 = root1List.treeNode.left;
            TreeNode right1 = root1List.treeNode.right;

            if (left2 != null) {
                temp2.next = new ListNode(left2);
                temp2 = temp2.next;
                temp1.next = new ListNode(left1);
                temp1 = temp1.next;
            }

            if (right2 != null) {
                temp2.next = new ListNode(right2);
                temp2 = temp2.next;
                temp1.next = new ListNode(right1);
                temp1 = temp1.next;
            }

            root2List = root2List.next;
            root1List = root1List.next;
        }

        return true;
    }


    public static void main(String[] args) {


        TreeNode A = TreeNode.getTree(new int[]{8,8,7,9,2,0,0,0,0,4,7});
        TreeNode B = TreeNode.getTree(new int[]{8,9,2});
        TreeNode.printTreeBroad(A);
        TreeNode.printTreeBroad(B);

        System.out.println(new Solution17().HasSubtree(A, B));

    }

}
