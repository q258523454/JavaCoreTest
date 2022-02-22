package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.*;

public enum MapUtil {
    ;
    private static final Logger log = LoggerFactory.getLogger(MapUtil.class);


    /**
     * 升序排列
     * @param map
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValueAsc(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    /**
     * 降序排列
     * @param map
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValueDesc(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());

        Collections.sort(list, ((o1, o2) -> o2.getValue().compareTo(o1.getValue())));

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    /**
     * 利用反射将 {@code object}中的属性转换成{@code Map}
     * @param object 待转换的对象
     */
    public static Map<String, Object> parseObjectToMap(Object object) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(object));
        }
        return map;
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("d", 2);
        map.put("c", 4);
        map.put("b", 1);
        map.put("a", 3);

        log.info("排序前:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            log.info(entry.getKey() + " " + entry.getValue());
        }
        log.info("排序后:");
        map = MapUtil.sortByValueDesc(map);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            log.info(entry.getKey() + " " + entry.getValue());
        }
    }
}