package designmode.t11_observe.jdkinner.entity;

import lombok.extern.slf4j.Slf4j;

import java.util.Observable;
import java.util.Observer;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-21
 */
@Slf4j
public class WechatServer extends Observable {

    private String message;

    public void sendMessgae(String msg) {
        this.message = msg;
        log.info("微信服务器发出通知:" + msg);
        // 第一步改变标记状态
        setChanged();
        // 只有在setChange()被调用后，notifyObservers()才会去调用update()
        notifyObservers("标题:业务通知");
    }

    public WechatServer() {
        super();
    }

    @Override
    protected synchronized void clearChanged() {
        super.clearChanged();
    }

    @Override
    public synchronized boolean hasChanged() {
        return super.hasChanged();
    }

    @Override
    public synchronized int countObservers() {
        return super.countObservers();
    }

    @Override
    protected synchronized void setChanged() {
        super.setChanged();
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
    }

    @Override
    public synchronized void deleteObserver(Observer o) {
        super.deleteObserver(o);
    }

    @Override
    public void notifyObservers() {
        super.notifyObservers();
    }

    @Override
    public void notifyObservers(Object arg) {
        super.notifyObservers(arg);
    }

    @Override
    public synchronized void deleteObservers() {
        super.deleteObservers();
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
