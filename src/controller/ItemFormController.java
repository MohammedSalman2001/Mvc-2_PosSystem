package controller;

import bo.custom.ItemBo;
import bo.factory.BoFactory;
import com.jfoenix.controls.JFXButton;

import dto.ItemDto;
import javafx.collections.FXCollections;
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
import java.util.List;
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


ItemBo itemBo= BoFactory.getDaoFactory().getBo(BoFactory.BoType.ITEM);

public void initialize() throws SQLException, ClassNotFoundException {
    colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
    colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
    colUnitePrice.setCellValueFactory(new PropertyValueFactory<>("unitePrice"));
    colQTYONHand.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
    colOptions.setCellValueFactory(new PropertyValueFactory<>("btn"));

    searchItem(searchText);

    tblItem.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
        if(newValue!=null){
            txtCode.setText(newValue.getCode());
            txtDescription.setText(newValue.getDescription());
            txtUnitePrice.setText(String.valueOf(newValue.getUnitePrice()));
            txtQTYOnHand.setText(String.valueOf(newValue.getQtyOnHand()));
            saveItem.setText("Update Item");
        }
    });

   txtSearchItem.textProperty().addListener((observable, oldValue, newValue) -> {
       searchText=newValue;
       try {
           searchItem(searchText);
       } catch (SQLException | ClassNotFoundException e) {
           e.printStackTrace();
       }
   });
}

    public void btnBackToHomeAction(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/DashBoardForm.fxml"))));



    }

    public void AddNewItem(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {



    }

    public void saveItemOnAction(ActionEvent actionEvent) {
        ItemDto itemDto = new ItemDto(txtCode.getText(),txtDescription.getText(),Double.parseDouble(txtUnitePrice.getText()),Integer.parseInt(txtQTYOnHand.getText()));

        if(saveItem.getText().equals("Save Item")){
            try{
                boolean isSaved = itemBo.saveItem(itemDto);
                if (isSaved){
                    searchItem(searchText);
                    clearItem();
                    new Alert(Alert.AlertType.INFORMATION,"Item Added").show();
                }else{
                    new Alert(Alert.AlertType.WARNING,"Try Again").show();

                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {

            try {
                boolean isUpdate = itemBo.updateItem(itemDto);
                if(isUpdate){
                    searchItem(searchText);
                    clearItem();
                    new Alert(Alert.AlertType.INFORMATION,"Customer Update").show();
                }else {
                    new Alert(Alert.AlertType.WARNING,"Try again").show();
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }



    }

    public void searchItem(String searchText) throws SQLException, ClassNotFoundException {
    String text="%"+searchText+"%";

        try{
            ObservableList<ItemTm> observableList= FXCollections.observableArrayList();
            List<ItemDto> itemDtos = itemBo.searchItem(text);
            for(ItemDto dto:itemDtos){
                Button button=new Button("Delete");
                ItemTm itemTm = new ItemTm(
                        dto.getCode(),
                        dto.getDescription(),
                        dto.getUnitePrice(),
                        dto.getQtyOnHand(),
                        button
                );

                observableList.add(itemTm);

                button.setOnAction(event -> {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Doy want Delete", ButtonType.YES, ButtonType.NO);
                    Optional<ButtonType> buttonType = alert.showAndWait();
                    if(buttonType.get().equals(ButtonType.YES)){
                        try {
                            boolean isDelete = itemBo.deleteItem(itemTm.getCode());
                            if(isDelete){
                                searchItem(searchText);
                                new Alert(Alert.AlertType.INFORMATION,"Item Delete").show();
                            }else {
                                new Alert(Alert.AlertType.WARNING,"Try Again").show();
                            }
                        } catch (SQLException | ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }

                });
            }

            tblItem.setItems(observableList);
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    private void clearItem() {
        txtCode.clear();
        txtDescription.clear();
        txtUnitePrice.clear();
        txtQTYOnHand.clear();
    }

}
