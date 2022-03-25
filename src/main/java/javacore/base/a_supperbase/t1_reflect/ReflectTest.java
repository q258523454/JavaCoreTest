package javacore.base.a_supperbase.t1_reflect;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: zhang
 * @Date: 2019-08-09
 * @Version 1.0
 */

@Slf4j
public class ReflectTest {
    private String name;
    private List<String> scores1 = new ArrayList<>(10);
    private HashMap<String, Integer> hashMap = new HashMap<>(10);

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getScores1() {
        return scores1;
    }

    public static void main(String[] args) throws NoSuchFieldException {

        // 获取所有方法的所有入参
        Method[] methods = ReflectTest.class.getMethods();
        for (Method method : methods) {
            //
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            for (Type genericParameterType : genericParameterTypes) {
                log.info("方法:" + method.getName() + " 入参:" + JSON.toJSONString(genericParameterType));
            }
        }

        // 获取指定属性的参数类型
        Field field = ReflectTest.class.getDeclaredField("hashMap");
        ParameterizedType stringListType = (ParameterizedType) field.getGenericType();
        Type[] actualTypeArguments = stringListType.getActualTypeArguments();
        for (int i = 0; i < actualTypeArguments.length; i++) {
            log.info("参数:" + field.getName() + ", 入参" + i + ":" + actualTypeArguments[i].getTypeName());
        }
    }
}
