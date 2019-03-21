package designmode.observe.selfimplement.entity;

import designmode.observe.selfimplement.Observer;
import designmode.observe.selfimplement.Observerable;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-21
 */
public class User implements Observer {


    private String name;

    private String message;

    private Observerable server;


    public User(String name) {
        this.name = name;
    }

    public User(String name, WechatServer server) {
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
