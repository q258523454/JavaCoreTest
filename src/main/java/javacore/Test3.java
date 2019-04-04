package javacore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-02-28
 */
public class Test3 {
    public static void main(String[] args) {
        HashSet<HashMap<String, String>> hashSet = new HashSet<>();
        HashMap hashMap1 = new HashMap<String, String>();
        HashMap hashMap2 = new HashMap<String, String>();
        HashMap hashMap3 = new HashMap<String, String>();
        hashMap1.put("a", "1");
        hashMap2.put("b", "2");
        hashMap3.put("a", "1");
        hashSet.add(hashMap1);
        hashSet.add(hashMap2);
        hashSet.add(hashMap3);
        System.out.println(hashSet.size());
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        System.out.println(list.size());

        // 创建集合对象
        HashSet<String> hs = new HashSet<String>();

        // 创建并添加元素
        hs.add("hello");
        hs.add("world");
        hs.add("java");
        hs.add("world");

        // 遍历集合
        for (String s : hs) {
            System.out.println(s);
        }

    }
}

