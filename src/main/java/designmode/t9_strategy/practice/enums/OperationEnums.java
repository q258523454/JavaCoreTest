package designmode.t9_strategy.practice.enums;

public enum OperationEnums {

    ADD("add", "加法"),
    SUBTRACT("subtract", "减法"),
    ;

    private final String code;
    private final String desc;

    OperationEnums(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static OperationEnums parse(String code) {
        for (OperationEnums item : values()) {
            if (item.code.equals(code)) {
                return item;
            }
        }
        throw new RuntimeException("无法匹配正确的枚举类型");
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
