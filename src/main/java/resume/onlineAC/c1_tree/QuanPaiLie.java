package resume.onlineAC.c1_tree;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class QuanPaiLie {
    /**
     * 多叉树
     */
    static class TreeNode {
        public int val;
        public TreeNode parent;
        public List<TreeNode> sonList;

        public TreeNode() {
        }
    }


    /**
     * 全排列(多叉树解决)
     * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
     * 例如输入字符串1234,则打印出由字符1,2,3,4所能排列出来的所有字符串
     * ["1234","1243","1324","1342","1423","1432","2134","2143","2314","2341","2413","2431","3124","3142","3214","3241","3412","3421","4123","4132","4213","4231","4312","4321"]
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }

        List<String> all = new ArrayList<>();
        // 每个数字作为一个树节点的root
        for (Integer num : numList) {
            TreeNode treeNode = new TreeNode();
            treeNode.val = num;
            new QuanPaiLie().buildSonNode(treeNode, numList);
            List<String> resultList = getResultList(treeNode);
            all.addAll(resultList);
        }
        System.out.println(JSON.toJSONString(all));
    }


    /**
     * 全排列构造 TreeNode
     *
     * @param root    root
     * @param numList 全排列的数组
     */
    public void buildSonNode(TreeNode root, List<Integer> numList) {

        if (null == root) {
            return;
        }

        List<Integer> tempNumList = new ArrayList<>();
        tempNumList.addAll(numList);

        List<Integer> parentAndCurNodeList = new ArrayList<>();
        parentAndCurNodeList.add(root.val);
        TreeNode temp = root;
        while (null != temp.parent) {
            temp = temp.parent;
            parentAndCurNodeList.add(temp.val);
        }
        tempNumList.removeAll(parentAndCurNodeList);

        List<TreeNode> leftNodeList = new ArrayList<>();
        for (Integer integer : tempNumList) {
            TreeNode treeNode = new TreeNode();
            treeNode.val = integer;
            treeNode.parent = root;
            leftNodeList.add(treeNode);
        }

        root.sonList = leftNodeList;

        for (TreeNode treeNode : root.sonList) {
            buildSonNode(treeNode, numList);
        }
    }

    /**
     * 打印多叉树, 这里需要从叶节点开始打印
     */
    public static List<String> getResultList(TreeNode root) {
        List<String> resultList = new ArrayList<>();
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        while (!treeNodeQueue.isEmpty()) {
            TreeNode poll = treeNodeQueue.poll();
            if (null != poll.sonList && !poll.sonList.isEmpty()) {
                treeNodeQueue.addAll(poll.sonList);
            } else {
                // 叶子节点
                TreeNode temp = poll;
                StringBuilder stringBuilder = new StringBuilder(temp.val + "");
                while (null != temp.parent) {
                    temp = temp.parent;
                    stringBuilder.append(temp.val);
                }
                // 这里也可以不用翻转
                String str = reverseStr(stringBuilder.toString());
                resultList.add(str);
            }
        }

        return resultList;
    }

    /**
     * 翻转字符串
     */
    public static String reverseStr(String str) {
        if (null == str || str.isEmpty()) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = str.length() - 1; i >= 0; i--) {
            stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }
}