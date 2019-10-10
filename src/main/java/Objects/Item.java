package Objects;

public class Item {

    private String name;
    private float price;
    private int quantity;
    private String type;
    private String mix;
    private float totalPrice;

    public Item(String name, float price){
        this.name = name;
        this.price = price;
    }

    public Item(String name, float price, String type){
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return (name + " "  + " £" + price+" "+quantity+" Total: £"+String.format("%.2f", quantity*price));
    }

    public String alcoholicToString(){
        return (name + " ("+mix+") "+" £"+price+" "+quantity+" Total: £"+String.format("%.2f",quantity*price));
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setMix(String mix){
        this.mix = mix;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float calculateTotal(){
        totalPrice=quantity*price;
        return quantity*price;
    }
}
