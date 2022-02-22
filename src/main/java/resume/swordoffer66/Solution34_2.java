package resume.swordoffer66;

import java.util.HashMap;
import java.util.Map;

/**
 * Created By
 * <p>
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.
 *
 * @author :   zhangj
 * @date :   2019-01-03
 */
public class Solution34_2 {

    public int FirstNotRepeatingChar(String str) {

        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            int ascii = str.charAt(i);
            if (null == mp.get((int) str.charAt(i))) {
                mp.put(ascii, 1);
            } else {
                mp.put(ascii, mp.get(ascii) + 1);
            }
        }

        for (int i = 0; i < str.length(); i++) {
            int ascii = str.charAt(i);
            if (mp.get(ascii) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String str = "NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp";
//        String str = "aabbcco";
        int index = new Solution34_2().FirstNotRepeatingChar(str);
        System.out.println(index);
        if (index != -1) {
            System.out.println(str.charAt(new Solution34_2().FirstNotRepeatingChar(str)));
        }
    }
}

