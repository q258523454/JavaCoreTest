package resume.onlineAC.a2_linkedlist;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2022-05-10
 */
public class Solution_hasCycle {

    /**
     * 判断给定的链表中是否有环
     * 核心: 快慢指针
     */
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
