package designmode.t6_builder;

import designmode.t6_builder.entity.MobilePhone;
import designmode.t6_builder.service.PhoneService;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-22
 */

// 建造者模式——指挥者
public class Builder {
    public MobilePhone createMobilePhone(PhoneService phoneService) {
        phoneService.buildScreen();
        phoneService.buildBattery();
        phoneService.buildCpu();
        return phoneService.build();
    }
}
