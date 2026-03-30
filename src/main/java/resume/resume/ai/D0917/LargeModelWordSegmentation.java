package resume.resume.ai.D0917;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LargeModelWordSegmentation {

    public static String INPUT = "";
    public static List<List<Word>> ALL_LIST = new LinkedList<>();
    public static List<List<Word>> ALL_FIRST_MATCH_LIST = new LinkedList<>();

    /**
     * 设计并实现一个“最优分词器”，它能将输入的罕见语言句子(一个不含空格的英文小写字符多也串)切分成一系列词元， 并使得所有词元的置信度分数
     * 之和达到最大，从而帮助大语言模型在后续处理中能够输出更合理句子
     *
     * 第一行输入待分词的字符串text ，假设只包含英文小写字母；
     * 接着输入词典词条数 n；
     * 然后输入 n 行，每一行包含一个单词和对应的分值，以空格分隔。
     * 第 n+3 行为转移分数的个数 。
     * 随后 m 行为转移分数数据。包括起始词、下一个词、转移分数加分X。以空格分隔。
     *
     * 输入1:
     * applepie
     * pen 3
     * apple 10
     * 2
     * pen apple 5
     * pie apple 2
     * 输出1:
     * 0
     * 说明: text中的字符不能和词典词条匹配出切分结果，无法计算得分。
     *
     * goodeats
     * good 15
     * goo 12
     * deats 14
     * eats 10
     * 1
     * goo deats -5
     * 有以下组合:
     * [goo][deats]=26-5=21(good eats组合有转移分数为-5)
     * [good][eats]=25
     * 最大得分:25
     */
    public static void main(String[] args) {
        String inputStr = "goodeats";
        INPUT = inputStr;
        String subStr = "good,goo,deats,eats";
        String subStrScore = "15,12,14,10";
        List<String> list = Arrays.asList(subStr.split(","));
        String[] scoreList = subStrScore.split(",");
        List<Integer> iScoreList = new ArrayList<>();
        for (String str : scoreList) {
            iScoreList.add(Integer.parseInt(str));
        }
        List<Word> wordList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Word word = new Word(list.get(i), iScoreList.get(i));
            wordList.add(word);
        }
        calc(wordList, new ArrayList<>());
        print();
    }

    private static void print() {
        String changeStr = "goo deats -5";
        String[] split = changeStr.split(" ");
        String changeWordStr = "[" + split[0] + "][" + split[1] + "]";
        int changeWordScore = Integer.parseInt(split[2]);

        // 子串所有可能的组合方式
        Set<String> allCombineWordList = new HashSet<>();
        for (List<Word> words : ALL_FIRST_MATCH_LIST) {
            String tempMatch = "";
            int tempScore = 0;
            String combineWordString = "";
            for (int i = words.size() - 1; i > 0; i--) {
                tempMatch = words.get(i).word + tempMatch;
                tempScore = words.get(i).score + tempScore;
                combineWordString = "[" + words.get(i).word + "]" + combineWordString;
                if (INPUT.equalsIgnoreCase(tempMatch)) {
                    allCombineWordList.add(combineWordString + "=" + tempScore);
                    break;
                }
            }
        }

        String maxCombineWord = "";
        int maxScore = 0;
        for (String combineWord : allCombineWordList) {
            String[] tempSplit = combineWord.split("=");
            String temp = tempSplit[0];
            int score = Integer.parseInt(tempSplit[1]);

            if (temp.contains(changeWordStr)) {
                score = score + changeWordScore;
            }
            if (score > maxScore) {
                maxScore = score;
                maxCombineWord = combineWord;
            }
        }
        System.out.println(maxCombineWord);
        System.out.println(maxScore);
    }

    public static class Word {
        public String word;
        public int score;

        @Override
        public String toString() {
            return "Word{" + "word='" + word + '\'' + ", score=" + score + '}';
        }

        public Word(String word, int score) {
            this.word = word;
            this.score = score;
        }
    }

    public static void calc(List<Word> list, List<Word> seqList) {
        List<Word> matchRes = new ArrayList<>(seqList);
        // 核心: 全排列的时候一旦匹配则无需继续递归
        if (isFirstTimeMatch(matchRes)) {
            ALL_FIRST_MATCH_LIST.add(matchRes);
            return;
        }

        if (list.size() == 1) {
            seqList.add(list.get(0));
            List<Word> res = new ArrayList<>(seqList);
            ALL_LIST.add(res);
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            List<Word> subList = new ArrayList<>();
            List<Word> subSeqList = new ArrayList<>(seqList);
            Word temp = list.get(i);
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

    private static boolean isFirstTimeMatch(List<Word> res) {
        String matchStr = "";
        for (Word w : res) {
            matchStr = matchStr + w.word;
        }
        return matchStr.contains(INPUT);
    }
}
