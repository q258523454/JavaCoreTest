package javacore.base.a_supperbase.t1_reflect.newinstance;


import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.fastjson.annotation.JSONField;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

@Data
@FieldNameConstants
@AllArgsConstructor
public class Student {

    @ExcelProperty("身份证")
    private Integer id;

    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty("年龄")
    private Integer age;

    @JSONField(name = "ztest")
    public String test(String s) {
        return "ztest";
    }
}