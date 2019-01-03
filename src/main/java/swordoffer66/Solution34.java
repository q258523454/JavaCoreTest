package swordoffer66;

import java.util.LinkedList;

/**
 * Created By
 * <p>
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.
 *
 * @author :   zhangj
 * @date :   2019-01-03
 */
public class Solution34 {

    public int FirstNotRepeatingChar(String str) {
        // A~Z|a~z的ASCII范围[65,128]
        int[] count = new int[128]; // 字符次数统计
        int[] index = new int[128]; // 字符首次出现下标记录
        LinkedList<Integer> linkedList = new LinkedList<Integer>(); // 链表记录字符出现顺序

        // 初始化
        for (int i = 0; i < index.length; i++) {
            index[i] = -1;
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            count[(int) c]++;
            // 记录当前字符出现的顺序,同字符只需要记录一次,并按顺序组成链表(链表就是字符出现顺序,index就是首次出现的下标)
            if (-1 == index[(int) c]) {
                index[(int) c] = i;
                linkedList.add((int) c);
            }
        }

        while (linkedList != null && !linkedList.isEmpty()) {
            int c = linkedList.removeFirst(); // Removes and returns the first element from this list.
            if (count[c] == 1) {
                return index[c];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String str = "NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp";
        int index = new Solution34().FirstNotRepeatingChar(str);
        System.out.println(index);
        if (index != -1) {
            System.out.println(str.charAt(new Solution34().FirstNotRepeatingChar(str)));
        }
    }
}

