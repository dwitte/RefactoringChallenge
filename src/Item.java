import java.util.Date;

public class Item {

    int timeInStore;
    String name;
    int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
        this.timeInStore = 0;
    }
}
