import resume.swordoffer66.base.ListNode;

public class Test {


    public boolean hasCycle(ListNode head) {

        if (null == head || null == head.next) {
            return false;
        }
        if (head.next == head) {
            return true;
        }

        ListNode p = head;
        ListNode q = head.next;

        while ((null != p) && (p != q)) {
            p = p.next;
            if (null != q.next && null != q.next.next) {
                q = q.next.next;
            } else {
                return false;
            }
        }
        return p == q;
    }
}
