package resume.onlineAC.linkedlist;

public class Solution_deleteDuplicates {


    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode shadow = new ListNode(-1);
        shadow.next = null;

        ListNode temp = head;
        ListNode cur = shadow;

        while (null != temp) {
            while (null != temp.next && temp.val == temp.next.val) {
                temp = temp.next;
            }
            cur.next = temp;
            cur = cur.next;
            temp = cur.next;
        }

        return shadow.next;
    }
}
