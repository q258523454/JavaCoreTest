package designmode.t6_builder.service;

import designmode.t6_builder.entity.MobilePhone;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-22
 */
public interface PhoneService {

    void buildScreen();

    void buildBattery();

    void buildCpu();

    MobilePhone build();
}
