package designmode.observe.selfimplement;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-21
 */
public interface Book {
    void addObserver(Reader reader);

    void deleteObserver(Reader reader);

    void notifyObserver();
}
