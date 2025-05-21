package resume.onlineAC.a2_linkedlist;

public class Solution_ReverseList_K {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = new ListNode(-1);
        ListNode h = temp;
        ListNode tail = h;

        int i = 0;

        ListNode kNode = nextK(head, k);
        while (null != head && null != kNode) {
            if (i == k) {
                h = tail;
                i = 0;
                kNode = nextK(head, k);
            }

            ListNode cur = head;
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

    public ListNode nextK(ListNode head, int k) {
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
