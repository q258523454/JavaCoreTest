package designmode.observe.jdkinner.entity;

import java.util.Observable;
import java.util.Observer;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-21
 */
public class User implements Observer {

    private String name;

    private Observable sever;

    public User(String name, Observable sever) {
        this.name = name;
        this.sever = sever;
        sever.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        WechatServer wechatServer = (WechatServer) o;
        String newMsg = wechatServer.getMessage();
        System.out.println(name + "收到消息:" + newMsg);
    }
}
