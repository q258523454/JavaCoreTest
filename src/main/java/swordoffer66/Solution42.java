package swordoffer66;

import java.util.ArrayList;

/**
 * Created By
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * @author :   zhangj
 * @date :   2019-01-08
 */
public class Solution42 {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {

        int left = 0;
        int right = array.length - 1;

        int multi = Integer.MAX_VALUE;
        int l = -1;
        int r = -1;
        while (left < right) {
            int addLR = array[left] + array[right];
            if (addLR == sum) {
                System.out.println(array[left] + "," + array[right]);
                int temp = array[left] * array[right];
                if (temp < multi) {
                    multi = temp;
                    l = array[left];
                    r = array[right];
                }
                left++;
                right--;
            }
            if (addLR > sum) {
                right--;
            }
            if (addLR < sum) {
                left++;
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(l);
        arrayList.add(r);
        return arrayList;
    }
    
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};

        System.out.println(new Solution42().FindNumbersWithSum(a, 8));

    }
}
