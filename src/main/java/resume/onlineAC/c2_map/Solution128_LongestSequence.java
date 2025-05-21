

package resume.onlineAC.c2_map;

import java.util.HashMap;
import java.util.Map;

/**
 * 128.
 * 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *
 * 验证 1:
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1,0,3,7,2,5,8,4,6,0,1,10,11,12,13,14,15,16,17,17,18,19,20]
 * 输出：11
 */
public class Solution128_LongestSequence {
    public static int longestConsecutiveSequence(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        // 记录最大值
        int max = Integer.MIN_VALUE;
        // 记录最小值
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (max < num) {
                max = num;
            }
            if (min > num) {
                min = num;
            }
            map.put(num, 1);
        }


        int maxLen = 1;
        for (int i = min; i <= max; i++) {
            Integer key = map.get(i);
            Integer keyLeft = map.get(i - 1);

            if (null == keyLeft) {
                continue;
            }

            if (null != key) {
                int curLen = keyLeft + 1;
                map.put(i, curLen);
                if (curLen > maxLen) {
                    maxLen = curLen;
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1, 0, 3, 7, 2, 5, 8, 4, 6, 0, 1, 10, 11, 12, 13, 14, 15, 16, 17, 17, 18, 19, 20};
        System.out.println(longestConsecutiveSequence(nums));
    }
}
