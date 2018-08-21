package DataStruct.TreeSet;

/**
 * Created by mac on 17/7/24.
 */
public class Item {

    private String description;
    private int partNumber;

    public Item(String description, int partNumber) {
        this.description = description;
        this.partNumber=partNumber;
    }

    public String toString() {
        return "" + description + " " + partNumber;
    }





}
