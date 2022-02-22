package resume.swordoffer66.linkedlist;

public class SolutionJZ24_ReverseList {

    public static ListNode ReverseList(ListNode head) {
        if (null == head) {
            return head;
        }

        ListNode firstNode = new ListNode(-1);
        firstNode.next = null;

        while (head != null) {
            ListNode cur = head;
            // 注意下面这句代码位置
            head = head.next;
            cur.next = firstNode.next;
            firstNode.next = cur;
        }

        return firstNode.next;
    }


    public static void main(String[] args) {
        ListNode nodeList = new ListNode(1);
        ListNode insert = nodeList;
        for (int i = 2; i < 10; i++) {
            insert.next = new ListNode(i);
            insert = insert.next;
        }

        ListNode reverseList = ReverseList(nodeList);
        while (null != reverseList) {
            System.out.print(reverseList.val);
            reverseList = reverseList.next;
        }

    }
}
