package javacore.baseimpro.dynamicmethod;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class DynamicExecMethod_Reflect {

    public static <T> void reflect(T t, String methodName) {
        try {
            Method m = t.getClass().getMethod(methodName, null);
            m.invoke(t, null);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void insert() {
        log.info("insert a value");
    }

    public static void main(String[] args) {
        DynamicExecMethod_Reflect t = new DynamicExecMethod_Reflect();
        reflect(t, "insert");
    }
}
