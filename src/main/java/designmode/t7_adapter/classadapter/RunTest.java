package designmode.t7_adapter.classadapter;

import designmode.t7_adapter.classadapter.adapter.Adapter;
import designmode.t7_adapter.classadapter.service.Ps4;

public class RunTest {
    public static void main(String[] args) {
        Ps4 ps4 = new Adapter();
        ps4.playGame();
    }
}
