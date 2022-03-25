package designmode.t11_observe.selfimplement.entity;

import designmode.t11_observe.selfimplement.Book;
import designmode.t11_observe.selfimplement.Reader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-21
 */
public class BookServer implements Book {

    // 面向接口编程
    private List<Reader> list;

    private String message;

    public BookServer() {
        list = new ArrayList<Reader>();
    }

    @Override
    public void addObserver(Reader reader) {
        list.add(reader);
    }

    @Override
    public void deleteObserver(Reader reader) {
        if (!list.isEmpty()) {
            list.remove(reader);
        }
    }

    @Override
    public void notifyObserver() {
        for (Reader reader : list) {
            reader.receiveMessage(message);
        }
    }

    public void sendMessage(String msg) {
        this.message = msg;
        System.out.println("书籍消息:" + msg);
        notifyObserver();
    }
}
