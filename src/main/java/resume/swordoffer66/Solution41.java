package resume.swordoffer66;

import java.util.ArrayList;

/**
 * Created By
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 *
 * @author :   zhangj
 * @date :   2019-01-08
 */
public class Solution41 {

    // (1+n)*n/2 >=sum , 这里简单的取 根号{sum}+1
    public int maxSequenceLength(int sum) {
        int length = -1;
        for (int i = 0; i <= sum / 2 + 1; i++) {
            if (i * i >= sum) {
                length = i;
                break;
            }
        }
        return length + 1;
    }


    // 一个数sum, 最大连续的序列从1开始, 最大个数为maxSequenceLength(sum),然后对每个数做该区间的累加,时间复杂度O(nk),k是根号n
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int maxSeqLen = maxSequenceLength(sum);
        for (int i = 1; i <= (sum / 2 + 1); i++) {
            for (int j = 2; j <= maxSeqLen; j++) {
                if (i == 10) {
                    System.out.println();
                }
                int addSum = 0;
                addSum += j * i;
                addSum += (j - 1) * j / 2;
                if (addSum == sum) {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    for (int k = 0; k < j; k++) {
                        arrayList.add(i + k);
                    }
                    res.add(arrayList);
                    maxSeqLen = maxSeqLen > j ? maxSeqLen : j; // 后续的连续数字个数只会减小,不会大于本次
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new Solution41().FindContinuousSequence(100));
    }

}
