package resume.swordoffer66;

/**
 * Created By
 * 输入两个链表，找出它们的第一个公共结点。
 *
 * @author :   zhangj
 * @date :   2019-01-04
 */
public class Solution36_2 {

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

        ListNode temp = pHead1;
        int l1 = 0;
        while (temp != null) {
            l1++;
            temp = temp.next;
        }

        temp = pHead2;
        int l2 = 0;
        while (temp != null) {
            l2++;
            temp = temp.next;
        }

        if (l1 > l2) {
            int diff = l1 - l2;
            while (diff > 0) {
                pHead1 = pHead1.next;
                diff--;
            }
        } else {
            int diff = l2 - l1;
            while (diff > 0) {
                pHead2 = pHead2.next;
                diff--;
            }
        }

        while (pHead1.val != pHead2.val) {
            if (pHead1.next == null) {
                return null;
            }
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }

        return pHead1;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(0);
        ListNode listNode1_1 = new ListNode(1);
        ListNode listNode1_2 = new ListNode(2);
        ListNode listNode1_3 = new ListNode(3);
        listNode1.next = listNode1_1;
        listNode1_1.next = listNode1_2;
        listNode1_2.next = listNode1_3;

        ListNode listNode2 = new ListNode(1);
        ListNode listNode2_1 = new ListNode(2);
        ListNode listNode2_2 = new ListNode(3);
        listNode2.next = listNode2_1;
        listNode2_1.next = listNode2_2;

        ListNode res = new Solution36_2().FindFirstCommonNode(listNode1, listNode2);
        System.out.println(res.val);
    }
}
