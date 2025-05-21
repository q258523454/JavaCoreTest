package resume.onlineAC.a2_linkedlist;

public class Solution_SubMaxArry {

    /**
     * NC19 连续子数组的最大和
     * [1,-2,3,10,-4,7,2,-5]
     * 返回值：
     * 18
     * 说明：
     * 经分析可知，输入数组的子数组[3,10,-4,7,2]可以求得最大和为18
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        int max = array[0];
        int leftMax = array[0];
        for (int i = 1; i < array.length; i++) {
            int cur = array[i];
            leftMax = leftMax + cur;
            // 注意:当前值可能就是最大值
            leftMax = (Math.max(leftMax, cur));
            max = (Math.max(leftMax, max));
        }
        return max;
    }
}
