package resume.swordoffer66;

import java.util.Arrays;

/**
 * 题目13:【调整数组顺序使奇数位于偶数前面】
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的[奇数]`位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * @author :   zhangj
 * @date :   2018-12-19
 */

public class Solution13 {
    public void reOrderArray(int[] array) {

        int i = 0;
        // 定位第一个偶数位置
        while (i < array.length && !isEven(array[i])) {
            i++;
        }
        if (i >= array.length) {
            return;
        }

        int j = i + 1;
        while (j < array.length) {

            // 定位偶数位置之后的第一个奇数位置
            while (j < array.length && isEven(array[j])) {
                j++;
            }

            if (j >= array.length) {
                return;
            }

            // 偶数位置到该位置之后的第一个奇数位置，这一段进行奇数前置
            int k = j;
            int temp = array[j];
            while (k > i) {
                array[k] = array[k - 1];
                k--;
            }
            array[k] = temp;

            i++;
            j++;
        }
    }

    public boolean isEven(int n) {
        // return n % 2 == 0;
        return (n & 0x1) == 0;
    }

    public static void test(int[] array) {
        System.out.println(Arrays.toString(array));
        Solution13 solution13 = new Solution13();
        solution13.reOrderArray(array);
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5, 6};
        int[] a2 = {1, 1, 1};
        int[] a3 = {2, 2, 2};
        int[] a4 = {1, 1, 2, 2};
        int[] a5 = {2, 2, 1, 1};

        test(a1);
        test(a2);
        test(a3);
        test(a4);
        test(a5);
    }
}
