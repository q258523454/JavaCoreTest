package swordoffer66;

/**
 * Created By
 * 数组中重复的数字
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 *
 * @author :   zhangj
 * @date :   2019-01-11
 */
public class Solution52_2 {

    // 虽然有2个while, 但是算法复杂度为O(n)
    public boolean duplicate(int numbers[], int n, int[] duplication) {
        // numbers[]范围0~n-1,如果不重复,则必定有下标i=numbers[i]
        int i = 0;
        while (i < n) {
            while (i != numbers[i]) {
                // 将numbers[i]放到numbers[i]的位置
                // 1.如果numbers[i]上的值已经等于numbers[i]了,说明重复了
                if (numbers[numbers[i]] == numbers[i]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                // 2.否则交换位置
                int temp = numbers[numbers[i]];
                numbers[numbers[i]] = numbers[i];
                numbers[i] = temp;
            }
            i++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 2, 7, 3, 2, 1};
        int[] duplication = new int[1];
        System.out.println(new Solution52_2().duplicate(a, a.length, duplication));
        System.out.println(duplication[0]);

    }
}
