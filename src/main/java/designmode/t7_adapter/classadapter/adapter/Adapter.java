package designmode.t7_adapter.classadapter.adapter;

import designmode.t7_adapter.classadapter.service.Ps4;
import designmode.t7_adapter.classadapter.service.UsbImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Adapter extends UsbImpl implements Ps4 {

    /**
     * 适配器功能: Ps4支持USB功能
     * 第一:适配器要有USB的功能, extends usb
     * 第二:适配器能识别Ps4, implements ps4
     */
    @Override
    public void playGame() {
        useUsb();
        log.info("Start play PS4.");
    }
}

