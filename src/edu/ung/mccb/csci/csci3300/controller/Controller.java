package edu.ung.mccb.csci.csci3300.controller;
import edu.ung.mccb.csci.csci3300.model.Car;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    TextField txtLno,txtVin,txtMake,txtModel,txtYear;
    public void submitRecord(ActionEvent actionEvent)   {
        Car model = new Car();
        model.setLno(txtLno.getText());
        model.setVin(txtVin.getText());
        model.setMake(txtMake.getText());
        model.setModel(txtModel.getText());
        model.setYear(txtYear.getText());
        int result = model.saveCarIntoDatabase(txtLno.getText(), txtVin.getText(), txtMake.getText(), txtModel.getText(), txtYear.getText());
        System.out.println("New Vehicle Added");
    }

    }

