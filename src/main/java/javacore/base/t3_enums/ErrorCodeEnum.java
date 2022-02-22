package javacore.base.t3_enums;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum ErrorCodeEnum {

    /**
     * 成功
     */
    OK("0", "成功"),
    /**
     * 错误A
     */
    ERROR_A("100", "错误A"),
    /**
     * 错误B
     */
    ERROR_B("200", "错误B");

    private static final Logger logger = LoggerFactory.getLogger(ErrorCodeEnum.class);

    ErrorCodeEnum(String number, String desc) {
        this.code = number;
        this.desc = desc;
    }

    private String code;
    private String desc;

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    /**
     * 判断字段是否存在枚举类中
     */
    public static ErrorCodeEnum parse(String code) {
        for (ErrorCodeEnum entity : values()) {
            if (StringUtils.equals(entity.code, code)) {
                return entity;
            }
        }
        throw new RuntimeException("error");
    }
}
