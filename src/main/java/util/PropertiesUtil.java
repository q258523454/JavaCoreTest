package util;

import com.alibaba.fastjson.JSON;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 读取配置,读取properties工具
 */
public enum PropertiesUtil {
    ;
    private static Properties properties;

    /**
     * 读取配置, 读取properties
     */
    private static void init() {
        try {
            properties = new Properties();
            InputStream resourceAsStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("config/application.properties");
            if (null == resourceAsStream) {
                throw new RuntimeException("config file is null.");
            }
            InputStreamReader inputStream = new InputStreamReader(resourceAsStream, StandardCharsets.UTF_8);
            properties.load(inputStream);
            System.out.println("配置如下:\n" + JSON.toJSONString(getPropertiesMap()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据key读取对应的value
     */
    public static String get(String key) {
        if (null == properties) {
            init();
        }
        return properties.getProperty(key);
    }

    /**
     * 得到所有的配置信息
     */
    public static Map<String, String> getPropertiesMap() {
        Map<String, String> map = new HashMap<>();
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            map.put((String) entry.getKey(), (String) entry.getValue());
        }
        return map;
    }
}