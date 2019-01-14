package swordoffer66;

/**
 * Created By
 * 链表中的环的入口结点
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * @author :   zhangj
 * @date :   2019-01-14
 */
public class Solution57 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode isCircleListNode(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode p = head;
        ListNode q = head.next;

        while (p != q && q != null) {
            p = p.next;
            q = q.next;
            if (q != null) {
                q = q.next;
            }
        }

        if (q == null) {
            return null;
        }

        if (p == q) {
            return p;
        }
        return null;
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {

        ListNode listNode = isCircleListNode(pHead);
        if (null == listNode) {
            return null;
        }

        ListNode temp = listNode.next;

        int count = 1;
        while (temp != listNode) {
            temp = temp.next;
            count++;
        }

        ListNode head = pHead;
        while (count > 0) {
            head = head.next;
            count--;
        }

        while (pHead != head) {
            pHead = pHead.next;
            head = head.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode2;

        ListNode listNode = new Solution57().EntryNodeOfLoop(listNode1);
        if (listNode != null) {
            System.out.println(listNode.val);
        } else {
            System.out.println("null");
        }
    }
}
