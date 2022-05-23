package resume.onlineAC.linkedlist;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2022-05-18
 */
public class Solution_MaxSubSequenceLength {
    class BNode {
        int val;
        BNode pre = null;
        BNode next = null;

        public BNode(int val) {
            this.val = val;
        }
    }

    /**
     * 核心:双向链表
     * NC41 最长无重复子数组
     * 输入： [1,2,3,1,2,3,2,2]
     * 返回值： 3
     * 说明：最长子数组为[1,2,3]
     *
     * 输入：[2,2,3,4,8,99,3]
     * 返回值：5
     * 最长子数组为[2,3,4,8,99]
     */
    public int maxLength(int[] arr) {
        BNode firstNode = new BNode(arr[0]);
        BNode head = firstNode;
        BNode tail = firstNode;

        int max = 1;

        for (int i = 1; i < arr.length; i++) {
            BNode bNode = new BNode(arr[i]);
            tail.next = bNode;
            bNode.pre = tail;
            tail = tail.next;
            // 找出同节点位置,head重新指向
            int count = 1;
            BNode temp = bNode.pre;
            while (null != temp) {
                if (temp.val == tail.val) {
                    head = temp.next;
                    head.pre = null;
                    count = -1;
                    break;
                }
                temp = temp.pre;
                count++;
            }
            max = Math.max(max, count);
        }

        return max;
    }
}
