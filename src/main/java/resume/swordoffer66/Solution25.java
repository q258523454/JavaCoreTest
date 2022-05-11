package resume.swordoffer66;

import resume.swordoffer66.base.RandomListNode;

/**
 * Created By
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * @author :   zhangj
 * @date :   2018-12-26
 */


public class Solution25 {

//    public class RandomListNode {
//        int label;
//        RandomListNode next = null;
//        RandomListNode random = null;
//
//        RandomListNode(int label) {
//            this.label = label;
//        }
//    }

    public RandomListNode Clone(RandomListNode pHead) {

        RandomListNode newHead = new RandomListNode(-1);
        RandomListNode temp = newHead;

        RandomListNode p = pHead;

        if (pHead == null) {
            return pHead;
        }

        while (p != null) {
            temp.label = p.label;
            p = p.next;
            if (p != null) {
                RandomListNode randomListNode = new RandomListNode(-1);
                temp.next = randomListNode;
                temp = temp.next;
            }
        }


        RandomListNode p1 = pHead;
        RandomListNode p2 = newHead;
        RandomListNode p3;
        RandomListNode p4;

        while (p1 != null) {

            RandomListNode random = p1.random;
            p3 = pHead;
            p4 = newHead;
            while (p3 != null && !p3.equals(random)) {
                p3 = p3.next;
                p4 = p4.next;
            }
            p2.random = p4;

            p1 = p1.next;
            p2 = p2.next;
        }

        return newHead;
    }

    public static void main(String[] args) {
        RandomListNode randomListNode1 = new RandomListNode(1);
        RandomListNode randomListNode2 = new RandomListNode(2);
        RandomListNode randomListNode3 = new RandomListNode(3);
        RandomListNode randomListNode4 = new RandomListNode(4);

        randomListNode1.next = randomListNode2;
        randomListNode2.next = randomListNode3;
        randomListNode3.next = randomListNode4;

        randomListNode1.random = randomListNode3;
        randomListNode2.random = randomListNode1;
        randomListNode3.random = randomListNode1;
        randomListNode4.random = randomListNode4;

        RandomListNode head = randomListNode1;
        while (head != null) {
            System.out.print(head.label + "|" + head.random.label);
            head = head.next;
            System.out.println();
        }

        System.out.println();

        RandomListNode pHead = randomListNode1;
        Solution25 solution25 = new Solution25();
        RandomListNode node = solution25.Clone(pHead);
        while (node != null) {
            System.out.print(node.label + "|" + node.random.label);
            node = node.next;
            System.out.println();
        }
    }
}

