package resume.swordoffer66.base;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2018-12-24
 */
public class TreeNode {
    public int val;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }


    /**
     * 数组形式创建二叉树,完全二叉树形式输入数组，0表示null,例如 103,创建 1-右->3
     */
    public static TreeNode getTree(int array[]) {
        try {
            TreeNode[] treeNodes = new TreeNode[array.length];
            treeNodes[0] = new TreeNode(array[0]);

            for (int i = 1; i < array.length; i++) {
                if (array[i] == 0) {
                    continue;
                }
                treeNodes[i] = new TreeNode(array[i]);

                if ((i & 0x01) == 1) {
                    treeNodes[(i - 1) / 2].left = treeNodes[i];
                } else {
                    treeNodes[(i - 1) / 2].right = treeNodes[i];
                }
            }
            return treeNodes[0];

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 深度优先输出二叉树
    public static void printTreeDeep(TreeNode root) {

    }

    // 广度优先输出二叉树
    public static void printTreeBroad(TreeNode root) {
        if (null == root) {
            return;
        }
        class ListNode {
            TreeNode treeNode;
            ListNode next = null;

            ListNode(TreeNode treeNode) {
                this.treeNode = treeNode;
            }
        }

        ListNode listNode = new ListNode(root);
        ListNode temp = listNode;
        while (listNode != null) {
            System.out.print(" " + listNode.treeNode.val);

            if (null != listNode.treeNode.left) {
                temp.next = new ListNode(listNode.treeNode.left);
                temp = temp.next;
            }

            if (null != listNode.treeNode.right) {
                temp.next = new ListNode(listNode.treeNode.right);
                temp = temp.next;
            }

            listNode = listNode.next;
        }
        System.out.println();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
