package resume.onlineAC.c1_tree;

import com.alibaba.fastjson.JSON;

import resume.swordoffer66.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 二叉树先序遍历,非递归
 *          1
 *       2     3
 *     4   5
 *       6   7
 *     9
 * 先序遍历: [1,2,4,5,6,7,3]
 */
public class T1_FirstSearch {

    public List<Integer> list = new ArrayList<>();

    public void middlePrint(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        list.add(treeNode.val);
        middlePrint(treeNode.left);
        middlePrint(treeNode.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTree(new int[]{1, 2, 3, 4, 5, 0, 0, 0, 0, 6, 7, 0, 0, 0, 0});
        T1_FirstSearch treePrint = new T1_FirstSearch();
        treePrint.middlePrint(treeNode);
        System.out.println(JSON.toJSONString(treePrint.list));
    }
}
