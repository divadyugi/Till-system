package ButtonFunctions;

import Objects.Item;
import Objects.PurchaseList;
import UI.UI;
import javafx.scene.control.ListView;

public class DeleteFromList {

    public static void deleteItem(ListView<String> list, PurchaseList purchaseList, UI ui){
        System.out.println(list.getSelectionModel().getSelectedIndex());
        System.out.println("List size "+purchaseList.getItems().size());
        Item itemToRemove = purchaseList.getItems().get(list.getSelectionModel().getSelectedIndex());

        list.getItems().remove(list.getSelectionModel().getSelectedIndex());
        purchaseList.removeItem(itemToRemove);
        purchaseList.printAllItems();
        ui.updateTotalAmount();
    }
}
