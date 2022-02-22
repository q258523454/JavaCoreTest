package javacore.base.t2_collection.map.hashmap.iterator;

import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-05
 */
@Slf4j
public class IteratorTest {

    public static void main(String[] args) {


        // 在写Map<K,V>的时候， <K,V>这个一定要加上, 一是为了保证数据正确性, 二是为了后续代码强制检验方便
        HashMap<String, String> hashMap = new HashMap<String, String>();

        hashMap.put("a", "1");
        hashMap.put("b", "2");
        hashMap.put("c", "3");

        // 获取Map中的所有键
        for (String key : hashMap.keySet()) {
            System.out.print(key.toString() + " ");
        }
        log.info("");

        // 获取Map中所有值
        for (String value : hashMap.values()) {
            System.out.print(value + " ");
        }
        log.info("");

        // 获取Map中所有值2
        Collection<String> stringCollections = hashMap.values();
        for (String value : stringCollections) {
            System.out.print(value + " ");
        }
        log.info("");


        // 得到key的值的同时得到key所对应的值(方法一): 直接返回entry
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            log.info(entry.getKey() + "-" + entry.getValue());
        }

        // 得到key的值的同时得到key所对应的值(方法二): 直接返回entry
        hashMap.forEach((key, value) -> {
            log.info(key + "-" + value);
        });

        // 得到key的值的同时得到key所对应的值(方法三): 通过key来获取(不推荐)
//        Set<String> keySet = hashMap.keySet();
//        for (String key : keySet) {
//            log.info("key:" + key + ",value:" + hashMap.get(key));
//        }

    }
}
