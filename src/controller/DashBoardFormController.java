package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBoardFormController {
    public AnchorPane root;

    public void OpenCustomerManagementOnAction(ActionEvent actionEvent) throws IOException {
        setUi("CustomerForm");
    }

    public void openItemManagementOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ItemForm");
    }

    public void openOrderManagementOnAction(ActionEvent actionEvent) throws IOException {
        setUi("OrderDetailsForm");

    }

    public void openPlaceManagamentOnAction(ActionEvent actionEvent) throws IOException {
        setUi("PalaceOrderForm");
    }

    public void setUi(String location) throws IOException {
        Stage stage= (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));



    }
}
