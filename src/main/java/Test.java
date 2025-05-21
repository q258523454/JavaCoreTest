import cn.hutool.core.codec.Base64;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test {
    public static void main(String[] args) {
        String str = "7vAousDfcRj915pB0osyqQnUrQQzIRO8N-Z5xDdRTiSGfUHhHNDZGXmn0ydX2sK6CY0enm-UAisf7Us7O2UNLA";
        String encode = Base64.encode(str);
        System.out.println(encode);
    }
}