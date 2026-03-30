package resume.resume.ai.D0928;

import java.util.Arrays;
import java.util.Scanner;

public class DecisionTree {


    /**
     * 题目参考:
     * 注意:分裂特征的下标=样本的下标
     * 注意这里
     * <a href="https://mp.weixin.qq.com/s/d1Z62k4_nTcNaSlx-pMVLw">...</a>
     *
     * 输入1:
     * 3 9 2
     * 0 6.1 1 2 -1
     * 2 7.0 3 4 -1
     * 1 6.5 5 6 -1
     * -1 -1 -1 -1 1
     * 1 10.3 7 8 -1
     * -1 -1 -1 -1 5
     * -1 -1 -1 -1 6
     * -1 -1 -1 -1 3
     * -1 -1 -1 -1 4
     * 3.2 9.2 6.2
     * 6.3 3.2 12.0
     * 输出2:
     * 1 ---> 注意不是3？
     * 5
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] split1 = line.split(" ");
            int f = Integer.parseInt(split1[0]);
            int m = Integer.parseInt(split1[1]);
            int n = Integer.parseInt(split1[2]);

            TreeNode[] tree = new TreeNode[m];
            for (int i = 0; i < m; i++) {
                String input2 = sc.nextLine();
                String[] split2 = input2.split(" ");
                int index = Integer.parseInt(split2[0]);
                float threshold = Float.parseFloat(split2[1]);
                int leftIndex = Integer.parseInt(split2[2]);
                int rightIndex = Integer.parseInt(split2[3]);
                int classify = Integer.parseInt(split2[4]);
                TreeNode treeNode = new TreeNode(index, threshold, leftIndex, rightIndex, classify);
                tree[i] = treeNode;
            }

            for (int i = 0; i < m; i++) {
                TreeNode node = tree[i];
                int left = node.leftIndex;
                int right = node.rightIndex;
                if (left >= 0) {
                    node.left = tree[left];
                }
                if (right >= 0) {
                    node.right = tree[right];
                }
            }

            float[][] A = new float[n][f];
            String lastInput = "";
            for (int i = 0; i < n; i++) {
                String input3 = sc.nextLine();
                lastInput = input3;
                String[] split3 = input3.split(" ");
                for (int j = 0; j < split3.length; j++) {
                    A[i][j] = Float.parseFloat(split3[j]);
                }
            }
            TreeNode root = tree[0];
            calc(root, A);
        }
    }

    public static void calc(TreeNode root, float[][] A) {
        int m = A.length;
        int n = A[0].length;
        TreeNode tempNode = root;
        int[] res = new int[m];
        Arrays.fill(res, Integer.MIN_VALUE);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 叶子节点直接返回
                if (tempNode.left == null && tempNode.right == null || tempNode.index < 0) {
                    res[i] = tempNode.classify;
                    tempNode = root;
                    break;
                }
                float value = A[i][tempNode.index];
                if (value <= tempNode.threshold) {
                    if (tempNode.left == null) {
                        res[i] = tempNode.classify;
                        tempNode = root;
                        break;
                    }
                    tempNode = tempNode.left;
                } else {
                    if (tempNode.right == null) {
                        res[i] = tempNode.classify;
                        tempNode = root;
                        break;
                    }
                    tempNode = tempNode.right;
                }
            }
            // 预测向量全部执行完还没找到叶子节点
            if (res[i] == Integer.MIN_VALUE) {
                res[i] = tempNode.classify;
                tempNode = root;
            }
        }

        for (int i = 0; i < m; i++) {
            System.out.println(res[i]);
        }
    }

    public static class TreeNode {
        public int index;
        public float threshold;
        public int leftIndex;
        public int rightIndex;
        public int classify;
        public TreeNode left = null;
        public TreeNode right = null;

        public TreeNode(int index, float threshold, int leftIndex, int rightIndex, int classify) {
            this.index = index;
            this.threshold = threshold;
            this.leftIndex = leftIndex;
            this.rightIndex = rightIndex;
            this.classify = classify;
        }
    }
}
