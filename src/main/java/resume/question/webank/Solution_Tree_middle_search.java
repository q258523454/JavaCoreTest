package resume.question.webank;

import resume.swordoffer66.base.TreeNode;

import java.util.ArrayList;

/**
 * Created By
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * @author :   zhangj
 * @date :   2018-12-25
 */
public class Solution_Tree_middle_search {

    static class ListTreeNode {
        TreeNode treeNode;
        ListTreeNode next = null;

        ListTreeNode(TreeNode treeNode) {
            this.treeNode = treeNode;
        }
    }

    // BFS-广度优先遍历
    public ArrayList<Integer> levelOrder(TreeNode root) {

        ArrayList<Integer> arrayList = new ArrayList<>();


        if (null == root) {
            return arrayList;
        }

        ListTreeNode listTreeNode = new ListTreeNode(root);
        ListTreeNode temp = listTreeNode;

        while (listTreeNode != null) {

            arrayList.add(listTreeNode.treeNode.val);

            TreeNode left = listTreeNode.treeNode.left;
            TreeNode right = listTreeNode.treeNode.right;
            if (left != null) {
                temp.next = new ListTreeNode(left);
                temp = temp.next;
            }
            if (right != null) {
                temp.next = new ListTreeNode(right);
                temp = temp.next;
            }

            listTreeNode = listTreeNode.next;
        }

        return arrayList;
    }

    public static void main(String[] args) {
        Solution_Tree_middle_search solution22TreeBFS = new Solution_Tree_middle_search();

        TreeNode treeNode = TreeNode.getTree(new int[]{1, 2, 3, 0, 5, 6, 7, 0, 0, 1, 2});
//        TreeNode.printTreeBroad(treeNode);

//        ArrayList arrayList = solution22.PrintFromTopToBottom(treeNode);
//        System.out.println(arrayList.toString());

        System.out.println(solution22TreeBFS.levelOrder(null).toString());


    }
}
