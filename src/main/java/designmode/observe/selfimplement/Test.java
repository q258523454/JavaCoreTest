package designmode.observe.selfimplement;

import designmode.observe.selfimplement.entity.User;
import designmode.observe.selfimplement.entity.WechatServer;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-21
 */
public class Test {

    public static void main(String[] args) {

        WechatServer server = new WechatServer();

        Observer user1 = new User("张三", server);
        Observer user2 = new User("李四", server);
        Observer user3 = new User("王五", server);
        server.sendMessage("QQ音乐上市");
        System.out.println("--------------------------");
        server.deleteObserver(user1); // 张三取消关注
        server.sendMessage("王者荣耀停机公告");

    }
}

