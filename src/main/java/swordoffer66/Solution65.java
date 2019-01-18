package swordoffer66;

import java.util.ArrayList;

/**
 * Created By
 * 滑动窗口的最大值
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}，
 * {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}，
 * {2,3,4,2,6,[2,5,1]}。
 *
 * @author :   zhangj
 * @date :   2019-01-15
 */


public class Solution65 {


    public ArrayList<Integer> maxInWindows(int[] num, int size) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        if (size == 0) {
            return arrayList;
        }
        for (int i = 0; i <= num.length - size; i++) {
            int max = num[i];
            for (int j = i + 1; j < size + i; j++) {
                max = max > num[j] ? max : num[j];
            }
            arrayList.add(max);
        }
        return arrayList;
    }

    public static void main(String[] args) {

        int[] a = new int[]{2, 3, 4, 2, 6, 2, 5, 1};
        System.out.println(new Solution65().maxInWindows(a, 3));

    }

}
