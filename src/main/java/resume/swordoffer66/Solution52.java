package resume.swordoffer66;

/**
 * Created By
 * 数组中重复的数字
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 * @author :   zhangj
 * @date :   2019-01-11
 */
public class Solution52 {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        //0~length-1之间,长度为length
        int[] temp = new int[length]; // int 默认为0
        for (int i = 0; i < length; i++) {
            temp[numbers[i]]++;
            if (temp[numbers[i]] > 1) {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 3, 2, 1};
        int[] duplication = new int[1];
        System.out.println(new Solution52().duplicate(a, a.length, duplication));
        System.out.println(duplication[0]);

    }
}
