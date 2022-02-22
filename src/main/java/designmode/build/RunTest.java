package designmode.build;

import com.alibaba.fastjson.JSONObject;
import designmode.build.service.Director;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-22
 */
public class RunTest {
    public static void main(String[] args) {
        // 建造者模式
        System.out.println(JSONObject.toJSONString(new Director().createMobilePhone(new IphoneX())));
    }
}
