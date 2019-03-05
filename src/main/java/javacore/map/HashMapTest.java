package javacore.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-05
 */
public class HashMapTest {

    public static void main(String[] args) {


        // 在写Map<K,V>的时候， <K,V>这个一定要加上, 一是为了保证数据正确性, 二是为了后续代码强制检验方便
        HashMap<String, String> hashMap = new HashMap<String, String>();

        hashMap.put("a", "1");
        hashMap.put("b", "2");
        hashMap.put("c", "3");

        for (String key : hashMap.keySet()) {
            System.out.println(key.toString());
        }

        for (String value : hashMap.values()) {
            System.out.println(value);
        }
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
    }
}
