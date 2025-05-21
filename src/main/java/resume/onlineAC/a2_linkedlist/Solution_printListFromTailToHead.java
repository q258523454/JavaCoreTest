package resume.onlineAC.a2_linkedlist;

import java.util.ArrayList;

public class Solution_printListFromTailToHead {

    /**
     *    public class ListNode {
     *        int val;
     *        ListNode next = null;
     *
     *        ListNode(int val) {
     *            this.val = val;
     *        }
     *    }
     *
     */

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();

        if (null == listNode) {
            return list;
        }

        if (null == listNode.next) {
            list.add(listNode.val);
            return list;
        }

        ListNode head = new ListNode(-1);
        head.next = null;
        while (null != listNode) {
            ListNode temp = listNode;
            listNode = listNode.next;
            temp.next = head.next;
            head.next = temp;
        }

        ListNode node = head;
        while (null != node.next) {
            list.add(node.next.val);
            node = node.next;
        }

        return list;
    }


    public static void main(String[] args) {

        ListNode nodeList = new ListNode(1);
        ListNode insert = nodeList;
        for (int i = 2; i < 10; i++) {
            insert.next = new ListNode(i);
            insert = insert.next;
        }

        ListNode print = nodeList;
        while (null != print) {
            System.out.println(print.val);
            print = print.next;
        }

        System.out.println(printListFromTailToHead(nodeList));
    }


}
