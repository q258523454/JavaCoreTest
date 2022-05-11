package util;


import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @Description
 * @date 2020-05-27 16:59
 * @modify
 */
@Slf4j
public enum AnnotationUtil {
    ;

    /**
     * 打印类的注解和注解值
     */
    public static void printClassAnno(Class<?> tClass) throws Exception {
        Annotation[] annotations = tClass.getAnnotations();
        for (Annotation annotation : annotations) {
            Class<? extends Annotation> anoClass = annotation.annotationType();
            System.out.println("Values:" + anoClass.getName());

            for (Method anoMethod : anoClass.getDeclaredMethods()) {
                Object value = anoMethod.invoke(annotation, (Object[]) null);
                System.out.println(" " + anoMethod.getName() + ":" + value);
            }
        }
    }

    /**
     * 打印类中所有方法的注解和注解值
     */
    public static void printMethodAnno(Class<?> tClass) throws Exception {
        Method[] declaredMethods = tClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            Annotation[] annotations = declaredMethod.getAnnotations();
            for (Annotation annotation : annotations) {
                Class<? extends Annotation> anoClass = annotation.annotationType();
                System.out.println("Values:" + anoClass.getName());
                for (Method anoMethod : anoClass.getDeclaredMethods()) {
                    Object value = anoMethod.invoke(annotation, (Object[]) null);
                    System.out.println(" " + anoMethod.getName() + ":" + JSON.toJSONString(value));
                }
            }
        }
    }




}
