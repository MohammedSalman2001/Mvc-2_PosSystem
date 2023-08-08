package controller;

import bo.custom.CustomerBo;
import bo.factory.BoFactory;
import com.jfoenix.controls.JFXButton;

import dto.CustomerDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;
import tm.CustomerTm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerFormController {

    public AnchorPane root;
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtSalary;
    public JFXButton saveCustomer;
    public TextField txtSearch;
    public TableView<CustomerTm> tblCustomer;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colSalary;
    public TableColumn colOptions;


    private String searchText="";


    CustomerBo customerBo= BoFactory.getDaoFactory().getBo(BoFactory.BoType.CUSTOMER);

    public void initialize() throws SQLException, ClassNotFoundException {
        colId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colOptions.setCellValueFactory(new PropertyValueFactory<>("btn"));


        searchCustomer(searchText);


        tblCustomer.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                setCustomerdetails(newValue);
            }
        });

        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
         searchText=newValue;
            try {
                searchCustomer(searchText);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });
    }

    private void setCustomerdetails(CustomerTm newValue) {
        txtId.setText(newValue.getId());
        txtName.setText(newValue.getName());
        txtAddress.setText(newValue.getAddress());
        txtSalary.setText(String.valueOf(newValue.getSalary()));
        saveCustomer.setText("Update Customer");
    }


    public void btnBackToHomeAction(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/DashBoardForm.fxml"))));
    }

    public void btnAddCustomerOnAction(ActionEvent actionEvent) {
        saveCustomer.setText("Save Customer");

    }

    public void saveCustomerOnAction(ActionEvent actionEvent) {
        CustomerDto customerDto = new CustomerDto(txtId.getText(),txtName.getText(),txtAddress.getText(),Double.parseDouble(txtSalary.getText()));

        if(saveCustomer.getText().equals("Save Customer")){

            try {
                boolean saved= customerBo.saveCustomer(customerDto);
                if(saved){
                    new Alert(Alert.AlertType.INFORMATION,"Customer Saved").show();
                    searchCustomer(searchText);
                    clearAll();
                }else {
                    new Alert(Alert.AlertType.WARNING,"try Again").show();
                }
            }catch (SQLException | ClassNotFoundException e ){
                e.printStackTrace();
            }
        }else {
            try {
                boolean isUpdate = customerBo.updateCustomer(customerDto);
                if(isUpdate){
                    new Alert(Alert.AlertType.INFORMATION,"Customer Update").show();
                    searchCustomer(searchText);
                        clearAll();
                        saveCustomer.setText("Save Customer");
                        return;
                }else {
                    new Alert(Alert.AlertType.WARNING,"try Again").show();
                }

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        }



    }

    private void searchCustomer(String searchText) throws SQLException, ClassNotFoundException {

        String search="%"+searchText+"%";
        ObservableList<CustomerTm> observableList= FXCollections.observableArrayList();

        try{
            List<CustomerDto> customerDtos = customerBo.searchCustomer(search);
            for(CustomerDto dto: customerDtos){
                Button button=new Button("Delete");
                CustomerTm customerTm = new CustomerTm(
                        dto.getId(),
                        dto.getName(),
                        dto.getAddress(),
                        dto.getSalary(),
                        button

                );
                observableList.add(customerTm);

                button.setOnAction(event -> {
                    try {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Do yo want delete", ButtonType.YES, ButtonType.NO);
                        Optional<ButtonType> buttonType = alert.showAndWait();
                        if(buttonType.get().equals(ButtonType.YES)){
                            boolean delete = customerBo.deleteCustomer(customerTm.getId());
                            if(delete){
                                new Alert(Alert.AlertType.INFORMATION,"Customer Delete").show();

                                searchCustomer(searchText);
                            }else {
                                new Alert(Alert.AlertType.WARNING,"Try Again").show();
                            }
                        }

                    } catch (SQLException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                });

            }
            tblCustomer.setItems(observableList);
        }catch (SQLException | ClassNotFoundException e){

        }

    }

    public void clearAll(){

        txtName.clear();
        txtId.clear();
        txtSalary.clear();
        txtAddress.clear();
    }

}
