package resume.resume.onlineAC.a2_linkedlist;

import resume.onlineAC.a2_linkedlist.ListNode;

public class Solution_ReverseList {

    public static resume.onlineAC.a2_linkedlist.ListNode ReverseList(resume.onlineAC.a2_linkedlist.ListNode head) {
        if (null == head) {
            return head;
        }

        resume.onlineAC.a2_linkedlist.ListNode firstNode = new resume.onlineAC.a2_linkedlist.ListNode(-1);
        firstNode.next = null;

        while (head != null) {
            resume.onlineAC.a2_linkedlist.ListNode cur = head;
            // 注意下面这句代码位置
            head = head.next;
            cur.next = firstNode.next;
            firstNode.next = cur;
        }

        return firstNode.next;
    }


    public static void main(String[] args) {
        resume.onlineAC.a2_linkedlist.ListNode nodeList = new resume.onlineAC.a2_linkedlist.ListNode(1);
        resume.onlineAC.a2_linkedlist.ListNode insert = nodeList;
        for (int i = 2; i < 10; i++) {
            insert.next = new resume.onlineAC.a2_linkedlist.ListNode(i);
            insert = insert.next;
        }

        ListNode reverseList = ReverseList(nodeList);
        while (null != reverseList) {
            System.out.print(reverseList.val);
            reverseList = reverseList.next;
        }

    }
}
