package resume.resume.onlineAC.z_recursive;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QuanPaiLieList {

    public static List<List<String>> ALL_LIST = new LinkedList<>();

    public static void main(String[] args) {
        String subStr = "aa,bb,cc,eats,go,od";
        List<String> list = Arrays.asList(subStr.split(","));
        List<String> seqList = new ArrayList<>();
        calc(list, seqList);
        System.out.println(JSON.toJSONString(ALL_LIST));
    }

    public static void calc(List<String> list, List<String> seqList) {
        if (list.isEmpty()) {
            List<String> res = new ArrayList<>(seqList);
            ALL_LIST.add(res);
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
}
