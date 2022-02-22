package resume.swordoffer66;

import java.util.ArrayList;

public class Solution33_2 {
    public int GetUglyNumber_Solution(int n) {
        if (n <= 0) return 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        int i2 = 0, i3 = 0, i5 = 0;
        while (list.size() < n)//循环的条件
        {
            // 1363 429981696
            if (list.size() == 1364) {
                System.out.println("");
            }
            int m2 = list.get(i2) * 2;
            int m3 = list.get(i3) * 3;
            int m5 = list.get(i5) * 5;
            int min = Math.min(m2, Math.min(m3, m5));
            list.add(min);
            if (min == m2) i2++;
            if (min == m3) i3++;
            if (min == m5) i5++;
        }
        return list.get(list.size() - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution33_2().GetUglyNumber_Solution(1));
        System.out.println(new Solution33_2().GetUglyNumber_Solution(2));
        System.out.println(new Solution33_2().GetUglyNumber_Solution(3));
        System.out.println(new Solution33_2().GetUglyNumber_Solution(4));
        System.out.println(new Solution33_2().GetUglyNumber_Solution(5));
        System.out.println(new Solution33_2().GetUglyNumber_Solution(1000)); // 51200000
        System.out.println(new Solution33_2().GetUglyNumber_Solution(1250)); // 233280000
        System.out.println(new Solution33_2().GetUglyNumber_Solution(1365)); // 430467210
        System.out.println(new Solution33_2().GetUglyNumber_Solution(1500)); // 859963392
    }
}