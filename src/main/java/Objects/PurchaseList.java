package Objects;

import java.util.ArrayList;
import java.util.List;

public class PurchaseList {

    private List<Item> items;
    private float total;

    public PurchaseList(){
        items = new ArrayList<>();
    }

    public void addItem(String name, float price, int quantity){
        Item item = new Item(name, price);
        item.setQuantity(quantity);
        items.add(item);
    }

    public void addDrinkItem(String name, float price, int quantity, String type){
        Item item = new Item(name,price,type);
        item.setQuantity(quantity);
    }

    public void printAllItems(){
        for(Item item:items){
            System.out.println(item.toString());
        }
    }

    public void removeItem(Item itemToRemove){
        for(Item item:items){
            if(itemToRemove.getName().equals(item.getName()) && itemToRemove.getQuantity()==item.getQuantity()){
                items.remove(item);
            }
        }
    }

    public float calculateTotalPrice(){
        for(Item item:items){
            total+=item.calculateTotal();
        }
        return total;
    }

    public List<Item> getItems(){
        return items;
    }

}
