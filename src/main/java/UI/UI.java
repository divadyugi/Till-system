package UI;

import ButtonFunctions.AddFood;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class UI extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("TillSystem");

        HBox top = new HBox();
        Button buttonOne= new Button("Food");
        buttonOne.setScaleX(1.5d);
        buttonOne.setAlignment(Pos.CENTER);
        Button buttonTwo = new Button("Drinks");
        buttonTwo.setScaleX(1.5d);
        buttonTwo.setAlignment(Pos.CENTER);
        top.getChildren().addAll(buttonOne, buttonTwo);

        VBox right = new VBox(10);
        ListView<String> list = new ListView<>();
        right.getChildren().add(list);

        //buttonOne.setOnAction(e -> AddFood.AddFood("Steak and Kidney pudding", 1, list));

        BorderPane border = new BorderPane();

        border.setTop(top);
        top.setSpacing(30);
        border.setRight(right);

        Scene scene = new Scene(border, 600, 500);
        stage.setScene(scene);
        stage.show();

    }

}
