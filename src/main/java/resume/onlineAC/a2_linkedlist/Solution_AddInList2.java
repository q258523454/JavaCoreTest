package resume.onlineAC.a2_linkedlist;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2022-05-26
 */
public class Solution_AddInList2 {
    /**
     * NC40 链表相加(二)
     * 假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。
     * 给定两个这种链表，请生成代表两个整数相加值的结果链表。
     * 思路： 将链表相加转换成了数组相加.
     *
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public ListNode addInList(ListNode head1, ListNode head2) {
        int n = 0;
        ListNode temp1 = head1;
        while (temp1 != null) {
            n++;
            temp1 = temp1.next;
        }

        int m = 0;
        ListNode temp2 = head2;
        while (temp2 != null) {
            m++;
            temp2 = temp2.next;
        }
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];

        n = 0;
        temp1 = head1;
        while (temp1 != null) {
            arr1[n] = temp1.val;
            n++;
            temp1 = temp1.next;
        }

        m = 0;
        temp2 = head2;
        while (temp2 != null) {
            arr2[m] = temp2.val;
            m++;
            temp2 = temp2.next;
        }

        int[] result = null;
        if (n > m) {
            result = calcAdd(arr1, arr2);
        } else {
            result = calcAdd(arr2, arr1);
        }

        int i = 0;
        while (i < result.length && 0 == result[i]) {

            i++;
        }
        if (i == result.length) {
            return new ListNode(0);
        }

        ListNode newHead = new ListNode(result[i]);
        ListNode newTemp = newHead;
        for (int j = i + 1; j < result.length; j++) {
            newTemp.next = new ListNode(result[j]);
            newTemp = newTemp.next;
        }

        return newHead;
    }

    /**
     * 两个数组进行相加
     * @param longArr 长数组
     * @param shortArr 短数组
     */
    public int[] calcAdd(int[] longArr, int[] shortArr) {
        int[] result = new int[longArr.length + 1];

        int i = longArr.length - 1;
        int j = shortArr.length - 1;
        int k = result.length - 1;
        while (k >= 0) {
            int a = 0;
            int b = 0;
            if (i >= 0) {
                a = longArr[i];
            }
            if (j >= 0) {
                b = shortArr[j];
            }
            int cur = a + b + result[k];
            if (cur >= 10) {
                result[k - 1] = cur / 10;
                result[k] = cur % 10;
            } else {
                result[k] = cur;
            }
            i--;
            j--;
            k--;
        }
        return result;
    }
}