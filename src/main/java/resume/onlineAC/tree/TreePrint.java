package resume.onlineAC.tree;

import com.alibaba.fastjson.JSON;
import resume.swordoffer66.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @author zhang
 * @date 2022-04-19 20:57
 * @modify
 */
public class TreePrint {

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
        TreeNode treeNode = TreeNode.getTree(new int[]{1, 2, 3, 4, 5, 6, 7});
        TreePrint treePrint = new TreePrint();
        treePrint.middlePrint(treeNode);
        System.out.println(JSON.toJSONString(treePrint.list));
    }
}
