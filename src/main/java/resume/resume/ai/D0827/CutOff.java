package resume.resume.ai.D0827;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class CutOff {
    static class TreeNode {
        int feature;
        int threshold;
        int label;
        TreeNode left;
        TreeNode right;
        int seq;

        public TreeNode(int feature, int threshold, int label, TreeNode left, TreeNode right) {
            this.feature = feature;
            this.threshold = threshold;
            this.label = label;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int seq) {
            this.seq = seq;
        }

        public void setFeature(int feature) {
            this.feature = feature;
        }

        public void setThreshold(int threshold) {
            this.threshold = threshold;
        }

        public void setLabel(int label) {
            this.label = label;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        public void setSeq(int seq) {
            this.seq = seq;
        }
    }

    /**
     * 题目: F1值最优的决策树剪枝
     * 决策树生成算法递归地产生决策树，直到不能继续下去为止，这样产生的树往往对训练数据的分类很准确，但对未知的测试数据的分类却没有那么准确，即出现过拟合现象。
     * 在决策树学习中将已生成的树进行简化的过程称为剪枝。具体地，剪枝从已生成的树上裁掉一些子树或叶节点，并将其根节点或父节点作为新的叶节点，从而简化分类树模型。
     */
    public static void main(String[] args) {
        List<int[]> treeLine = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int[] line = new int[5];
            for (int j = 0; j < 5; j++) {
                line[j] = sc.nextInt();
            }
            treeLine.add(line);
        }
        System.out.println();
        System.out.println(JSON.toJSONString(treeLine));
        TreeNode treeNode = initTree(treeLine);
        System.out.println("---------------");
        printTree(treeNode);
    }

    private static TreeNode initTree(List<int[]> treeLine) {
        int[] ints1 = treeLine.get(0);
        TreeNode left = null;
        if (ints1[0] != 0) {
            left = new TreeNode(ints1[0]);
        }
        TreeNode right = null;
        if (ints1[1] != 0) {
            right = new TreeNode(ints1[1]);
        }
        TreeNode root = new TreeNode(ints1[2], ints1[3], ints1[4], left, right);
        root.setSeq(1);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.left != null) {
                int[] ints = treeLine.get(poll.left.seq - 1);
                TreeNode leftChild = poll.left;
                extracted(ints, leftChild, queue);
            }
            if (poll.right != null) {
                int[] ints = treeLine.get(poll.right.seq - 1);
                TreeNode rightChild = poll.right;
                extracted(ints, rightChild, queue);
            }
        }
        return root;
    }

    private static void extracted(int[] ints, TreeNode child, Queue<TreeNode> queue) {
        TreeNode l = null;
        if (ints[0] != 0) {
            l = new TreeNode(ints[0]);
        }
        TreeNode r = null;
        if (ints[1] != 0) {
            r = new TreeNode(ints[1]);
        }
        child.setFeature(ints[2]);
        child.setThreshold(ints[3]);
        child.setLabel(ints[4]);
        child.setLeft(l);
        child.setRight(r);
        queue.add(child);
    }

    private static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            System.out.println(poll.seq + " " + poll.feature + " " + poll.threshold + " " + poll.label);
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
    }
}
