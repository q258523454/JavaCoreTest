package designmode.t11_observe.selfimplement;

import designmode.t11_observe.selfimplement.entity.BookServer;
import designmode.t11_observe.selfimplement.entity.User;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-21
 */
public class RunTest {

    public static void main(String[] args) {

        BookServer server = new BookServer();

        Reader user1 = new User("张三", server);
        Reader user2 = new User("李四", server);
        Reader user3 = new User("王五", server);

        server.sendMessage("《读者》更新");
        System.out.println("--------------------------");
        // 张三取消关注
        server.deleteObserver(user1);
        server.sendMessage("《年轻人》更新");
        System.exit(0);

    }
}

