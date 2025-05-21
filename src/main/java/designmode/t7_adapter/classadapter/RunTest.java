package designmode.t7_adapter.classadapter;

import designmode.t7_adapter.classadapter.adapter.Adapter;
import designmode.t7_adapter.classadapter.service.Ps4;

public class RunTest {
    public static void main(String[] args) {
        // 适配器模式(类适配器), 对象适配器参考 objectadapter
        Ps4 ps4 = new Adapter();
        ps4.playGame();
    }
}
