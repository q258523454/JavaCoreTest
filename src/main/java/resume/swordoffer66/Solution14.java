package resume.swordoffer66;

import resume.swordoffer66.base.ListNode;

import static resume.swordoffer66.base.ListNode.printListNode;

/**
 * Created By
 * 剑指offer 题目13:输入一个链表【不带头结点】，输出该链表中倒数第k个结点
 *
 * @author :   zhangj
 * @date :   2018-12-19
 */
public class Solution14 {


    public ListNode FindKthToTail(ListNode head, int k) {

        int totalNum = 0;
        ListNode listNode = head;
        while (listNode != null) {
            totalNum++;
            listNode = listNode.next;
        }

        int i = 1;
        int j = totalNum - k + 1;
        if (j <= 0) {
            return null;
        }

        ListNode temp = head;
        while (i < j) {
            temp = temp.next;
            i++;
        }
        return temp;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.val = 1;
        head.next = null;
        int i = 2;
        ListNode listNode = head;
        while (i <= 10) {
            ListNode temp = new ListNode(0);
            temp.val = i;
            listNode.next = temp;
            listNode = temp;
            i++;
        }
        printListNode(head);
        Solution14 solution14 = new Solution14();
        ListNode res = solution14.FindKthToTail(head, 10);
        System.out.println(res.val);

    }
}
