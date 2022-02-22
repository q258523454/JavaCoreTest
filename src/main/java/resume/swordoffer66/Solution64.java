package resume.swordoffer66;

/**
 * Created By
 * <p>
 * 数据流中的中位数
 * 奇数个数值，中位数就是所有数值排序之后位于中间的数值。
 * 偶数个数值，中位数就是所有数值排序之后中间两个数的平均值
 *
 * @author :   zhangj
 * @date :   2019-01-15
 */
public class Solution64 {


    LinkNode head = null;
    public int count = 0;

    public class LinkNode {
        Integer val = null;
        LinkNode next = null;

        LinkNode(Integer val) {
            this.val = val;
        }
    }

    public void Insert(Integer num) {
        count++;
        if (head == null) {
            head = new LinkNode(-1);
            head.next = new LinkNode(num);
            return;
        }

        LinkNode p = head;
        LinkNode q = head.next;
        while (q != null && q.val < num) {
            q = q.next;
            p = p.next;
        }
        if (q != null) {
            LinkNode temp = new LinkNode(num);
            temp.next = p.next;
            p.next = temp;
        } else {
            p.next = new LinkNode(num);
        }


    }

    public Double GetMedian() {
        if (count == 0) {
            return null;
        }
        if (count == 1) {
            return Double.valueOf(head.next.val);
        }
        if (count % 2 == 0) {
            int n = count / 2;
            LinkNode temp = head;
            while (n > 0) {
                temp = temp.next;
                n--;
            }
            return Double.valueOf((temp.val + temp.next.val) / 2.0);
        } else {
            int n = count / 2 + 1;
            LinkNode temp = head;
            while (n > 0) {
                temp = temp.next;
                n--;
            }
            return Double.valueOf(temp.val);
        }
    }


    public static void main(String[] args) {
        Solution64 solution64 = new Solution64();
        int[] input = new int[]{5, 2, 3, 4, 1, 6, 7, 0, 8};
        for (int i = 0; i < input.length; i++) {
            solution64.Insert(input[i]);
            System.out.println(solution64.GetMedian());
        }

    }
}
