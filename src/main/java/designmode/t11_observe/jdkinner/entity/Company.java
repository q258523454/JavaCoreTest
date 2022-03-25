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
public class Company implements Observer {

    private String name;

    private Observable server;

    public Company(String name, Observable server) {
        this.name = name;
        this.server = server;
        server.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof String) {
            log.info(name + "收到[" + server.getClass().getSimpleName() + "]消息:" + arg);
        }
        WechatServer wechatServer = (WechatServer) o;
        String newMsg = wechatServer.getMessage();
        log.info(name + "详情:" + newMsg);
    }
}
