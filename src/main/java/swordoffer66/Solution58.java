package swordoffer66;

/**
 * Created By
 * 二叉树的下一个结点
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * @author :   zhangj
 * @date :   2019-01-14
 */
public class Solution58 {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }


    public TreeLinkNode midSearch(TreeLinkNode root) {
        return null;
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {

        if (pNode.right == null) {
            TreeLinkNode father = pNode.next;
            if (father == null) {
                return null;
            }
            if (father.left == pNode) {
                return father;
            }

            if (father.right == pNode) {
                TreeLinkNode p = father;
                TreeLinkNode q = p.next;
                while (q != null && q.right == p) {
                    p = q;
                    q = q.next;
                }
                if (q == null) {
                    return null;
                }
                if (q.left == p) {
                    return q;
                }
            }
        }

        TreeLinkNode temp = pNode.right;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }

    public static void main(String[] args) {

    }
}
