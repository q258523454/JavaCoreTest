package swordoffer66;

/**
 * Created By
 * <p>
 * 连续子数组的最大和,给一个数组，返回它的最大连续子序列的和
 * {6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 *
 * @author :   zhangj
 * @date :   2018-12-27
 */

public class Solution30 {

    public int FindGreatestSumOfSubArray(int[] array) {
        int max = array[0];
        int tempMax = array[0];
        for (int i = 1; i < array.length; i++) {
            // 注意是大于等于(最大子序列,如果题目要返回该子序列,这个等于"="号必须要)
            if (tempMax + array[i] >= array[i]) {
                tempMax += array[i];
            } else {
                tempMax = array[i];
            }
            if (tempMax > max) {
                max = tempMax;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{6, -3, -2, 7, -15, 1, 2, 2};
        int[] arr2 = new int[]{6};
        System.out.println(new Solution30().FindGreatestSumOfSubArray(arr2));
    }
}
