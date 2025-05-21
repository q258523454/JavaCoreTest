package designmode.t5_facade;

import designmode.t5_facade.impl.ScalperFacade;

public class ZRunTest {
    public static void main(String[] args) {
        /**
         * 外观模式: 划分访问层次,对外提供外观(门面)
         * 黄牛帮助抢票,无需关注抢票细节.
         *
         * 外观(门面)模式 vs 建造者模式
         * 外观模式是结构型, 直接通过类方法进行组装.
         * 建造模式是创建型, 通过调用统一接口进行组装.
         */
        Account xiaoMing = new Account();
        Ticket guangZhou = new Ticket();
        // 外观模式: 黄牛帮助抢票,无需关注抢票细节.
        ScalperFacade facade = new ScalperFacade(xiaoMing, guangZhou);
        facade.buy();
    }
}
