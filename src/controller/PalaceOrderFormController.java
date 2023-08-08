package controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class PalaceOrderFormController {
    public AnchorPane root;
    public ComboBox<String> cbmCustomerId;
    public TextField txtOrderId;
    public TextField txtDate;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtSalary;
    public ComboBox<String> cmdItemCode;
    public TextField txtDescription;
    public TextField txtUnitePrice;
    public TextField txtQTYOnHand;
    public TextField txtQTY;
    public TableView tblCart;
    public TableColumn colCode;
    public TableColumn colDescription;
    public TableColumn colUnitePrice;
    public TableColumn colQTY;
    public TableColumn colTotal;
    public TableColumn colOption;
    public Label lblTotal;
    public Label lblTotal1;

    public void placeOrderOnAction(ActionEvent actionEvent) {
    }

    public void btnAddTocardOnAction(ActionEvent actionEvent) {
    }

    public void btnBackToHomeAction(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/DashBoardForm.fxml"))));
    }
}
    

 

    
      





 
