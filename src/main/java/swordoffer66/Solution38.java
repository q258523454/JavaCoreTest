package swordoffer66;

import java.util.HashMap;
import java.util.Map;

/**
 * Created By
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
 *
 * @author :   zhangj
 * @date :   2019-01-07
 */


public class Solution38 {
    // num1,num2分别为长度为1的数组。传出参数
    // 将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == null) {
                map.put(array[i], 1);
            } else {
                map.put(array[i], map.get(array[i]) + 1);
            }
        }
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == 1 && j == 1) {
                num2[0] = array[i];
                j++;
            }
            if (map.get(array[i]) == 1 && j == 0) {
                num1[0] = array[i];
                j++;
            }
        }
    }
}