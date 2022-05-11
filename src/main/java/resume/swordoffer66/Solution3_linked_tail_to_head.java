package resume.swordoffer66;

import java.util.ArrayList;

/**
 * Created By
 * 从尾到头打印链表
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 *
 * @author :   zhangj
 * @date :   2019-01-18
 */
public class Solution3_linked_tail_to_head {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    ArrayList<Integer> arrayList = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>();
        }
        printListFromTailToHead(listNode.next);
        arrayList.add(listNode.val);
        return arrayList;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        Solution3_linked_tail_to_head solution3 = new Solution3_linked_tail_to_head();
        System.out.println(solution3.printListFromTailToHead(listNode1));
    }
}
