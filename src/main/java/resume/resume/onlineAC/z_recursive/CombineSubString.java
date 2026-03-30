package resume.resume.onlineAC.z_recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CombineSubString {

    public static String INPUT = "";
    public static List<List<String>> ALL_LIST = new LinkedList<>();
    public static List<List<String>> ALL_FIRST_MATCH_LIST = new LinkedList<>();

    /**
     * 子单词不可重复
     * goodeats
     * good,goo,deats,eats,go,od
     * 有以下组合:
     * [go][od][eats]
     * [goo][deats]
     * [good][eats]
     */
    public static void main(String[] args) {
        String inputStr = "goodeats";
        INPUT = inputStr;
        String subStr = "good,goo,deats,eats,go,od";
        List<String> list = Arrays.asList(subStr.split(","));
        calc(list, new ArrayList<>());
        print();
    }

    private static void print() {
        // 子串所有可能的组合方式
        Set<String> allCombineWordList = new HashSet<>();
        for (List<String> stringList : ALL_FIRST_MATCH_LIST) {
            String tempMatch = "";
            String combineWordString = "";
            // 递归匹配的时候,一定是后缀匹配
            for (int i = stringList.size() - 1; i > 0; i--) {
                tempMatch = stringList.get(i) + tempMatch;
                combineWordString = "[" + stringList.get(i) + "]" + combineWordString;
                if (INPUT.equalsIgnoreCase(tempMatch)) {
                    allCombineWordList.add(combineWordString);
                    break;
                }
            }
        }
        for (String combineWord : allCombineWordList) {
            System.out.println(combineWord);
        }
    }

    public static void calc(List<String> list, List<String> seqList) {
        List<String> matchRes = new ArrayList<>(seqList);
        // 核心: 全排列的时候一旦匹配则无需继续递归
        if (isFirstTimeMatch(matchRes)) {
            ALL_FIRST_MATCH_LIST.add(matchRes);
            return;
        }

        if (list.size() == 1) {
            seqList.add(list.get(0));
            List<String> res = new ArrayList<>(seqList);
            ALL_LIST.add(res);
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            List<String> subList = new ArrayList<>();
            List<String> subSeqList = new ArrayList<>(seqList);
            String temp = list.get(i);
            subSeqList.add(temp);
            for (int j = 0; j < list.size(); j++) {
                if (i == j) {
                    continue;
                }
                subList.add(list.get(j));
            }
            calc(subList, subSeqList);
        }
    }

    private static boolean isFirstTimeMatch(List<String> res) {
        String matchStr = "";
        for (String w : res) {
            matchStr = matchStr + w;
        }
        return matchStr.contains(INPUT);
    }
}
