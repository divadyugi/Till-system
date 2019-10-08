package ButtonFunctions;

import Objects.Item;
import javafx.scene.control.ListView;

public class AddFood  {

    public static void AddFood(String name, int price, int quantity, ListView<String> list){
        Item item = new Item(name, price, quantity);

    }
}
