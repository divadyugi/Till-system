package ButtonFunctions;

import Objects.Item;
import Objects.PurchaseList;
import UI.UI;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AddToList {

    public static void newWindow(Item item,ListView<String> list, PurchaseList purchaseList, UI ui ){
        Stage stage = new Stage();
        stage.setTitle("Quantity selector");
        HBox tileset = new HBox();
        Label itemName=  new Label(item.getName());
        Spinner<Integer> quantityChooser = new Spinner<>(1,100,1,1);
        Button  addButton = new Button("Add item");
        addButton.setOnAction(event -> {item.setQuantity(quantityChooser.getValue());
        AddItem(item, list,stage, purchaseList);
        ui.updateTotalAmount();
        });
        tileset.getChildren().addAll(itemName, quantityChooser,addButton);

        Scene scene = new Scene(tileset,300, 100);
        stage.setScene(scene);

        stage.show();
    }

    public static void newAlcoholicWindow(Item item, ListView<String>list,PurchaseList purchaseList, UI ui){
        Stage stage = new Stage();
        stage.setTitle("Mixer selection");
        GridPane gridPane = new GridPane();

    }

    public static void AddItem(Item item, ListView<String> list, Stage stage, PurchaseList purchaseList){

        list.getItems().add(item.toString());
        purchaseList.addItem(item.getName(),item.getPrice(),item.getQuantity());
        stage.close();
    }

    private static void addMixers(GridPane gridPane){
    }

}
