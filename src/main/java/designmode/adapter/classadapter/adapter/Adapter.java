package designmode.adapter.classadapter.adapter;

import designmode.adapter.classadapter.service.Ps2;
import designmode.adapter.classadapter.service.UsbImpl;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-21
 */

// 适配器功能: Ps2使用USB接口
// 第一:适配器要有USB的功能, extends usb
// 第二:适配器能识别Ps2, implements ps2
public class Adapter extends UsbImpl implements Ps2 {
    @Override
    public void printPs2() {
        printUsb();
    }
}

