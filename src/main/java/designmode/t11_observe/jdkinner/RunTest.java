package designmode.t11_observe.jdkinner;

import designmode.t11_observe.jdkinner.entity.Company;
import designmode.t11_observe.jdkinner.entity.User;
import designmode.t11_observe.jdkinner.entity.WechatServer;

import java.util.Observer;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-21
 */
public class RunTest {
    public static void main(String[] args) {
        WechatServer server = new WechatServer();
        Observer user1 = new User("张三", server);
        Observer user2 = new User("李四", server);

        Company csdn = new Company("CSDN公司", server);
        Company gitHub = new Company("GitHub公司", server);

        server.sendMessgae("QQ音乐上市");
        System.out.println("--------------------------");
        // 张三取消关注
        server.deleteObserver(user1);
        // CSDN公司 取消关注
        server.deleteObserver(csdn);
        server.sendMessgae("王者荣耀停机公告");
    }
}
