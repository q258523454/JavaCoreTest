package javacore.jdk18.optional;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

/**
 * @Date: 2019-07-24
 * @Version 1.0
 */
public class RunTest {
    public static void main(String[] args) {
        // jdk 1.7
        String s = null;
        if (null != s) {
            System.out.println("不为空");
        } else {
            System.out.println("为空");
        }

        // jdk 1.8
        String str = "";
        // 下面代码等价于 Optional.ofNullable(s).orElse("为空")
        Optional<String> os = Optional.ofNullable(s);
        if (os.isPresent()) {
            str = "不为空";
        } else {
            str = "为空";
        }
        System.out.println(str);
        System.out.println("s=null, Optional.ofNullable(s).orElse(\"为空\"): "+Optional.ofNullable(s).orElse("为空"));


        String test = Optional.ofNullable(getRequest())
                .map(request -> request.getHeader("ztest"))
                .get();
        System.out.println(test);

    }

    public static HttpServletRequest getRequest() {
        HttpServletRequest request = null;
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        if (ra != null) {
            ServletRequestAttributes sra = (ServletRequestAttributes) ra;
            request = sra.getRequest();
        }
        return request;
    }


}
