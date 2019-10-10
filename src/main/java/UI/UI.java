package UI;

import ButtonFunctions.AddToList;
import ButtonFunctions.DeleteFromList;
import Objects.Item;
import Objects.PurchaseList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;


public class UI extends Application {

    BorderPane border;
    HBox top;
    Button foodButton;
    Button drinkButton;

    VBox right;
    PurchaseList purchaseList;
    ListView<String>list;

    GridPane center;
    ArrayList<Item> starterItems;
    ArrayList<Button> starterButtons;
    ArrayList<Item> mainItems;
    ArrayList<Button> mainButtons;
    ArrayList<Item> dessertItems;
    ArrayList<Item> sideItems;
    Button starter;
    Button main;
    Button dessert;
    Button sides;

    Button softDrink;
    ArrayList<Item> softDrinks;
    ArrayList<Button> softDrinkButtons;
    Button alcoholicDrink;
    Button beer;
    Button brandy;
    Button rum;
    Button whisky;

    boolean starters;
    boolean mains;

    VBox bottom;
    Label total;
    float totalAmount;

    private void createStarterItems(){
        starterItems = new ArrayList<>();
        Item arancini = new Item("Arancini", 5.99f);
        starterItems.add(arancini);
        Item bruschetta = new Item("Bruschetta", 5.19f);
        starterItems.add(bruschetta);
        Item bufala = new Item("Bufala caprese", 6.19f);
        starterItems.add(bufala);
        Item calamari = new Item("Calamari", 5.95f);
        starterItems.add(calamari);
        Item salmon = new Item("Salmon canape", 5.95f);
        starterItems.add(salmon);
        Item canape = new Item("Tomato canape", 5.25f);
        starterItems.add(canape);
        Item tomatoSalad = new Item("Tomato salad", 5.25f);
        starterItems.add(tomatoSalad);
        Item panzanella = new Item("Panzanella", 5.95f);
        starterItems.add(panzanella);
    }

    private void createMainItems(){
        mainItems = new ArrayList<>();
       Item salmon = new Item("Salmon", 13.75f);
        mainItems.add(salmon);
        Item chicken = new Item("Chicken prosciutto", 12.75f);
        mainItems.add(chicken);
        Item arrabiatta = new Item("Penne arrabiatta", 10.75f);
        mainItems.add(arrabiatta);
        Item carbonara = new Item("spaghetti carbonara", 10.75f);
        mainItems.add(carbonara);
        Item lasagne = new Item("Lasagne", 11.75f);
        mainItems.add(lasagne);
        Item ravioli = new Item("Ravioli", 11.75f);
        mainItems.add(ravioli);
        Item frutti = new Item("Frutti di mare", 11.75f);
        mainItems.add(frutti);
        Item risotto = new Item("Risotto pollo", 10.75f);
        mainItems.add(risotto);


    }
    private void createSoftDrinks(){
        softDrinks = new ArrayList<>();
        Item pepsi = new Item("Pepsi", 1,"soft");
        softDrinks.add(pepsi);
        Item pepsiMax = new Item("Pepsi max", 1, "soft");
        softDrinks.add(pepsiMax);
        Item sprite = new Item("Sprite", 1, "soft");
        softDrinks.add(sprite);
        Item tonic = new Item("Tonic", 1,"soft");
        softDrinks.add(tonic);
        Item gingerAle = new Item("Ginger Ale", 1, "soft");
        softDrinks.add(gingerAle);
        Item apple = new Item("Apple Juice", 1, "soft");
        softDrinks.add(apple);
        Item pineapple = new Item("Pineapple juice", 1, "soft");
        softDrinks.add(pineapple);
        Item orange = new Item("Orange juice", 1, "soft");
        softDrinks.add(orange);
    }

    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("TillSystem");

        createStarterItems();
        createMainItems();

        createSoftDrinks();


        top = new HBox();
        foodButton= new Button("Food");
        foodButton.setScaleX(1.5d);
        foodButton.setOnAction(e -> addFoodChoices() );
        drinkButton = new Button("Drinks");
        drinkButton.setScaleX(1.5d);
        drinkButton.setOnAction(e -> addDrinkChoices() );
        top.getChildren().addAll(foodButton, drinkButton);

        right = new VBox(10);
        purchaseList = new PurchaseList();
        list = new ListView<>();
        Button clear = new Button("Clear");
        clear.setOnAction(e -> DeleteFromList.deleteItem(list,purchaseList,this));
        right.getChildren().add(list);
        right.getChildren().add(clear);

        //buttonOne.setOnAction(e -> AddFood.AddFood("Steak and Kidney pudding", 1, list));

