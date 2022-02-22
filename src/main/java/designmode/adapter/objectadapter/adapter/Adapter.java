package designmode.adapter.objectadapter.adapter;

import designmode.adapter.objectadapter.service.Ps2;
import designmode.adapter.objectadapter.service.Usb;
import designmode.adapter.objectadapter.service.UsbImpl;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-21
 */

// 对象适配器
public class Adapter implements Ps2 {

    private Usb usb;

    public Adapter(Usb usb) {
        this.usb = usb;
    }

    @Override
    public void printPs2() {
        usb.printUsb();
    }
}

