package UI;

import ButtonFunctions.AddToList;
import ButtonFunctions.DeleteFromList;
import ButtonFunctions.Payment;
import Objects.Item;
import Objects.PurchaseList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class UI extends Application {

    //The main layout of the program
    BorderPane border;
    //the layout and the components for the top part of the stage
    HBox top;
    Button foodButton;
    Button drinkButton;

    //the layout and the components for the right section of the stage
    VBox right;
    PurchaseList purchaseList;
    ListView<String>list;

    //the center and the components for the stage
    GridPane center;
    ArrayList<Item> starterItems;
    ArrayList<Button> starterButtons;
    ArrayList<Item> mainItems;
    ArrayList<Button> mainButtons;
    ArrayList<Item> dessertItems;
    ArrayList<Button>dessertButtons;
    ArrayList<Item> sideItems;
    ArrayList<Button> sideButtons;

    Button starter;
    Button main;
    Button dessert;
    Button sides;

    Button softDrink;
    ArrayList<Item> softDrinks;
    ArrayList<Button> softDrinkButtons;
    Button alcoholicDrink;
    Button beer;
    ArrayList<Item> beers;
    ArrayList<Button> beerButtons;
    Button brandy;
    ArrayList<Item> brandies;
    ArrayList<Button> brandyButtons;
    Button rum;
    ArrayList<Item> rums;
    ArrayList<Button> rumButtons;
    Button whisky;
    ArrayList<Item> whiskies;
    ArrayList<Button> whiskyButtons;

    //the bottom parts of the components
    VBox bottom;
    Label total;
    float totalAmount;
    Button pay;

    //The starter items in the starter section
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

    //The main items in the main section
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

    //The dessert items in the dessert section
    private void createDessertItems(){
        dessertItems = new ArrayList<>();
        Item pannaCotta = new Item("Panna Cotta",3.45f);
        dessertItems.add(pannaCotta);
        Item tiramisu = new Item("Tiramsu", 3.25f);
        dessertItems.add(tiramisu);
        Item cannoli = new Item("Cannoli", 2.99f);
        dessertItems.add(cannoli);
        Item biscotti = new Item("Biscotti", 2.99f);
        dessertItems.add(biscotti);
        Item limon = new Item("Limo torte", 3.50f);
        dessertItems.add(limon);
    }

    //The side items in the side section
    private void createSideItems(){
        sideItems = new ArrayList<>();
        Item chips = new Item("Chips", 2.35f );
        sideItems.add(chips);
        Item wedges = new Item("Potato wedges", 2.5f);
        sideItems.add(wedges);
        Item fritti = new Item("Courgette Fritti", 3);
        sideItems.add(fritti);
        Item beans = new Item("Green beans", 2.35f);
        sideItems.add(beans);

    }


    //The softdrink items in the soft drink section
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

    //The beer items in the beer section
    private void createBeers(){
        beers = new ArrayList<>();
        Item fosters = new Item("Fosters",3.25f,"beer");
        beers.add(fosters);
        Item peroni = new Item("Peroni", 3.25f, "beer");
        beers.add(peroni);
        Item moretti = new Item("Bierra moretti", 3.5f, "beer");
        beers.add(moretti);
        Item baltika = new Item("Baltika", 3.5f,"beer");
        beers.add(baltika);
    }

    //The brandy items in the brandy section
    private void createBrandies(){
        brandies = new ArrayList<>();
        Item calvados = new Item("Calvados", 5.25f, "alcohol");
        brandies.add(calvados);
        Item hennessy = new Item("Hennessy XO", 6.25f, "alcohol");
        brandies.add(hennessy);
        Item romagna = new Item("Vecchia romagna", 5.25f, "alcohol");
        brandies.add(romagna);
        Item EJ = new Item("E&J", 3.50f,"alcohol");
        brandies.add(EJ);
    }

    //The rum items in the rum section
    private void createRums(){
        rums = new ArrayList<>();
        Item barbados = new Item("Barbados", 4.25f, "alcohol");
        rums.add(barbados);
        Item ron = new Item("Ron zacapa", 5.25f, "alcohol");
        rums.add(ron);
        Item bacardi = new Item("Bacardi", 4.25f, "alcohol");
        rums.add(bacardi);
        Item limoncello = new Item("Limoncello", 3.09f, "aperitif");
        rums.add(limoncello);
    }

    //The whisky items in the whisky section
    private void createWhiskies(){
        whiskies = new ArrayList<>();
        Item chivas = new Item("Chivas regal", 5.25f, "alcohol");
        whiskies.add(chivas);
        Item jack = new Item ("Jack Daniels", 5.25f, "alcohol");
        whiskies.add(jack);
        Item jimBeam = new Item("Jim beam", 4.25f, "alcohol");
        whiskies.add(jimBeam);
        Item haig = new Item("Haig Clubman", 3.25f, "alcohol");
        whiskies.add(haig);
        Item fireball = new Item("Fireball", 4.25f, "alcohol");
        whiskies.add(fireball);
        Item glenFiddich = new Item("Glen Fiddich", 5.50f, "alcohol");
        whiskies.add(glenFiddich);
        Item disaronno = new Item("Dissarono", 5.25f, "alcohol");
        whiskies.add(disaronno);
        Item southernComfort = new Item("Southern Comfort", 5.25f, "alcohol");
        whiskies.add(southernComfort);

    }

    //The creation of the top section
    private void createTopLayer(){
        top = new HBox();
        foodButton= new Button("Food");
        foodButton.setScaleX(1.5d);
        foodButton.setOnAction(e -> addFoodChoices() );
        drinkButton = new Button("Drinks");
        drinkButton.setScaleX(1.5d);
        drinkButton.setOnAction(e -> addDrinkChoices() );
        top.getChildren().addAll(foodButton, drinkButton);
        top.setSpacing(80);

    }

    //creation of the right section
    private void createRightLayer(){
        right = new VBox(10);
        purchaseList = new PurchaseList();
        list = new ListView<>();
        Button clear = new Button("Clear");
        clear.setOnAction(e -> DeleteFromList.deleteItem(list,purchaseList,this));
        right.getChildren().add(list);
        right.getChildren().add(clear);
    }

    //creation of the bottom layer
    private void createBottomLayer(){
        bottom = new VBox(10);
        totalAmount = 0;
        total = new Label("Total: "+ totalAmount);
        total.setFont(new Font("Arial", 30));

        pay = new Button("Pay");
        pay.setScaleX(1.5);
        pay.setAlignment(Pos.CENTER_RIGHT);
        pay.setOnAction(e -> Payment.newWindow(this,list,purchaseList,bottom) );

        bottom.getChildren().addAll(total, pay);
    }




    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("TillSystem");

        //initialising the arrays containing the food items to be used for creating the buttons
        createStarterItems();
        createMainItems();
        createDessertItems();
        createSideItems();

        //Initialising the arrays containing the drink items to be used for creating the buttons
        createSoftDrinks();
        createBeers();
        createBrandies();
        createRums();
        createWhiskies();

        createTopLayer();
        createRightLayer();
        createBottomLayer();


        border = new BorderPane();

        border.setTop(top);

        border.setRight(right);



        //creating the layout of the center secton
        center = new GridPane();
        center.setPadding(new Insets(0,10,0,10f));
        center.setVgap(10);
        center.setHgap(20);


        //*************************************************Creation of the starter section***************************************************************
        starter = new Button("Starter");
        starter.setOnAction(e -> addStarterButtons() );
        starter.setScaleX(1.25);

        starterButtons = new ArrayList<>();
        for(int i =0; i<starterItems.size(); i++){
            starterButtons.add(new Button(starterItems.get(i).getName()));
            int x = i;
            starterButtons.get(i).setOnAction(e -> {
                AddToList.newWindow(starterItems.get(x),list, purchaseList, this);
                updateTotalAmount();
            });
        }

        //*********************************************************************************************************************************************

        //*************************************************Creation of the main section***************************************************************

         main = new Button("Main");
         main.setOnAction(e -> addMainButtons() );
        main.setScaleX(1.25f);

        mainButtons = new ArrayList<>();

        for(int i =0; i<mainItems.size(); i++){
            mainButtons.add(new Button(mainItems.get(i).getName()));
            int x = i;
            mainButtons.get(i).setOnAction(e ->
                    AddToList.newWindow(mainItems.get(x), list, purchaseList,this));
        }

        //*********************************************************************************************************************************************

        //*************************************************Creation of the dessert section***************************************************************

         dessert = new Button("Dessert");
         dessert.setOnAction(e -> addDessertButtons() );
        dessert.setScaleX(1.25f);

        dessertButtons = new ArrayList<>();

        for(int i =0; i<dessertItems.size(); i++){
            dessertButtons.add(new Button(dessertItems.get(i).getName()));
            int x = i;
            dessertButtons.get(i).setOnAction(e-> AddToList.newWindow(dessertItems.get(x),list,purchaseList,this) );
        }

        //*********************************************************************************************************************************************

        //*************************************************Creation of the side section***************************************************************

         sides = new Button("Sides");
        sides.setOnAction(e -> addSideButtons() );
        sides.setScaleX(1.25f);

        sideButtons = new ArrayList<>();

        for(int i =0; i<sideItems.size(); i++){
            sideButtons.add(new Button(sideItems.get(i).getName()));
            int x =i;
            sideButtons.get(i).setOnAction(e -> AddToList.newWindow(starterItems.get(x),list,purchaseList,this));
        }

        //*********************************************************************************************************************************************

        //*************************************************Creation of the side section***************************************************************

        softDrink = new Button("Soft");
        softDrink.setScaleX(1.25f);
        softDrink.setOnAction(e -> addSoftDrinkButtons() );


        softDrinkButtons = new ArrayList<>();

        for(int i = 0; i<softDrinks.size(); i++){
            softDrinkButtons.add(new Button(softDrinks.get(i).getName()));
            int x = i;
            softDrinkButtons.get(i).setOnAction(e -> AddToList.newWindow(softDrinks.get(x),list,purchaseList,this));
        }

        //*********************************************************************************************************************************************

        //*************************************************Creation of the alcoholic section***************************************************************

        alcoholicDrink = new Button("Alcoholic");
        alcoholicDrink.setScaleX(1.25f);
        alcoholicDrink.setOnAction(e -> addAlcoholChoices() );

        //*********************************************************************************************************************************************

        //*************************************************Creation of the alcoholic sub-section***************************************************************

        beer = new Button("Beer");
        beer.setOnAction(e -> addBeers() );
        brandy = new Button("Brandy");
        brandy.setOnAction(e -> addBrandies() );
        rum = new Button("Rum");
        rum.setOnAction(e -> addRums() );
        whisky = new Button("Whisky");
        whisky.setOnAction(e -> addWhiskies() );

        //*********************************************************************************************************************************************

        //*************************************************Creation of the beer sub-section***************************************************************

        beerButtons = new ArrayList<>();



        for(int i = 0; i<beers.size(); i++){
            beerButtons.add(new Button(beers.get(i).getName()));
            int x = i;
            beerButtons.get(i).setOnAction(e -> AddToList.newWindow(beers.get(x),list,purchaseList,this));
        }

        //*********************************************************************************************************************************************

        //*************************************************Creation of the whisky sub-section***************************************************************

        whiskyButtons = new ArrayList<>();

        for(int i = 0; i<whiskies.size(); i++){
            whiskyButtons.add(new Button(whiskies.get(i).getName()));
            int x = i;
            whiskyButtons.get(i).setOnAction(e -> AddToList.newAlcoholicWindow(whiskies.get(x),list,purchaseList,this));
        }

        //*********************************************************************************************************************************************

        //*************************************************Creation of the rum sub-section***************************************************************

        rumButtons = new ArrayList<>();

        for(int i = 0; i<rums.size(); i++){
            rumButtons.add(new Button(rums.get(i).getName()));
            int x = i;
            rumButtons.get(i).setOnAction(e -> AddToList.newAlcoholicWindow(rums.get(x),list,purchaseList,this));
        }

        //*********************************************************************************************************************************************

        //*************************************************Creation of the brandy sub-section***************************************************************

        brandyButtons = new ArrayList<>();

        for(int i = 0; i<brandies.size(); i++){
            brandyButtons.add(new Button(brandies.get(i).getName()));
            int x = i;
            brandyButtons.get(i).setOnAction(e -> AddToList.newAlcoholicWindow(brandies.get(x),list,purchaseList,this));
        }

        //*********************************************************************************************************************************************

        border.setCenter(center);



        border.setBottom(bottom);

        Scene scene = new Scene(border, 600, 500);
        stage.setScene(scene);
        stage.show();

    }

    //function for adding food choice buttons

    private void addFoodChoices(){
        center.getChildren().clear();
        center.addRow(0,starter,main,dessert,sides);
    }

    //function for adding drink choie buttons

    private void addDrinkChoices(){
        center.getChildren().clear();
        center.addRow(0,softDrink,alcoholicDrink);
    }

