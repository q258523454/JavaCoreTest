package designmode.t6_builder;

import com.alibaba.fastjson.JSONObject;
import designmode.t6_builder.entity.MobilePhone;
import designmode.t6_builder.service.PhoneService;
import designmode.t6_builder.service.impl.PhoneServiceImpl;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-22
 */
public class RunTest {
    public static void main(String[] args) {
        /**
         * 建造者模式 vs 外观(门面)模式
         * 外观模式是结构型, 直接通过类方法进行组装.
         * 建造模式是创建型, 通过调用统一接口进行组装.
         */
        Builder builder = new Builder();
        // 定义 iphoneX 机型
        PhoneService iphoneX = new PhoneServiceImpl();
        // 生产 iphoneX
        MobilePhone mobilePhone = builder.createMobilePhone(iphoneX);
        System.out.println(JSONObject.toJSONString(mobilePhone));
    }
}
