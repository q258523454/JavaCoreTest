package javacore.base_practice.collection.lists.init;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class ListFastInit {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>() {
            {
                add("1");
                add("2");
            }
        };

        System.out.println(JSON.toJSON(list));
    }
}
