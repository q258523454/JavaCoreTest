import cn.hutool.core.codec.Base64;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test {
    public static void main(String[] args) {
        String str = "7111";
        String encode = Base64.encode(str);
        System.out.println(encode);
    }
}