        border = new BorderPane();

        border.setTop(top);
        top.setSpacing(80);

        border.setRight(right);

        center = new GridPane();
        center.setPadding(new Insets(0,10,0,10f));
        center.setVgap(10);
        center.setHgap(20);

         starter = new Button("Starter");
        starter.setOnAction(e -> addStarterButtons() );
        starter.setScaleX(1.25);

         main = new Button("Main");
         main.setOnAction(e -> addMainButtons() );
        main.setScaleX(1.25f);

         dessert = new Button("Dessert");
        dessert.setScaleX(1.25f);

         sides = new Button("Sides");
        sides.setScaleX(1.25f);

        softDrink = new Button("Soft");
        softDrink.setScaleX(1.25f);
        softDrink.setOnAction(e -> addSoftDrinkButtons() );

        alcoholicDrink = new Button("Alcoholic");
        alcoholicDrink.setScaleX(1.25f);
        alcoholicDrink.setOnAction(e -> addAlcoholChoices() );

        beer = new Button("Beer");
        brandy = new Button("Brandy");
        rum = new Button("Rum");
        whisky = new Button("Whisky");

        starterButtons = new ArrayList<>();
        mainButtons = new ArrayList<>();

        for(int i =0; i<starterItems.size(); i++){
            starterButtons.add(new Button(starterItems.get(i).getName()));
            int x = i;
            starterButtons.get(i).setOnAction(e -> {
                AddToList.newWindow(starterItems.get(x),list, purchaseList, this);
                updateTotalAmount();
            });
        }

        for(int i =0; i<mainItems.size(); i++){
            mainButtons.add(new Button(mainItems.get(i).getName()));
            int x = i;
            mainButtons.get(i).setOnAction(e ->
                AddToList.newWindow(mainItems.get(x), list, purchaseList,this));
        }

        softDrinkButtons = new ArrayList<>();

        for(int i = 0; i<softDrinks.size(); i++){
            softDrinkButtons.add(new Button(softDrinks.get(i).getName()));
            int x = i;
            softDrinkButtons.get(i).setOnAction(e -> AddToList.newWindow(softDrinks.get(x),list,purchaseList,this));
        }


        //center.addRow(1,starterButtons.get(0));
        border.setCenter(center);

        bottom = new VBox(10);
        totalAmount = 0;
        total = new Label("Total: "+ totalAmount);
        total.setFont(new Font("Arial", 30));

        bottom.getChildren().add(total);

        border.setBottom(bottom);

        Scene scene = new Scene(border, 600, 500);
        stage.setScene(scene);
        stage.show();

    }

    public void addStarterButtons(){
        center.getChildren().clear();
        center.addRow(0,starter,main,dessert,sides);

            for (int i = 0; i < starterButtons.size() / 2; i++) {
                center.addRow(1, starterButtons.get(i));
            }
            for (int i = starterButtons.size() / 2; i < starterButtons.size(); i++) {
                center.addRow(2, starterButtons.get(i));
            }
    }

    public void addMainButtons(){
        center.getChildren().clear();
        center.addRow(0,starter,main,dessert,sides);
            for (int i = 0; i < mainButtons.size() / 2; i++) {
                center.addRow(1, mainButtons.get(i));
            }
            for (int i = mainButtons.size() / 2; i < mainButtons.size(); i++) {
                center.addRow(2, mainButtons.get(i));
            }
    }

    public void updateTotalAmount(){
        totalAmount = 0;
        for(int i =0; i<purchaseList.getItems().size(); i++){
            totalAmount+=purchaseList.getItems().get(i).calculateTotal();
            total.setText("Total: £"+String.format("%.2f", totalAmount));
        }
    }

    private void addFoodChoices(){
        center.getChildren().clear();
        center.addRow(0,starter,main,dessert,sides);
    }

    private void addDrinkChoices(){
        center.getChildren().clear();
        center.addRow(0,softDrink,alcoholicDrink);
    }

    private void addSoftDrinkButtons(){
        center.getChildren().clear();
        center.addRow(0,softDrink, alcoholicDrink);
        for (int i = 0; i < softDrinkButtons.size() / 2; i++) {
            center.addRow(1, softDrinkButtons.get(i));
        }
        for (int i = mainButtons.size() / 2; i < softDrinkButtons.size(); i++) {
            center.addRow(2, softDrinkButtons.get(i));
        }
    }

    private void addAlcoholChoices(){
        center.getChildren().clear();
        center.addRow(0,softDrink,alcoholicDrink);
        center.addRow(1,beer,brandy,rum,whisky);
    }

}
