package Objects;

public class Item {

    private String name;
    private float price;
    private int quantity;

    public Item(String name, float price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return (name + " "  + " £" + price+" "+quantity+" Total: £"+price*quantity);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float calculateTotal(){
        return quantity*price;
    }
}
