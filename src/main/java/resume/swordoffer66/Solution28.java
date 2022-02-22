package resume.swordoffer66;

/**
 * 时间复杂度最优 O(n)
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
 * 超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 * @author :   zhangj
 * @date :   2018-12-27
 */


public class Solution28 {


    public int MoreThanHalfNum_Solution(int[] array) {
        int temp = array[0];
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == temp) {
                count++;
            }

            if (array[i] != temp) {
                count--;
            }

            if (count == 0 && (i + 1) < array.length) {
                temp = array[i + 1];
            }
        }

        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == temp) {
                count++;
            }
        }
        if (count > array.length / 2) {
            return temp;
        }else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{4,2,1,4,2,4};
        System.out.println(new Solution28().MoreThanHalfNum_Solution(a));
    }
}
