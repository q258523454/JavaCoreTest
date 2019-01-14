package swordoffer66;

import java.util.Scanner;

/**
 * Created By
 * 字符流中第一个不重复的字符
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * @author :   zhangj
 * @date :   2019-01-11
 */
public class Solution56 {

    class Link {
        int val = 0;
        Link next = null;

        Link(int val) {
            this.val = val;
        }
    }

    int[] charCount = new int[128];
    Link head = new Link(-1);

    //Insert one char from stringstream
    public void Insert(char ch) {
        // 首先将字符的计数+1
        charCount[ch]++;

        // 每读取1个字符,就更新链表
        Link p = head;
        Link q = head.next;
        while (q != null) {
            if (charCount[q.val] >= 2) {
                p.next = q.next;
                q = q.next;
            } else {
                p = p.next;
                q = q.next;
            }
        }
        // 当前进入的字符,注意p已经是经过遍历之后的节点了
        if (charCount[ch] <= 1) {
            Link insert = new Link(ch);
            p.next = insert;
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        if (head.next != null) {
            return (char) head.next.val;
        }
        return '#';
    }

    public static void main(String[] args) {
        System.out.print("输入");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println("输入数据：" + str);

        Solution56 solution56 = new Solution56();
        for (int i = 0; i < str.length(); i++) {
            solution56.Insert(str.charAt(i));
        }

        System.out.println(solution56.FirstAppearingOnce());
    }

}
