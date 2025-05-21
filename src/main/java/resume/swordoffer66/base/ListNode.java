package resume.swordoffer66.base;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2018-12-24
 */
public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }


    public static void printListNode(ListNode head) {
        if (head == null) {
            return;
        }
        String str = "";
        while (head != null) {
            str += head.val + " ";
            head = head.next;
        }
        System.out.println(str);
    }
}
