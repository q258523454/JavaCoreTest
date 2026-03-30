package resume.resume.onlineAC.a2_linkedlist;

import resume.onlineAC.a2_linkedlist.ListNode;

public class Solution_ReverseList_K {

    public resume.onlineAC.a2_linkedlist.ListNode reverseKGroup(resume.onlineAC.a2_linkedlist.ListNode head, int k) {
        resume.onlineAC.a2_linkedlist.ListNode temp = new resume.onlineAC.a2_linkedlist.ListNode(-1);
        resume.onlineAC.a2_linkedlist.ListNode h = temp;
        resume.onlineAC.a2_linkedlist.ListNode tail = h;

        int i = 0;

        resume.onlineAC.a2_linkedlist.ListNode kNode = nextK(head, k);
        while (null != head && null != kNode) {
            if (i == k) {
                h = tail;
                i = 0;
                kNode = nextK(head, k);
            }

            resume.onlineAC.a2_linkedlist.ListNode cur = head;
            head = head.next;
            cur.next = h.next;
            h.next = cur;
            if (i == 0) {
                // 尾指针
                tail = h.next;
            }
            i++;
        }

        if (null == kNode) {
            tail.next = head;
        }
        return temp.next;
    }

    public resume.onlineAC.a2_linkedlist.ListNode nextK(resume.onlineAC.a2_linkedlist.ListNode head, int k) {
        if (null == head) {
            return null;
        }
        ListNode temp = head;
        int i = 0;
        while (null != temp) {
            i++;
            if (i == k) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
