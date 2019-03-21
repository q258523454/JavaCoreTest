package designmode.adapter.objectadapter;


import designmode.adapter.objectadapter.adapter.Adapter;
import designmode.adapter.objectadapter.service.Ps2;
import designmode.adapter.objectadapter.service.UsbImpl;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-21
 */
public class Test {
    public static void main(String[] args) {

        Ps2 ps2 = new Adapter(new UsbImpl());
        ps2.printPs2();
        
    }
}
