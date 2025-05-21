package resume.onlineAC.a2_linkedlist;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2022-05-23
 */
public class Solution_RemoveLastKNode {
    /**
     * 描述
     * 给定一个链表，删除链表的倒数第 n 个节点并返回链表的头指针
     * 例如，
     * 给出的链表为: 1\to 2\to 3\to 4\to 51→2→3→4→5, n= 2n=2.
     * 删除了链表的倒数第 n 个节点之后,链表变为1\to 2\to 3\to 51→2→3→5.
     *
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int m = n + 1;
        int count = 1;
        ListNode fast = head;
        while (null != fast && count < m) {
            fast = fast.next;
            count++;
        }
        if (null == fast ) {
            // 刚好删除第一个节点
            if (count == m) {
                return head.next;

            } else {
                return null;
            }
        }
        ListNode temp = head;
        while (null != fast.next) {
            temp = temp.next;
            fast = fast.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}
