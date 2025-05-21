package util;

import lombok.extern.slf4j.Slf4j;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * bean2map工具类
 */
@Slf4j
public enum BeanToMapUtil {
    ;

    /**
     * bean转map,避免 setAccessible(true)
     *
     * @param obj obj
     * @return map
     * @throws Exception Exception
     */
    public static Map<String, Object> beanToMap(Object obj) throws Exception {
        if (obj == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                // 过滤class属性
                if (!key.equals("class")) {
                    // 得到property对应的getter方法
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(obj);
                    map.put(key, value);
                }
            }
        } catch (IntrospectionException | IllegalAccessException | InvocationTargetException ex) {
            log.error("bean to map error:", ex);
            throw new Exception(ex);
        }
        return map;
    }

    /**
     * 访问每一个属性
     */
    public static void readAttributeValue(Object obj) {
        StringBuilder nameVlues = new StringBuilder();
        //Get class
        Class cls = obj.getClass();
        //Get all attributes
        Field[] fields = cls.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {//Traverse
            try {
                //Get attributes
                Field field = fields[i];
                //Turn on private access
                field.setAccessible(true);
                //Get attributes name
                String name = field.getName();
                //Get attribute value
                Object value = field.get(obj);
                //Assign one by one
                nameVlues.append("name:").append(name).append(", value:").append(value).append(",");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        System.out.println(nameVlues.toString());
    }
}
