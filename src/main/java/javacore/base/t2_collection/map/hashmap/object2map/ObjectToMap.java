package javacore.base.t2_collection.map.hashmap.object2map;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import util.MapUtil;

import java.util.Arrays;
import java.util.Map;

/**
 * @Author: zhangj
 * @Date: 2019-12-03
 * @Version 1.0
 */
@Slf4j
public class ObjectToMap {
    public static void main(String[] args) throws IllegalAccessException {
        ObjectMapper mapper = new ObjectMapper();

        Student obj = new Student();
        obj.setName("mkyong");
        obj.setAge(34);
        obj.setSkills(Arrays.asList("java", "node"));

        // object -> Map
        // 1.利用Jackson工具包:
        Map<String, Object> map = mapper.convertValue(obj, Map.class);
        log.info(JSON.toJSONString(map));

        // 2.利用反射
        Map<String, Object> map2 = MapUtil.parseObjectToMap(obj);
        log.info(JSON.toJSONString(map2));

    }
}