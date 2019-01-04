package swordoffer66;

/**
 * Created By
 * 统计一个数字在排序数组中出现的次数。
 *
 * @author :   zhangj
 * @date :   2019-01-04
 */
public class Solution37_2 {

    // 二分查找第一个k的index,不存在返回-1
    public int getFirstIndexOfK(int[] array, int start, int end, int k) {
        if (start > end) {
            return -1;
        }
        int mid = (end + start) / 2;
        if (array[mid] == k) {
            if (mid == 0) {
                // 已经是第一个数了
                return mid;
            } else if (mid - 1 >= 0 && array[mid - 1] != k) {
                // 判断mid的前一个数是不是k,不是k表明当前mid就是第一个k的下标
                return mid;
            } else {
                // 前一个数还是k,继续查找第一个k
                return getFirstIndexOfK(array, start, mid - 1, k);
            }
        }
        if (array[mid] > k) {
            return getFirstIndexOfK(array, start, mid - 1, k);
        } else {
            return getFirstIndexOfK(array, mid + 1, end, k);
        }
    }

    // 二分查找最后一个k的index,不存在返回-1
    public int getLastIndexOfK(int[] array, int start, int end, int k) {
        if (start > end) {
            return -2;
        }
        int mid = (end + start) / 2;
        if (array[mid] == k) {
            if (mid == end) {
                // 已经是最后一个数了
                return mid;
            } else if (mid + 1 < end && array[mid + 1] != k) {
                // 判断mid的后一个数是不是k,不是k表明当前mid就是最后一个k的下标
                return mid;
            } else {
                // 后一个数还是k,继续查找最后一个k
                return getLastIndexOfK(array, mid + 1, end, k);
            }
        }
        if (array[mid] > k) {
            return getLastIndexOfK(array, start, mid - 1, k);
        } else {
            return getLastIndexOfK(array, mid + 1, end, k);
        }
    }

    public int GetNumberOfK(int[] array, int k) {
        int firstIndexOfK = getFirstIndexOfK(array, 0, array.length - 1, k);
        int lastIndexOfK = getLastIndexOfK(array, 0, array.length - 1, k);
        return (lastIndexOfK - firstIndexOfK) + 1;
    }


    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(new Solution37_2().GetNumberOfK(a, 7));

    }
}
