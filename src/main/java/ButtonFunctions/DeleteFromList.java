package ButtonFunctions;

import Objects.Item;
import Objects.PurchaseList;
import UI.UI;
import javafx.scene.control.ListView;

import javax.swing.*;

public class DeleteFromList {

    public static void deleteItem(ListView<String> list, PurchaseList purchaseList, UI ui){
        try {
            Item itemToRemove = purchaseList.getItems().get(list.getSelectionModel().getSelectedIndex());

            list.getItems().remove(list.getSelectionModel().getSelectedIndex());
            ui.setTotalAmount(ui.getTotalAmount() - itemToRemove.calculateTotal());
            ui.updateLabel();
            purchaseList.removeItem(itemToRemove);
        }catch(IndexOutOfBoundsException error){
            JOptionPane.showMessageDialog(null ,"Please select an item in the list you wish to delete");
        }

    }
}
