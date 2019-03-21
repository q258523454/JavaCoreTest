package designmode.observe.selfimplement.entity;

import designmode.observe.selfimplement.Observer;
import designmode.observe.selfimplement.Observerable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-21
 */
public class WechatServer implements Observerable {

    private List<Observer> list; // 面向接口编程

    private String message;


    public WechatServer() {
        list = new ArrayList<Observer>();
    }

    @Override
    public void addObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        if (!list.isEmpty()) {
            list.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : list) {
            observer.receiveMessage(message);
        }
    }

    public void sendMessage(String msg) {
        this.message = msg;
        System.out.println("微信服务器发布新消息:" + msg);
        notifyObserver();
    }
}
