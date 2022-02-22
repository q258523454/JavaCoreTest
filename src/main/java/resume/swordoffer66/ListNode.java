package resume.swordoffer66;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2018-12-24
 */
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
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
