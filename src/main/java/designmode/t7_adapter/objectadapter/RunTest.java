package designmode.t7_adapter.objectadapter;


import designmode.t7_adapter.objectadapter.adapter.Ps4Adapter;
import designmode.t7_adapter.objectadapter.service.Ps4;
import designmode.t7_adapter.objectadapter.service.Usb;
import designmode.t7_adapter.objectadapter.service.UsbImpl;

public class RunTest {
    public static void main(String[] args) {
        // Usb接口
        Usb usb = new UsbImpl();
        // 适配器模式(对象适配器)
        Ps4 ps4 = new Ps4Adapter(usb);
        ps4.playGame();

    }
}
