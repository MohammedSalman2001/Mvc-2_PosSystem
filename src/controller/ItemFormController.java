package controller;

import com.jfoenix.controls.JFXButton;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Item;
import tm.ItemTm;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class ItemFormController {
    public AnchorPane root;
    public TextField txtCode;
    public TextField txtDescription;
    public TextField txtUnitePrice;
    public TextField txtQTYOnHand;
    public TextField txtSearchItem;
    public JFXButton saveItem;
    public TableView<ItemTm> tblItem;
    public TableColumn colCode;
    public TableColumn colDescription;
    public TableColumn colUnitePrice;
    public TableColumn colQTYONHand;
    public TableColumn colOptions;

    private String searchText="";




    public void btnBackToHomeAction(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/DashBoardForm.fxml"))));



    }

    public void AddNewItem(ActionEvent actionEvent) {



    }

    public void saveItemOnAction(ActionEvent actionEvent) {

    }

    private void clearItem() {
        txtCode.clear();
        txtDescription.clear();
        txtUnitePrice.clear();
        txtQTYOnHand.clear();
    }

}
