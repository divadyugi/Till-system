package UI;

import ButtonFunctions.AddToList;
import Objects.Item;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;


public class UI extends Application {

    BorderPane border;
    HBox top;
    Button foodButton;
    Button drinkButton;
    VBox right;
    ListView<String>list;
    GridPane center;
    HBox bottom;
    ArrayList<Item> starterItems;
    ArrayList<Button> starterButtons;
    ArrayList<Item> mainItems;
    ArrayList<Item> dessertItems;
    ArrayList<Item> sideItems;
    Button starter;
    Button main;
    Button dessert;
    Button sides;
    boolean starters;
    boolean mains;

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

    }

    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("TillSystem");

        createStarterItems();


        top = new HBox();
        foodButton= new Button("Food");
        foodButton.setScaleX(1.5d);
        drinkButton = new Button("Drinks");
        drinkButton.setScaleX(1.5d);
        top.getChildren().addAll(foodButton, drinkButton);

        right = new VBox(10);
        list = new ListView<>();
        right.getChildren().add(list);

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

        starterButtons = new ArrayList<>();


        for(int i =0; i<starterItems.size(); i++){
            starterButtons.add(new Button(starterItems.get(i).getName()));
            int x = i;
            starterButtons.get(i).setOnAction(e -> AddToList.newWindow(starterItems.get(x),list));
        }
        center.addRow(0,starter,main,dessert,sides);

        //center.addRow(1,starterButtons.get(0));
        border.setCenter(center);

        Scene scene = new Scene(border, 600, 500);
        stage.setScene(scene);
        stage.show();

    }

    public void addStarterButtons(){
        if(!starters) {
        center.getChildren().clear();
        center.addRow(0,starter,main,dessert,sides);

            for (int i = 0; i < starterButtons.size() / 2; i++) {
                center.addRow(1, starterButtons.get(i));
            }
            for (int i = starterButtons.size() / 2; i < starterButtons.size(); i++) {
                center.addRow(2, starterButtons.get(i));
            }
            starters=true;
            mains=false;
        }
    }

    public void addMainButtons(){
        if(!mains){
        center.getChildren().clear();
        center.addRow(0,starter,main,dessert,sides);
            for (int i = 0; i < starterButtons.size() / 2; i++) {
                center.addRow(1, starterButtons.get(i));
            }
            for (int i = starterButtons.size() / 2; i < starterButtons.size(); i++) {
                center.addRow(2, starterButtons.get(i));
            }
            mains=true;
            starters = false;
        }
    }

}
