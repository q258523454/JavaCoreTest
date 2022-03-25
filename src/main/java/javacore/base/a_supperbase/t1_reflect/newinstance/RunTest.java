package javacore.base.a_supperbase.t1_reflect.newinstance;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@Slf4j
public class RunTest {

    public static void main(String[] args) {
        method(Student.class);
    }


    public static void method(Class<?> cls) {
        try {
            Object o = cls.newInstance();
        } catch (Exception e) {
            e.printStackTrace();

            for (Constructor<?> constructor : cls.getConstructors()) {
                int length = constructor.getGenericParameterTypes().length;
                Object[] params = new Object[length];
                for (int i = 0; i < length; i++) {
                    params[i] = new Object();
                }
                try {
                    params[0] = new Integer("1");
                    params[1] = new String("ss");
                    params[2] = new Integer("20");
                    Object o = constructor.newInstance(params);
                    Student s = (Student) o;
                    log.info("Student实例化完成");
                    log.info(JSONObject.toJSONString(s));
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException ex) {
                    ex.printStackTrace();
                }
            }
        }
        Constructor<?>[] constructors = cls.getConstructors();
        for (Constructor<?> constructor : cls.getConstructors()) {
            log.info(constructor.getName());
        }
    }
}
