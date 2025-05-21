package resume.swordoffer66;


/**
 * Created By
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 *
 * @author :   zhangj
 * @date :   2018-12-27
 */


import java.util.ArrayList;
import java.util.Arrays;

public class Solution29_Least_K_Numbers {


    // 快排核心算法
    public int parition(int[] arr, int start, int end) {
        int key = arr[start];
        while (start < end) {
            while (end > start && arr[end] >= key) {
                end--;
            }
            arr[start] = arr[end];

            while (start < end && arr[start] <= key) {
                start++;
            }
            arr[end] = arr[start];
        }
        arr[start] = key;
        return start;
    }

    public void quickSort(int[] arr, int start, int end, int k) {
        if (end - start <= 0 || end > arr.length || start < 0) {
            return;
        }
        int mid = parition(arr, start, end);
        if (mid + 1 == k) {
            return;
        }
        if (mid + 1 > k) {
            quickSort(arr, start, mid, k);
        }
        if (mid + 1 < k) {
            quickSort(arr, mid + 1, end, k);
        }
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        if (input.length <= 1 || k <= 0 || k > input.length) {
            return arrayList;
        }

        if (k == input.length) {
            for (int i = 0; i < k; i++) {
                arrayList.add(input[i]);
            }
            return arrayList;
        }

        quickSort(input, 0, input.length - 1, k);

        for (int i = 0; i < k; i++) {
            arrayList.add(input[i]);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        int[] a = new int[]{4, 5, 1, 6, 2, 7, 2, 8};
        System.out.println(Arrays.toString(a));
        ArrayList<Integer> arrayList = new Solution29_Least_K_Numbers().GetLeastNumbers_Solution(a, 2);
        System.out.println(Arrays.toString(a));
        System.out.println(arrayList);

    }

}
