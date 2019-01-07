package swordoffer66;

/**
 * Created By
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
 *
 * @author :   zhangj
 * @date :   2019-01-07
 */
public class Solution38_2 {


    // num1,num2分别为长度为1的数组。传出参数
    // 将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {

        int res = Xor(array);
        int bitCount = 0;
        while (res != 1 && (res & 1) != 1) {
            res = res >> 1;
            bitCount++;
        }

        int j = 0;
        int k = 0;
        int[] arr1 = new int[array.length];
        int[] arr2 = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int n = array[i];
            n = n >> bitCount;
            if ((n & 1) == 1) {
                arr1[j++] = array[i];
            } else {
                arr2[k++] = array[i];
            }
        }
        num1[0] = Xor(arr1);
        num2[0] = Xor(arr2);
    }

    // 找出array中只出现一次的数字(只有1个数字出现了1次，其他的数字都出现了偶数次)
    public int Xor(int[] array) {
        int n = 0;
        for (int i = 0; i < array.length; i++) {
            n ^= array[i];
        }
        return n;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 8, 12};
        int[] num1 = new int[1];
        int[] num2 = new int[1];

        new Solution38_2().FindNumsAppearOnce(arr, num1, num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);

    }
}
