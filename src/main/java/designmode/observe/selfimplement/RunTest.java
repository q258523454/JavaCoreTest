package designmode.observe.selfimplement;

import designmode.observe.selfimplement.entity.User;
import designmode.observe.selfimplement.entity.BookServer;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-21
 */
public class RunTest {

    public static void main(String[] args) {

        BookServer server = new BookServer();

        Reader user1 = new User("张三");
        Reader user2 = new User("李四");
        Reader user3 = new User("王五");
        server.addObserver(user1);
        server.addObserver(user2);
        server.addObserver(user3);

        server.sendMessage("《读者》更新");
        System.out.println("--------------------------");
        server.deleteObserver(user1); // 张三取消关注
        server.sendMessage("《年轻人》更新");
        System.exit(0);

    }
}

