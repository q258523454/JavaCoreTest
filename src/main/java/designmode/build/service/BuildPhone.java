package designmode.build.service;

import designmode.build.entity.MobilePhone;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-22
 */
public interface BuildPhone {

    void buildScreen();

    void buildBattery();

    void buildCpu();

    MobilePhone build();
}
