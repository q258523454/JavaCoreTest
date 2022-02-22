package resume.swordoffer66;

import static resume.swordoffer66.ListNode.printListNode;

/**
 * Created By
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * @author :   zhangj
 * @date :   2018-12-24
 */

public class Solution16 {


    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode mList = new ListNode(0);
        mList.next = null;

        ListNode p = mList;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                p.next = list1;
                p = p.next;
                list1 = list1.next;
            } else {
                p.next = list2;
                p = p.next;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            p.next = list1;
        }
        if (list2 != null) {
            p.next = list2;
        }

        return mList.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = null;

        ListNode l2 = new ListNode(2);
        l2.next = null;

        int i = 3;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        while (i <= 10) {
            if ((i & 0x01) == 1) {
                ListNode temp = new ListNode(0);
                temp.val = i;
                temp1.next = temp;
                temp1 = temp1.next;
            } else {
                ListNode temp = new ListNode(0);
                temp.val = i;
                temp2.next = temp;
                temp2 = temp2.next;
            }
            i++;
        }
        printListNode(l1);
        printListNode(l2);

        Solution16 solution16 = new Solution16();
        ListNode listNode = solution16.Merge(l1, l2);
        printListNode(listNode);

    }


}