//Function for adding the starterButton option

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

//Function for adding the MainButton option

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

    //Function for adding the DessertButton option

    public void addDessertButtons(){
        center.getChildren().clear();
        center.addRow(0,starter,main,dessert,sides);
        for(int i =0 ;i<dessertButtons.size()/2; i++){
            center.addRow(1,dessertButtons.get(i));
        }
        for(int i =dessertButtons.size()/2; i<dessertButtons.size();i++){
            center.addRow(2,dessertButtons.get(i));
        }
    }

    public void addSideButtons(){
        center.getChildren().clear();
        center.addRow(0,starter,main,dessert,sides);
        for(int i = 0; i<sideButtons.size()/2; i++){
            center.addRow(1,sideButtons.get(i));
        }
        for(int i =sideButtons.size()/2; i<sideButtons.size(); i++){
            center.addRow(2,sideButtons.get(i));
        }
    }

    private void addSoftDrinkButtons(){
        center.getChildren().clear();
        center.addRow(0,softDrink, alcoholicDrink);
        for (int i = 0; i < softDrinkButtons.size() / 2; i++) {
            center.addRow(1, softDrinkButtons.get(i));
        }
        for (int i = softDrinkButtons.size() / 2; i < softDrinkButtons.size(); i++) {
            center.addRow(2, softDrinkButtons.get(i));
        }
    }

    private void addAlcoholChoices(){
        center.getChildren().clear();
        center.addRow(0,softDrink,alcoholicDrink);
        center.addRow(1,beer,brandy,rum,whisky);
    }

    private void addBeers(){
        center.getChildren().clear();
        center.addRow(0,softDrink, alcoholicDrink);
        center.addRow(1,beer, brandy,rum,whisky);
        for(int i =0; i<beerButtons.size()/2; i++){
            center.addRow(2,beerButtons.get(i));
        }
        for(int i =beerButtons.size()/2; i<beerButtons.size(); i++){
            center.addRow(3,beerButtons.get((i)));
        }
    }

    private void addWhiskies(){
        center.getChildren().clear();
        center.addRow(0,softDrink, alcoholicDrink);
        center.addRow(1,beer, brandy,rum,whisky);
        for(int i =0; i<whiskyButtons.size()/2; i++){
            center.addRow(2,whiskyButtons.get(i));
        }
        for(int i =whiskyButtons.size()/2; i<whiskyButtons.size(); i++){
            center.addRow(3,whiskyButtons.get((i)));
        }
    }

    private void addRums(){
        center.getChildren().clear();
        center.addRow(0,softDrink, alcoholicDrink);
        center.addRow(1,beer, brandy,rum,whisky);
        for(int i =0; i<rumButtons.size()/2; i++){
            center.addRow(2,rumButtons.get(i));
        }
        for(int i =rumButtons.size()/2; i<rumButtons.size(); i++){
            center.addRow(3,rumButtons.get((i)));
        }
    }

    private void addBrandies(){
        center.getChildren().clear();
        center.addRow(0,softDrink, alcoholicDrink);
        center.addRow(1,beer, brandy,rum,whisky);
        for(int i =0; i<brandyButtons.size()/2; i++){
            center.addRow(2,brandyButtons.get(i));
        }
        for(int i =brandyButtons.size()/2; i<brandyButtons.size(); i++){
            center.addRow(3,brandyButtons.get((i)));
        }
    }



    public void updateTotalAmount(){
        totalAmount = 0;
        for(int i =0; i<purchaseList.getItems().size(); i++) {
            totalAmount += purchaseList.getItems().get(i).calculateTotal();
            System.out.println(totalAmount);
            updateLabel();
        }
    }
    public void setTotalAmount(float totalAmount){
        this.totalAmount=totalAmount;
    }

    public float getTotalAmount(){
        return totalAmount;
    }

    public void updateLabel(){
        total.setText("Total: £"+String.format("%.2f",totalAmount));
    }



    public ArrayList<Button> getSoftDrinkButtons(){
        return softDrinkButtons;
    }

    public ArrayList<Item> getSoftDrinks(){
        return softDrinks;
    }

}
