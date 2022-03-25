package resume.swordoffer66.base;

import java.util.Arrays;

/**
 * Created By
 *
 * @date :   2018-09-27
 */
public class QuickSort {

    public int partition(int arr[], int start, int end) {
        int key = arr[start];
        while (start < end) {
            // 右边第一个比cur小
            while (arr[end] >= key && start < end) {
                end--;
            }
            arr[start] = arr[end];
            // 左边第一个比cur大
            while (arr[start] <= key && start < end) {
                start++;
            }
            arr[end] = arr[start];
        }
        arr[end] = key;
        return end;
    }

    public void quickSort(int arr[], int start, int end) {
        if (end - start <= 0 || end > arr.length || start < 0) {
            return;
        }
        int pos = partition(arr, start, end);
        quickSort(arr, start, pos);
        quickSort(arr, pos + 1, end);
    }

    public static void main(String[] args) {
        int a[] = {3, 2, 1, 1, 1, 1, 2, 3, 7, 6, 5, 4, 1, 2};
        QuickSort test = new QuickSort();
        test.quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));

    }

}
