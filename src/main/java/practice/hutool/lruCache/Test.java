package practice.hutool.lruCache;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.LRUCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    private static LRUCache<String, String> lruCache = CacheUtil.newLRUCache(10);

    public static void main(String[] args) throws InterruptedException {
        List<Map<String, String>> map = new ArrayList<>();
        map.add(null);
        Map<String, String> map1 = new HashMap<>();
    }
}
