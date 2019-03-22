package designmode.build.service;

import designmode.build.entity.MobilePhone;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-22
 */

// 建造者模式——指挥者
public class Director {
    public MobilePhone createMobilePhone(BuildPhone buildPhone) {
        buildPhone.buildScreen();
        buildPhone.buildBattery();
        buildPhone.buildCpu();
        return buildPhone.build();
    }
}
