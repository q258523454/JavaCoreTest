package resume.swordoffer66;

import java.util.Arrays;

/**
 * Created By
 * 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * @author :   zhangj
 * @date :   2019-01-15
 */
public class Solution62 {

    class LinkTree {
        TreeNode val = null;
        LinkTree next = null;

        LinkTree(TreeNode treeNode) {
            this.val = treeNode;
        }

    }

    // 例如:"tree,1,2,3,#,5"
    String Serialize(TreeNode root) {
        String str = "tree";
        LinkTree head = new LinkTree(root);
        LinkTree tail = head;
        // 层次遍历
        while (head != null) {
            TreeNode curTreeNode = head.val;

            if (curTreeNode == null) {
                str += "," + "#";

                LinkTree temp = head;
                while (temp != null && temp.val == null) {
                    temp = temp.next;
                }
                // 后面全是null节点,不在添加到链表
                if (temp == null) {
                    //TODO do nothing
                } else {
                    // 为null节点,但是后面还有不为null的节点,继续添加左右节点,补充二叉树
                    tail.next = new LinkTree(null);
                    tail = tail.next;
                    tail.next = new LinkTree(null);
                    tail = tail.next;
                }
                head = head.next;
                continue;
            }

            String add = "," + curTreeNode.val;
            str += add;
            if (curTreeNode.left != null) {
                tail.next = new LinkTree(curTreeNode.left);
                tail = tail.next;
            }
            if (curTreeNode.left == null) {
                tail.next = new LinkTree(null);
                tail = tail.next;
            }

            if (curTreeNode.right != null) {
                tail.next = new LinkTree(curTreeNode.right);
                tail = tail.next;
            }

            if (curTreeNode.right == null) {
                tail.next = new LinkTree(null);
                tail = tail.next;
            }

            head = head.next;
        }

        return str;
    }

    TreeNode Deserialize(String str) {
        String[] input = str.split(",");
        TreeNode[] treeNodes = new TreeNode[input.length ];

        for (int i = 1; i < input.length; i++) {
            if (!input[i].equals("#")) {
                treeNodes[i] = new TreeNode(Integer.valueOf(input[i]));
            } else {
                treeNodes[i] = null;
            }
        }

        // "tree,1,2,3,#,5", 下标为0不参与, index从1开始
        for (int i = 0; i <= treeNodes.length / 2; i++) {
            if (treeNodes[i] == null) {
                continue;
            }
            if (treeNodes[2 * i] != null) {
                treeNodes[i].left = treeNodes[2 * i];
            }
            if (treeNodes[2 * i + 1] != null) {
                treeNodes[i].right = treeNodes[2 * i + 1];
            }
        }
        return treeNodes[1];
    }

    public static void main(String[] args) {
        String str = "tree,1,2,3,#";
        System.out.println(Arrays.toString(str.split(",")));
        TreeNode A = TreeNode.getTree(new int[]{1, 2, 3, 0, 5, 7, 0});
        TreeNode.printTreeBroad(A);
        String s = new Solution62().Serialize(A);
        System.out.println(s);
        TreeNode res = new Solution62().Deserialize(s);
        TreeNode.printTreeBroad(res);
    }
}
