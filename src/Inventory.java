import java.util.ArrayList;
import java.util.List;

public class Inventory {

    List<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void add(Item item) {
        items.add(item);
    }

    public void updateInventory() {
        List<Item> itemsToRemove = new ArrayList<>();
        for(Item item : items) {

            if(item.timeInStore == 3 || item.timeInStore == 10) {
                if(item.name == "Dairy" || item.name == "Bread" || item.name == "Fruit") {
                    item.price /= 0.9;
                }
            } else if(item.timeInStore == 10) {
                if(item.name == "Bread") {
                    item.price /= 0.9;
                }
            } else if (item.timeInStore > 6) {
                if (item.name == "Dairy") {
                    item.price /= 0.75;
                }
            } else if (item.timeInStore > 13) {
                if(item.name == "Bread") {
                    item.price /= 0.75;
                }
            } else if (item.timeInStore > 4) {
                if(item.name == "Fruit") {
                    item.price /= 0.75;
                }
            }
            if(item.name == "Dairy" || item.name == "Fruit" || item.name == "Bread") {
                item.timeInStore++;
            }

            if(item.timeInStore == 3) {
                if(item.name == "Dairy" || item.name == "Bread" || item.name == "Fruit") {
                    item.price *= 0.9;
                }
            } else if(item.timeInStore == 10) {
                if(item.name == "Bread") {
                    item.price *= 0.9;
                }
            } else if (item.timeInStore > 13) {
                if(item.name == "Bread") {
                    if(item.timeInStore > 14) {
                        itemsToRemove.add(item);
                    }
                    item.price *= 0.75;
                }
            } else if (item.timeInStore > 6) {
                if (item.name == "Dairy") {
                    if(item.timeInStore > 7) {
                        itemsToRemove.add(item);
                    }
                    item.price *= 0.75;
                }
            } else if (item.timeInStore > 4) {
                if(item.name == "Fruit") {
                    if(item.timeInStore > 5) {
                        itemsToRemove.add(item);
                    }
                    item.price *= 0.75;
                }
            }
        }

        for(Item item: itemsToRemove) {
            items.remove(item);
        }
    }
}
