package designmode.t7_adapter.objectadapter.service;

import lombok.extern.slf4j.Slf4j;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-21
 */
@Slf4j
public class UsbImpl implements Usb {
    @Override
    public void useUsb() {
        log.info("使用USB接口");
    }
}
