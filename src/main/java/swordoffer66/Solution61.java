package swordoffer66;

import java.util.ArrayList;

/**
 * Created By
 * 二叉树打印, 每层打印一行
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 *
 * @author :   zhangj
 * @date :   2019-01-15
 */
public class Solution61 {


    public class LinkTree {
        int deep = 0;
        TreeNode val = null;
        LinkTree next = null;

        LinkTree(TreeNode treeNode, int deep) {
            this.val = treeNode;
            this.deep = deep;
        }
    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> arrayListArrayList = new ArrayList<>();

        if (pRoot == null) {
            return arrayListArrayList;
        }

        LinkTree head = new LinkTree(pRoot, 0);
        LinkTree tail = head;
        while (head != null) {
            TreeNode curTreeNode = head.val;
            int curDeep = head.deep;

            if (arrayListArrayList.size() <= curDeep) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayListArrayList.add(arrayList);
            }
            arrayListArrayList.get(curDeep).add(curTreeNode.val);

            if (curTreeNode.left != null) {
                tail.next = new LinkTree(curTreeNode.left, curDeep + 1);
                tail = tail.next;
            }
            if (curTreeNode.right != null) {
                tail.next = new LinkTree(curTreeNode.right, curDeep + 1);
                tail = tail.next;
            }
            head = head.next;
        }
        return arrayListArrayList;
    }
}
