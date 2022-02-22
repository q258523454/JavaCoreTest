package resume.swordoffer66;

import java.util.Arrays;

/**
 * Created By
 * 扑克牌顺子, JQK为11,12,13,大小王为0,可以变任何数字
 * @author :   zhangj
 * @date :   2019-01-10
 */
public class Solution48 {

    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length <= 1) {
            return false;
        }
        new QuickSort().quickSort(numbers, 0, numbers.length - 1);
        // 大小王个数
        int count0 = 0;
        while (numbers[count0] == 0) {
            count0++;
        }
        for (int i = count0 + 1; i < numbers.length; i++) {
            // 不连续
            if (numbers[i] != numbers[i - 1] + 1) {
                // 大小王用完了,且不连续
                if (count0 == 0) {
                    return false;
                } else {
                    count0--; // 大小王减1
                    numbers[i - 1]++;
                    i--; //【关键】
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = new int[]{0, 0, 2, 3, 5};
        System.out.println(Arrays.toString(a));
        System.out.println(new Solution48().isContinuous(a));
        System.out.println(Arrays.toString(a));
    }
}
