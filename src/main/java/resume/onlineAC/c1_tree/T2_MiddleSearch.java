package resume.onlineAC.c1_tree;

import com.alibaba.fastjson.JSON;

import resume.swordoffer66.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历(递归)
 */
public class T2_MiddleSearch {

    public List<Integer> list = new ArrayList<>();

    public void middlePrint(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        middlePrint(treeNode.left);
        list.add(treeNode.val);
        middlePrint(treeNode.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTree(new int[]{1, 2, 3, 4, 5, 0, 0, 0, 0, 6, 7, 0, 0, 0, 0});
        T2_MiddleSearch t2MiddleSearch = new T2_MiddleSearch();
        t2MiddleSearch.middlePrint(treeNode);
        System.out.println(JSON.toJSONString(t2MiddleSearch.list));
    }
}
