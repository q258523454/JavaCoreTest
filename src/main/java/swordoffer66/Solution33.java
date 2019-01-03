package swordoffer66;


import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。
 * 求按从小到大的顺序的第N个丑数。
 */
public class Solution33 {


    public int GetUglyNumber_Solution(int index) {
        if (index == 0) {
            return 0;
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        Queue<Long> queue2 = new PriorityQueue<>();
        Queue<Long> queue3 = new PriorityQueue<>();
        Queue<Long> queue5 = new PriorityQueue<>();

        arrayList.add(1L);

        while (arrayList.size() < index) {
            queue2.add(arrayList.get(arrayList.size() - 1) * 2);
            queue3.add(arrayList.get(arrayList.size() - 1) * 3);
            queue5.add(arrayList.get(arrayList.size() - 1) * 5);
            long min2 = queue2.peek();
            long min3 = queue3.peek();
            long min5 = queue5.peek();

            long min = Math.min(min2, Math.min(min3, min5));
            arrayList.add(min);

            if (min == min2) {
                queue2.remove();
            }
            if (min == min3) {
                queue3.remove();
            }
            if (min == min5) {
                queue5.remove();
            }
        }

        return new Integer(arrayList.get(arrayList.size() - 1).toString());
    }

    public static void main(String[] args) {
        System.out.println(new Solution33().GetUglyNumber_Solution(1));
        System.out.println(new Solution33().GetUglyNumber_Solution(2));
        System.out.println(new Solution33().GetUglyNumber_Solution(3));
        System.out.println(new Solution33().GetUglyNumber_Solution(4));
        System.out.println(new Solution33().GetUglyNumber_Solution(5));
        System.out.println(new Solution33().GetUglyNumber_Solution(1000)); // 51200000
        System.out.println(new Solution33().GetUglyNumber_Solution(1250)); // 233280000
        System.out.println(new Solution33().GetUglyNumber_Solution(1364)); // 429981696
        System.out.println(new Solution33().GetUglyNumber_Solution(1365)); // 430467210
        System.out.println(new Solution33().GetUglyNumber_Solution(1500)); // 859963392
    }
}
