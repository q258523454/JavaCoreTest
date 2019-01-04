package swordoffer66;

/**
 * Created By
 * 输入两个链表，找出它们的第一个公共结点。
 * @author :   zhangj
 * @date :   2019-01-04
 */
public class Solution36 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        while (pHead1 != null) {
            ListNode temp = pHead1;
            ListNode pHead2Temp = pHead2;
            while (pHead2Temp != null) {
                if (temp.val == pHead2Temp.val) {
                    return temp;
                }
                pHead2Temp = pHead2Temp.next;
            }
            pHead1 = pHead1.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(0);
        ListNode listNode1_1 = new ListNode(1);
        ListNode listNode1_2 = new ListNode(5);
        listNode1.next = listNode1_1;
        listNode1_1.next = listNode1_2;

        ListNode listNode2 = new ListNode(2);
        ListNode listNode2_1 = new ListNode(5);
        ListNode listNode2_2 = new ListNode(3);
        listNode2.next = listNode2_1;
        listNode2_1.next = listNode2_2;

        ListNode res = new Solution36().FindFirstCommonNode(listNode1, listNode2);
        System.out.println(res.val);

    }
}
