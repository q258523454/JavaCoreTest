package javacore.base.t2_collection.map.hashmap.init;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class HashMapFastInit {


    public static void main(String[] args) {

        // HashMap 快速初始化
        Map<String, String> map = new HashMap<String, String>() {{
            put("1", "a");
            put("2", "b");
        }};

        System.out.println(JSON.toJSON(map));
    }
}
