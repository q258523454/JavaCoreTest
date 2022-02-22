package resume.swordoffer66;

import java.util.ArrayList;

/**
 * Created By
 * 之字形打印二叉树
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 *
 * @author :   zhangj
 * @date :   2019-01-14
 */
public class Solution60 {

    public class LinkTree {
        int deep = 0;
        TreeNode val = null;
        LinkTree next = null;

        LinkTree(TreeNode treeNode, int deep) {
            this.val = treeNode;
            this.deep = deep;
        }
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

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

        for (int i = 0; i < arrayListArrayList.size(); i++) {
            if (i % 2 == 1) {
                ArrayList<Integer> arrayList = arrayListArrayList.get(i);
                int left = 0;
                int right = arrayList.size() - 1;
                while (left < right) {
                    int temp = arrayList.get(left);
                    arrayList.set(left, arrayList.get(right));
                    arrayList.set(right, temp);
                    left++;
                    right--;
                }
            }
        }

        return arrayListArrayList;
    }


    public static void main(String[] args) {

        resume.swordoffer66.TreeNode treeNode = resume.swordoffer66.TreeNode.getTree(new int[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println(new Solution60().Print(treeNode));


    }
}
