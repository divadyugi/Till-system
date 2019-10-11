package ButtonFunctions;

import Objects.Item;
import Objects.PurchaseList;
import UI.UI;
import javafx.geometry.Insets;
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
                AddItem(item, list, stage, purchaseList);
                ui.updateTotalAmount();
        });
        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(e -> stage.close());
        tileset.getChildren().addAll(itemName, quantityChooser,addButton, cancelButton);

        Scene scene = new Scene(tileset,300, 100);
        stage.setScene(scene);

        stage.show();
    }

    public static void newAlcoholicWindow(Item item, ListView<String>list,PurchaseList purchaseList, UI ui){

        Stage stage = new Stage();
        stage.setTitle("Mixer Selection");
        GridPane tileset = new GridPane();
        tileset.setPadding(new Insets(0,10,0,10f));
        tileset.setVgap(10);
        tileset.setHgap(20);
        Button cancelMix = new Button("Cancel");
        cancelMix.setOnAction(e -> stage.close());
        tileset.addRow(2,cancelMix);
        boolean active = true;
        newWindow(item, list, purchaseList, ui);
        addMixers(tileset,ui,list,stage,purchaseList);
        ui.updateTotalAmount();

        Scene scene = new Scene(tileset, 500, 300);
        stage.setScene(scene);
        stage.show();

    }

    public static void AddItem(Item item, ListView<String> list, Stage stage, PurchaseList purchaseList){

        list.getItems().add(item.toString());
        purchaseList.addItem(item.getName(),item.getPrice(),item.getQuantity());
        stage.close();
    }

    public static void AddNumberedItem(Item item, ListView<String>list,Stage stage, PurchaseList purchaseList){
        item.setQuantity(1);
        list.getItems().add(item.toString());
        purchaseList.addItem(item.getName(),item.getPrice(),item.getQuantity());
        stage.close();
    }

    private static void addMixers(GridPane tileset, UI ui,ListView<String>list,Stage stage, PurchaseList purchaseList){
        for(int i =0; i<ui.getSoftDrinkButtons().size()/2; i++){
            tileset.addRow(0,ui.getSoftDrinkButtons().get(i));
            int x = i;
            ui.getSoftDrinkButtons().get(i).setOnAction(e ->AddNumberedItem(ui.getSoftDrinks().get(x), list,stage,purchaseList)  );
            ui.updateTotalAmount();
            ui.updateLabel();
        }
        for(int i = ui.getSoftDrinkButtons().size()/2; i<ui.getSoftDrinkButtons().size(); i++){
            tileset.addRow(1, ui.getSoftDrinkButtons().get(i));
            int x = i;
            ui.getSoftDrinkButtons().get(i).setOnAction(e ->AddNumberedItem(ui.getSoftDrinks().get(x), list,stage,purchaseList)  );
            ui.updateTotalAmount();
        }
    }


}
