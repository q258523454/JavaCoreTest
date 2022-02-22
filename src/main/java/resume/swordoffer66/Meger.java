package resume.swordoffer66;

import java.util.Arrays;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-04
 */
public class Meger {


    public static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
            meger(arr, left, mid, right);
        }
    }


    /***
     *
     * @param a 排序数组
     * @param left left-mid     左边
     * @param mid  mid-right    右边
     * @param right
     * @param temp 临时数组
     * @return
     */
    public static void meger(int[] a, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i < mid + 1 && j < right + 1) {
            if (a[i] > a[j]) {
                temp[k++] = a[j++];
            } else {
                temp[k++] = a[i++];
            }
        }

        while (i < mid + 1) {
            temp[k++] = a[i++];
        }

        while (j < right + 1) {
            temp[k++] = a[j++];
        }

        for (int l = 0; l < temp.length; l++) {
            a[left++] = temp[l];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 2, 4};
        System.out.println(Arrays.toString(a));
        new Meger().sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
