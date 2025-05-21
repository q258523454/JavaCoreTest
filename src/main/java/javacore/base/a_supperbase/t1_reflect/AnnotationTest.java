package javacore.base.a_supperbase.t1_reflect;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.fastjson.JSON;

import javacore.base.a_supperbase.t1_reflect.newinstance.Student;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.ObjectUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;


@Slf4j
public class AnnotationTest {


    public static final Map<String, String> FILED_ANNOTATION_VALUE_MAP = initFiledAnnotationValueMap(Student.class);

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        log.info(Student.Fields.id);
        log.info(Student.Fields.name);
        log.info(FILED_ANNOTATION_VALUE_MAP.get(Student.Fields.id));
        log.info(FILED_ANNOTATION_VALUE_MAP.get(Student.Fields.name));
        // 修改注解的值
        changeAnnotationValue();

    }

    /**
     * 类-属性:注解和注解值
     */
    public static Map<String, String> initFiledAnnotationValueMap(Class<?> tClass) {
        Map<String, String> map = new HashMap<>();
        Field[] fields = tClass.getDeclaredFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            for (Annotation annotation : field.getAnnotations()) {
                if (annotation instanceof ExcelProperty) {
                    ExcelProperty excelProperty = (ExcelProperty) annotation;
                    String annotationValue = excelProperty.value()[0];
                    log.info("fieldName:{},ExcelProperty 注解值:{}", fieldName, excelProperty.value()[0]);
                    map.put(fieldName, annotationValue);
                }
            }
        }
        return map;
    }


    /**
     * 修改注解的值
     */
    public static void changeAnnotationValue() throws NoSuchFieldException, IllegalAccessException {
        Field[] fields = Student.class.getDeclaredFields();
        for (Field field : fields) {
            ExcelProperty excelProperty = field.getAnnotation(ExcelProperty.class);
            if (!ObjectUtils.isEmpty(excelProperty)) {
                log.info(JSON.toJSONString(excelProperty.value()));
            }
        }
        for (Field field : fields) {
            ExcelProperty excelProperty = field.getAnnotation(ExcelProperty.class);
            String[] orderValue = excelProperty.value();
            String[] newValue = new String[orderValue.length];
            for (int i = 0; i < orderValue.length; i++) {
                newValue[i] = orderValue[i] + "_new";
            }
            // 获取注解代理实例所持有的 InvocationHandler
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(excelProperty);
            // memberValues 是固定的写法, 获取 AnnotationInvocationHandler 的 memberValues 字段
            Field annotationField = invocationHandler.getClass().getDeclaredField("memberValues");
            // private修饰，打开权限
            annotationField.setAccessible(true);
            // 获取 memberValues
            Map<String, Object> memberValues = (Map) annotationField.get(invocationHandler);
            // 修改注解中的 value 属性值
            memberValues.put("value", newValue);
            // 获取 foo 的 value 属性值
            String[] value = excelProperty.value();
            if (!ObjectUtils.isEmpty(excelProperty)) {
                log.info(JSON.toJSONString(value));
            }
        }
    }
}

