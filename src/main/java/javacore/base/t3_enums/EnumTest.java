package javacore.base.t3_enums;

/**
 * Created by mac on 17/7/21.
 */
public class EnumTest {

    public static void main(String[] args) {

        for (ErrorCodeEnum errorCodeEn : ErrorCodeEnum.values()) {
            System.out.println(errorCodeEn.getCode() + " " + errorCodeEn.getDesc());
        }
    }

}
