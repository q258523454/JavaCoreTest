package javacore.other;

/**
 * Created by mac on 17/7/21.
 */
public class EnumTest {
    public enum ErrorCodeEn {
        OK(0, "成功"),
        ERROR_A(100, "错误A"),
        ERROR_B(200, "错误B"),
        ERROR_C;

        ErrorCodeEn(){
        }
        ErrorCodeEn(int number, String description) {
            this.code = number;
            this.description = description;
        }
        private int code;
        private String description;
        public int getCode() {
            return code;
        }
        public String getDescription() {
            return description;
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.getClass().getClassLoader() + "");
        System.out.println(test.getClass().getInterfaces() + "");
    }
}
