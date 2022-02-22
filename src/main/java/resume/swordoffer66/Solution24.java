package resume.swordoffer66;

import java.util.ArrayList;

/**
 * Created By
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条
 * 路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 *
 * @author :   zhangj
 * @date :   2018-12-26
 */
public class Solution24 {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        if (root == null) {
            return new ArrayList<>();
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

            // 如果和已经相等了, 判断该节点是不是叶子节点, 如果是则添加path到全局变量arrayLists
            if (target == 0) {
                if (left == null && right == null) {
                    arrayLists.add(new ArrayList<>());
                    for (int i = 0; i < addPath.size(); i++) {
                        arrayLists.get(arrayLists.size() - 1).add(addPath.get(i));
                    }
                    return;
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
//        TreeNode treeNode = TreeNode.getTree(new int[]{10,5,12,4,7});

        TreeNode.printTreeBroad(treeNode);

        Solution24 solution24 = new Solution24();
        ArrayList<ArrayList<Integer>> res = solution24.FindPath(treeNode, 10);
        System.out.println("res =" + res);


//        ArrayList arrayList = new ArrayList();
//        arrayList.add(1);
//
//        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
//        arrayLists.add(new ArrayList<>());
//        arrayLists.add(new ArrayList<>());
//        arrayLists.get(0).add(1);
//        arrayLists.get(1).add(2);
//        System.out.println(arrayLists);
    }

}
