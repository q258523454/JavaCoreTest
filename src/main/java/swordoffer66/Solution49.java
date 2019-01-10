package swordoffer66;

/**
 * Created By
 * 孩子们的游戏:小朋友围圈报数,报数后离开圈圈,直到最后剩下一个小朋友
 *
 * @author :   zhangj
 * @date :   2019-01-10
 */
public class Solution49 {

    class Link {
        int val;
        Link next = null;

        Link(int val) {
            this.val = val;
        }
    }

    public int LastRemaining_Solution(int n, int m) {
        if (n == 0 || m == 0) {
            return -1;
        }
        if (m == 1) {
            return n - 1;
        }
        // 带头结点的循环链表
        Link head = new Link(-1);
        Link temp = head;
        for (int i = 0; i < n; i++) {
            Link node = new Link(i);
            temp.next = node;
            temp = temp.next;
        }
        temp.next = head.next;

        Link preLink = head;
        Link link = head.next; // 开始报数

        // 直到只有1个节点(小朋友)
        while (link.next != link) {
            int step = m - 1;
            while (step > 0) {
                preLink = preLink.next;
                link = link.next;
                step--;
            }
            System.out.println("del:" + link.val);
            preLink.next = link.next;
            link = link.next;
        }
        return link.val;
    }

    public static void main(String[] args) {
        System.out.println(new Solution49().LastRemaining_Solution(5, 3));

    }
}
