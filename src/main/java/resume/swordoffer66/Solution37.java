package resume.swordoffer66;

/**
 * Created By
 * 统计一个数字在排序数组中出现的次数。
 * @author :   zhangj
 * @date :   2019-01-04
 */
public class Solution37 {

    // 二分查找k的index,不存在返回-1
    public int getIndexOfK(int[] array, int start, int end, int k) {
        if (start > end) {
            return -1;
        }
        int mid = (end + start) / 2;
        if (array[mid] == k) {
            return mid;
        }
        if (array[mid] > k) {
            return getIndexOfK(array, start, mid - 1, k);
        } else {
            return getIndexOfK(array, mid + 1, end, k);
        }
    }

    public int GetNumberOfK(int[] array, int k) {
        int indexOfK = getIndexOfK(array, 0, array.length - 1, k);
        if (indexOfK == -1) {
            // 没有k值
            return 0;
        }
        int count = 1;
        int i = indexOfK - 1;
        int j = indexOfK + 1;
        while (i >= 0 && array[i] == k) {
            i--;
            count++;
        }
        while (j < array.length && array[j] == k) {
            j++;
            count++;
        }

        return count;
    }


    public static void main(String[] args) {
        int[] a = new int[]{3, 3, 3, 3, 4, 5};
        System.out.println(new Solution37().GetNumberOfK(a, 3));

    }
}
