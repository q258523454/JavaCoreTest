package resume.swordoffer66;

import java.util.Arrays;

/**
 * Created By
 * 在数组中的两个数字(题目保证输入的数组中没有的相同的数字)，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组
 * 中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * eg:1,2,3,4,5,6,7,0 ----> 7
 *
 * @author :   zhangj
 * @date :   2019-01-04
 */
public class Solution35 {

    // 全局统计变量
    public static int count = 0;

    public static int meger(int[] a, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        int i = mid;
        int j = right;
        int k = temp.length - 1;

        while (i >= left && j >= mid + 1) {
            if (a[i] > a[j]) {
                count = count + (j - mid);
                temp[k--] = a[i--];
            } else {
                temp[k--] = a[j--];
            }
        }

        while (i >= left) {
            temp[k--] = a[i--];
        }

        while (j >= mid + 1) {
            temp[k--] = a[j--];
        }

        for (int l = 0; l < temp.length; l++) {
            a[left++] = temp[l];
        }
        return count%1000000007;
    }

    public static int sort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
            meger(arr, left, mid, right);
        }
        return count%1000000007;
    }

    public int InversePairs(int[] array) {
        sort(array, 0, array.length - 1);
        return count%1000000007;
    }



    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 0};
        System.out.println(Arrays.toString(a));
        System.out.println(new Solution35().InversePairs(a));
        System.out.println(Arrays.toString(a));
    }
}
