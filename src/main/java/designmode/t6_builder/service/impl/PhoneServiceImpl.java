package designmode.t6_builder.service.impl;

import designmode.t6_builder.entity.MobilePhone;
import designmode.t6_builder.service.PhoneService;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-22
 */
public class PhoneServiceImpl implements PhoneService {

    private MobilePhone mobilePhone;

    public PhoneServiceImpl() {
        this.mobilePhone = new MobilePhone();
    }

    @Override
    public void buildScreen() {
        mobilePhone.setScreen("OLED显示屏");
    }

    @Override
    public void buildBattery() {
        mobilePhone.setBattery("2700mAh电池");
    }

    @Override
    public void buildCpu() {
        mobilePhone.setCpu("骁龙830");
    }

    @Override
    public MobilePhone build() {
        return mobilePhone;
    }
}
