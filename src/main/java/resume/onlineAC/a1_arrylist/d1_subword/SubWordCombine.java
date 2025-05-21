package resume.onlineAC.a1_arrylist.d1_subword;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class SubWordCombine {

    /**
     * 题目描述：有一个字符串数组words和一个字符串chars。
     * 假如可以用chars中的字母拼写出words中的某个“单词”（字符串），那么我们就认为你掌握了这个单词。
     * words的字符仅由 a-z 英文小写字母组成。 例如: abc
     * chars 由 a-z 英文小写字母和 “?”组成。其中英文问号“?”表示万能字符，能够在拼写时当做任意一个英文字母。 例如： "?" 可以当做 "a"等字母。
     * 注意：每次拼写时，chars中的每个字母和万能字符都只能使用一次。
     * 输出词汇表words中你掌握的所有单词的个数。 没有掌握任何单词，则输出0。
     *
     * 输入描述：第1行输入数组words的个数，记为N。
     * 从第2行开始到第N+1行依次输入数组words的每个字符串元素。
     * 第N+2行输入字符串chars。
     *
     * 输出描述：输出一个整数，表示词汇表words中你掌握的单词个数。
     *
     * 补充说明：注意：
     * 1 <= words.length <= 100
     * 1 <= words[i].length, chars.length <= 100
     * 所有字符串中都仅包含小写英文字母、英文问号
     *
     * 示例
     * 输入：3
     * apple
     * car
     * window
     * welldoneapplec?
     * 输出：2
     * 说明：可以拼写字符串"apple"和"car"
     *
     * 备注: 这道题可以用空间换时间快速解题(MAP结构)
     */
    public static boolean isMatchWord(String input, String template) {
        if (input == null || template == null || input.length() > template.length()) {
            return false;
        }
        char[] tempArr = template.toCharArray();
        char[] inputArr = input.toCharArray();
        // 排序
        Arrays.sort(tempArr);
        Arrays.sort(inputArr);
        // System.out.println(Arrays.toString(inputArr));
        // System.out.println(Arrays.toString(tempArr));
        int count = 0;
        for (char c : tempArr) {
            if (c == '?') {
                count++;
            }
        }
        int index1 = 0;
        int index2 = 0;
        while (index1 < inputArr.length && index2 < tempArr.length) {
            // 找到相同字符
            while (index2 < tempArr.length && inputArr[index1] != tempArr[index2]) {
                index2++;
            }

            // 如果存在,则游标同时+1
            if (index2 < tempArr.length) {
                index1++;
                index2++;
            }
        }

        if (index1 == inputArr.length) {
            return true;
        }
        if (index1 + count >= inputArr.length) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        List<String> inputList = new ArrayList<>();
        inputList.add("apple");
        inputList.add("car");
        inputList.add("window");

        String template = "welldoneapplec?";

        for (String s : inputList) {
            System.out.println(isMatchWord(s, template));
        }
    }
}