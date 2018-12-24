package swordoffer66;

/**
 * Created By
 * 输入一个链表[不带头结点]，反转链表后，输出新链表的表头。
 *
 * @author :   zhangj
 * @date :   2018-12-21
 */
public class Solution15 {

    public static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
        }
    }

    public ListNode ReverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode revListNode = new ListNode(0);
        revListNode.next = null;

        while (head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = revListNode.next;
            revListNode.next = temp;
        }

        return revListNode.next;
    }


    public static void printListNode(ListNode head) {
        if (head == null) {
            return;
        }
        String str = "";
        while (head != null) {
            str += head.data + " ";
            head = head.next;
        }
        System.out.println(str);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.data = 1;
        head.next = null;
        int i = 2;
        ListNode listNode = head;
        while (i <= 10) {
            ListNode temp = new ListNode(0);
            temp.data = i;
            listNode.next = temp;
            listNode = temp;
            i++;
        }
        printListNode(head);

        Solution15 solution15 = new Solution15();
        ListNode res = solution15.ReverseList(head);
        printListNode(res);
    }


}
