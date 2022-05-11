package resume.onlineAC;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class Solution_LRU {


    public Map<Integer, Long> keyTimeMap = new HashMap<>();

    public Map<Integer, Integer> map = new HashMap<>();

    public int capacity = -1;

    public Solution_LRU(int capacity) {
        keyTimeMap = new HashMap<>(capacity);
        map = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer integer = map.get(key);
        if (null != integer) {
            keyTimeMap.put(key, System.nanoTime());
            return integer;
        }
        return -1;
    }

    public void set(int key, int value) {
        if (null != map.get(key)) {
            map.put(key, value);
            keyTimeMap.put(key, System.nanoTime());
        } else {
            if (map.size() < this.capacity) {
                map.put(key, value);
                keyTimeMap.put(key, System.nanoTime());
            } else {
                int longNoUseKey = findLongNoUseKey();
                map.remove(longNoUseKey);
                keyTimeMap.remove(longNoUseKey);

                map.put(key, value);
                keyTimeMap.put(key, System.nanoTime());
            }
        }
    }

    public int findLongNoUseKey() {
        int key = -1;
        long time = Long.MAX_VALUE;
        for (Map.Entry<Integer, Long> entry : keyTimeMap.entrySet()) {
            if (time > entry.getValue()) {
                time = entry.getValue();
                key = entry.getKey();
            }
        }
        return key;
    }

    public static void main(String[] args) {
        Solution_LRU solutionLRU = new Solution_LRU(2);
        solutionLRU.set(1, 1);
        solutionLRU.set(2, 2);
        solutionLRU.set(3, 2);
        System.out.println(solutionLRU.get(1));
        solutionLRU.set(4, 4);
        System.out.println(solutionLRU.get(2));
        System.out.println(JSON.toJSONString(solutionLRU.map));
        System.out.println(JSON.toJSONString(solutionLRU.keyTimeMap));
    }

}
