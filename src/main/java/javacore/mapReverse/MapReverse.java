package javacore.mapReverse;
// Created by ZhangJian on 18/1/16.

import java.util.HashMap;
import java.util.Map;

public class MapReverse {

    public static void main(String[] args) {
        Map<String, Integer> myHashMap = new HashMap<>();
        myHashMap.put("a",1);
        myHashMap.put("b",2);

        Map<Integer, String> myNewHashMap = new HashMap<>();
        for(Map.Entry<String, Integer> entry : myHashMap.entrySet()){
            myNewHashMap.put(entry.getValue(), entry.getKey());
        }

        System.out.println(myNewHashMap);
    }
}
