package designmode.observe.selfimplement;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-21
 */
public interface Observerable {
    void addObserver(Observer observer);

    void deleteObserver(Observer observer);

    void notifyObserver();
}
