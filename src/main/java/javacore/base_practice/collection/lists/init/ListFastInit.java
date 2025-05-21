package javacore.base_practice.collection.lists.init;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListFastInit {
    public static void main(String[] args) {
        // 方法1
        List<String> list1 = new ArrayList<String>() {
            {
                add("1");
                add("2");
            }
        };

        System.out.println(JSON.toJSON(list1));


        // 方法2
        List<String> list2 = new ArrayList<>(Arrays.asList("a,b,c,d,e,f,g,h".split(",")));
        System.out.println(JSON.toJSON(list2));

    }
}
