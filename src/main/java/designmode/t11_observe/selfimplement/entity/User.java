package designmode.t11_observe.selfimplement.entity;

import designmode.t11_observe.selfimplement.Reader;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-21
 */
public class User implements Reader {

    private String name;

    private String message;

    public User(String name) {
        this.name = name;
    }

    public User(String name, BookServer server) {
        this.name = name;
        server.addObserver(this); // 被观察者默认加入到服务器
    }

    @Override
    public void receiveMessage(String message) {
        this.message = message;
        readMessage();
    }

    public void readMessage() {
        System.out.println(name + "收到信息:" + message);
    }
}
