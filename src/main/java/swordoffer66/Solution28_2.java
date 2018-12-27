package swordoffer66;

/**
 * 借助map集合统计
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
 * 超过数组长度的一半，因此输出2。如果不存在则输出0。
 * @author :   zhangj
 * @date :   2018-12-27
 */

import java.util.HashMap;
import java.util.Map;
public class Solution28_2 {


    public int MoreThanHalfNum_Solution(int [] array) {

        int len = array.length;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            int index = array[i];
            if (map.get(index) == null) {
                map.put(index, 1);
            } else {
                map.put(index, map.get(index)+1);
            }
        }

        for (Map.Entry<Integer, Integer> entity : map.entrySet()) {
            if (entity.getValue() > array.length / 2) {
                return entity.getKey();
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] a = new int[]{};
        System.out.println(new Solution28_2().MoreThanHalfNum_Solution(a));
    }

}
