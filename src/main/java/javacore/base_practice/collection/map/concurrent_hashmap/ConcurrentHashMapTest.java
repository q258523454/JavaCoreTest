package javacore.base_practice.collection.map.concurrent_hashmap;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class ConcurrentHashMapTest {
    public static ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();

    /**
     * @Description
     * @date 2020年08月11日 20:21
     * @param args
     */
    public static void main(String[] args) {

        concurrentHashMap.clear();
        concurrentHashMap.put("zhangxiaofan", "18");
        concurrentHashMap.put("wangwu", "20");
        concurrentHashMap.forEach((key, value) -> {
            log.info(key + ":" + value);
        });

    }
}
