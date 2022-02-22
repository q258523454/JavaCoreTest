package designmode.adapter.classadapter;

import designmode.adapter.classadapter.adapter.Adapter;
import designmode.adapter.classadapter.service.Ps2;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-21
 */
public class RunTest {
    public static void main(String[] args) {
        Ps2 ps2 = new Adapter();
        ps2.printPs2();
    }
}
