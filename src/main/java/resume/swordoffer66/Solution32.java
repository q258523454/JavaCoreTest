package resume.swordoffer66;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 把数组排成最小的数
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能
 * 排成的最小数字为321323。
 *
 * @author :   zhangj
 * @date :   2018-12-28
 */
public class Solution32 {

    public String PrintMinNumber(int[] numbers) {
        int n = numbers.length;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(numbers[i]);
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);
            }

        });

        String s = "";
        for (int j : list) {
            s += j;
        }
        return s;

    }


    public static void main(String[] args) {

    }

}
