package designmode.build;

import designmode.build.entity.MobilePhone;
import designmode.build.service.BuildPhone;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-22
 */
public class IphoneX implements BuildPhone {

    private MobilePhone mobilePhone;

    public IphoneX() {
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
