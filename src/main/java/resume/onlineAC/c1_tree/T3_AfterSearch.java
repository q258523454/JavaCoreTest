package resume.onlineAC.c1_tree;

import com.alibaba.fastjson.JSON;

import resume.swordoffer66.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 后序遍历(递归)
 *          1
 *       2     3
 *     4   5
 *       6   7
 *     9
 * 后续遍历: 4,9,6,7,5,2,3,1
 */
public class T3_AfterSearch {

    public List<Integer> list = new ArrayList<>();

    public void middlePrint(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        middlePrint(treeNode.left);
        middlePrint(treeNode.right);
        list.add(treeNode.val);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTree(new int[]{1, 2, 3, 4, 5, 0, 0, 0, 0, 6, 7, 0, 0, 0, 0});
        T3_AfterSearch treeMiddlePrint = new T3_AfterSearch();
        treeMiddlePrint.middlePrint(treeNode);
        System.out.println(JSON.toJSONString(treeMiddlePrint.list));
    }
}
