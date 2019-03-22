package designmode.build;

import com.alibaba.fastjson.JSONObject;
import designmode.build.service.Director;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-22
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(JSONObject.toJSONString(new Director().createMobilePhone(new IphoneX())));
    }
}
