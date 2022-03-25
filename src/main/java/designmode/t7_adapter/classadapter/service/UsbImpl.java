package designmode.t7_adapter.classadapter.service;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UsbImpl implements Usb {
    @Override
    public void useUsb() {
        log.info("使用USB接口");
    }
}
