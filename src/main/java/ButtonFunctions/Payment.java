package ButtonFunctions;

import Objects.PurchaseList;
import UI.UI;
import javafx.beans.value.ChangeListener;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.function.UnaryOperator;

public class Payment {

    public static void newWindow(UI ui, ListView<String> list, PurchaseList purchaseList, VBox vBox){
        Stage stage = new Stage();
        stage.setTitle("Payment");
        VBox tileset = new VBox();
        Node originalPay = vBox.getChildren().get(1);

       TextField paymentAmount = new TextField();
        Button Accept = new Button("OK");
        Accept.setOnAction(event -> {ui.setTotalAmount(0);
           ui.updateLabel();
           list.getItems().clear();
           purchaseList.removeAllItems();
           vBox.getChildren().remove(Accept);
           vBox.getChildren().add(originalPay);
        });

        Button confirmButton = new Button("Confirm");
        confirmButton.setOnAction(e -> {
            ui.setTotalAmount(ui.getTotalAmount() - Float.valueOf(paymentAmount.getText()));
                    ui.updateLabel();
                    stage.close();
                    confirmCalculations(ui,list,purchaseList,vBox,Accept);
        });
        Button cancel = new Button("Cancel");
        cancel.setOnAction(e ->stage.close() );
        tileset.getChildren().addAll(paymentAmount,confirmButton,cancel);

        Scene scene = new Scene(tileset, 100, 100);
        stage.setScene(scene);
        stage.show();

    }

    public static void confirmCalculations(UI ui, ListView<String> list, PurchaseList purchaseList, VBox vBox, Button Accept){
        if(ui.getTotalAmount()==0) {
            ui.setTotalAmount(0.00f);
            ui.updateLabel();
            list.getItems().clear();
            purchaseList.removeAllItems();
        }else if(ui.getTotalAmount()<0){
            ui.updateLabel();
            vBox.getChildren().remove(1);
            vBox.getChildren().add(Accept);
        }
    }
}
