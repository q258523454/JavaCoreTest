package util;


import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public enum AnnotationUtil {
    ;

    /**
     * 类所有注解值
     */
    public static void printClassAnno(Class<?> tClass) throws InvocationTargetException, IllegalAccessException {
        Annotation[] annotations = tClass.getAnnotations();
        for (Annotation annotation : annotations) {
            Class<? extends Annotation> anoClass = annotation.annotationType();
            log.info("Values:" + anoClass.getName());
            log.info("Values:{}", anoClass.getName());

            for (Method anoMethod : anoClass.getDeclaredMethods()) {
                Object value = anoMethod.invoke(annotation, (Object[]) null);
                log.info(" " + anoMethod.getName() + ":" + value);
            }
        }
    }

    /**
     * 类-方法:注解和注解值
     */
    public static void printMethodAnno(Class<?> tClass) throws InvocationTargetException, IllegalAccessException {
        Method[] declaredMethods = tClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            Annotation[] annotations = declaredMethod.getAnnotations();
            for (Annotation annotation : annotations) {
                Class<? extends Annotation> anoClass = annotation.annotationType();
                log.info("Values:" + anoClass.getName());
                for (Method anoMethod : anoClass.getDeclaredMethods()) {
                    Object value = anoMethod.invoke(annotation, (Object[]) null);
                    log.info(" " + anoMethod.getName() + ":" + JSON.toJSONString(value));
                }
            }
        }
    }

    /**
     * 类-属性:注解和注解值
     */
    public static void printFieldAnno(Class<?> tClass) {
        Field[] fields = tClass.getDeclaredFields();
        for (Field field : fields) {
            for (Annotation annotation : field.getAnnotations()) {
                log.info(annotation.toString());
            }
        }
    }

}
