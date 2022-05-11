package resume.swordoffer66;

import resume.swordoffer66.base.TreeNode;

import java.util.ArrayList;

/**
 * 与Solution24不同, 要求从根节点出发, 但不一定要到叶子节点
 *
 * @author :   zhangj
 * @date :   2018-12-26
 */
public class Solution24_2 {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        if (root == null) {
            return null;
        }

        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();


        FindPathSub(root, target, path, arrayLists);


        return arrayLists;
    }


    public void FindPathSub(TreeNode root, int target, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> arrayLists) {


        // 当前节点可能成为路径节点
        if (root.val <= target) {
            // 复制path,并添加该节点
            ArrayList<Integer> addPath = new ArrayList<>();
            for (int i = 0; i < path.size(); i++) {
                addPath.add(path.get(i));
            }
            addPath.add(root.val);
            TreeNode left = root.left;
            TreeNode right = root.right;
            target = target - root.val;

            // 如果和已经相等了, 直接返回该路径
            if (target == 0) {
                arrayLists.add(new ArrayList<>());
                for (int i = 0; i < addPath.size(); i++) {
                    arrayLists.get(arrayLists.size() - 1).add(addPath.get(i));
                }
                return;
            }

            if (left != null) {
                FindPathSub(left, target, addPath, arrayLists);
            }

            if (right != null) {
                FindPathSub(right, target, addPath, arrayLists);
            }
        }

        return;
    }

    public static void main(String[] args) {

        TreeNode treeNode = TreeNode.getTree(new int[]{1, 2, 3, 0, 5, 6, 7, 0, 0, 1, 2});

        TreeNode.printTreeBroad(treeNode);

        Solution24_2 solution24_2 = new Solution24_2();
        ArrayList<ArrayList<Integer>> res = solution24_2.FindPath(treeNode, 15);
        System.out.println("res =" + res);


    }

}
