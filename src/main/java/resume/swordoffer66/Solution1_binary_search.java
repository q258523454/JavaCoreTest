package resume.swordoffer66;

import java.util.Arrays;

/**
 * Created By
 *
 * 二维数组的查找
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author :   zhangj
 * @date :   2019-01-18
 */
public class Solution1_binary_search {
    public boolean Find(int target, int[][] array) {
        if (array == null) {
            return false;
        }
        return subFind(target, array, 0, array.length - 1, 0, array[0].length - 1);
    }


    public boolean subFind(int target, int[][] array, int leftStart, int leftEnd, int rightStart, int rightEnd) {
        if (leftStart > leftEnd || rightStart > rightEnd) {
            return false;
        }
        int[] curArray = array[leftStart];

        int left = rightStart;
        int right = rightEnd;
        boolean goLeft = true; // 是比key小还是大
        while (left <= right && curArray[(left + right) / 2] != target) {
            if (target > curArray[(left + right) / 2]) {
                left = (left + right) / 2 + 1;
                goLeft = false;
            }
            if (target < curArray[(left + right) / 2]) {
                right = (left + right) / 2 - 1;
                goLeft = true;
            }
        }
        if (curArray[(left + right) / 2] == target) {
            System.out.println("index0:" + leftStart + ",index2:" + (left + right) / 2);
            return true;
        }

        if (goLeft == true) {
            return subFind(target, array, leftStart + 1, array.length - 1, 0, right);
        } else {
            return subFind(target, array, leftStart + 1, array.length - 1, right, rightEnd);
        }
    }


    public static void main(String[] args) {
        int[][] array = new int[4][4];
        int[] a0 = new int[]{1, 4, 8, 12};
        int[] a1 = new int[]{2, 5, 9, 13};
        int[] a2 = new int[]{3, 6, 10, 14};
        int[] a3 = new int[]{8, 11, 19, 50};
        array[0] = a0;
        array[1] = a1;
        array[2] = a2;
        array[3] = a3;
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }

        System.out.println(new Solution1_binary_search().Find(7, array));
    }
}
