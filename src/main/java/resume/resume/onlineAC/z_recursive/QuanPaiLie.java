package resume.resume.onlineAC.z_recursive;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanPaiLie {


    public static List<List<Character>> PRINT_LIST = new ArrayList<>();

    /**
     * 全排列(递归解决)
     * 其他方法参考: {@link resume.onlineAC.c1_tree.QuanPaiLie}
     * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
     * 例如输入字符串1234,则打印出由字符1,2,3,4所能排列出来的所有字符串
     * ["1234","1243","1324","1342","1423","1432","2134","2143","2314","2341","2413","2431","3124","3142","3214","3241","3412","3421","4123","4132","4213","4231","4312","4321"]
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        char[] chars = string.toCharArray();
        List<Character> charList = new ArrayList<>();
        for (char aChar : chars) {
            charList.add(aChar);
        }
        calc(charList, new ArrayList<>());
        print();

    }

    public static void calc(List<Character> list, List<Character> seqList) {
        // 核心:边界
        if (list.size() == 1) {
            seqList.add(list.get(0));
            PRINT_LIST.add(seqList);
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            // 核心:每次递归,局部变量考虑是否继承上一次结果
            List<Character> subSeqList = new ArrayList<>(seqList);
            List<Character> subList = new ArrayList<>();
            Character character = list.get(i);
            subSeqList.add(character);
            for (int j = 0; j < list.size(); j++) {
                // 核心:剪枝
                if (i == j) {
                    continue;
                }
                subList.add(list.get(j));
            }
            calc(subList, subSeqList);
        }
    }

    private static void print() {
        StringBuilder res = new StringBuilder("\"");
        for (List<Character> characters : PRINT_LIST) {
            for (Character character : characters) {
                res.append(character);
            }
            res.append("\"").append(",").append("\"");
        }
        res.deleteCharAt(res.length() - 3);
        System.out.println("[" + res + "]");
    }
}
