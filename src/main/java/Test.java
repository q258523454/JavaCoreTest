import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import util.StringUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.BlockingQueue;

@Slf4j
public class Test {

    public static void main(String[] args) {
        test(null);

    }

    public static void test(String a) {
        System.out.println(a);
        assert a != null : "123";
        System.out.println(a);
    }


}
