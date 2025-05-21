package designmode.t10_chain.service;


public interface WorkInterceptor {

    /**
     * 打卡签到
     */
    void punchIn();

    /**
     * 具体工作内容(必须实现)
     */
    void doWork();

    /**
     * 打卡签退, default 可以不用实现, 默认完成签退.
     */
    default void punchOut() {
        System.out.println(this.getClass().getSimpleName() + ":默认签退");
    }

    ;

}
