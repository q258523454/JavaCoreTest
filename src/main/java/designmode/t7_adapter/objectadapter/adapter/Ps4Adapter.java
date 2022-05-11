package designmode.t7_adapter.objectadapter.adapter;

import designmode.t7_adapter.objectadapter.service.Ps4;
import designmode.t7_adapter.objectadapter.service.Usb;
import lombok.extern.slf4j.Slf4j;


// PS4接口的适配器
@Slf4j
public class Ps4Adapter implements Ps4 {

    /**
     * PS4适配器,带有USB功能
     */
    private Usb usb;

    public Ps4Adapter(Usb usb) {
        this.usb = usb;
    }

    @Override
    public void playGame() {
        usb.useUsb();
        log.info("Start play PS4.");
    }
}

