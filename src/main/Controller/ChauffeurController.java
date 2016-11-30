package main.Controller;


import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import main.Model.Chauffeur;
import main.Model.MyDate;

import java.awt.*;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by MartinNtb on 28-Nov-16.
 */
public class ChauffeurController extends Controller implements Initializable {


    public TextField fieldChauffeurAddAddress;
    public TextField fieldChauffeurAddEmail;
    public TextField fieldChauffeurAddName;
    public TextField fieldChauffeurAddPhone;
    public TextField fieldChauffeurAddId;

    public void initialize(URL location, ResourceBundle resources) {


        //add chauffeur view
        if (fieldChauffeurAddAddress != null) {
            fieldChauffeurAddAddress.focusedProperty().addListener((arg0, oldValue, newValue) -> {
                if (!newValue) { // when focus lost
                    if (fieldChauffeurAddAddress.getText().equals("xx.xx.xxxx")) {
                        fieldChauffeurAddAddress.getStyleClass().add("error");
                    } else {
                        fieldChauffeurAddAddress.getStyleClass().remove("error");
                    }
                }
            });
            fieldChauffeurAddEmail.focusedProperty().addListener((arg0, oldValue, newValue) -> {
                if (!newValue) { // when focus lost
                    if (fieldChauffeurAddEmail.getText().equals("xx.xx.xxxx")) {
                        fieldChauffeurAddEmail.getStyleClass().add("error");
                    } else {
                        fieldChauffeurAddEmail.getStyleClass().remove("error");
                    }
                }
            });
            fieldChauffeurAddName.focusedProperty().addListener((arg0, oldValue, newValue) -> {
                if (!newValue) { // when focus lost
                    if (fieldChauffeurAddName.getText().equals("xx.xx.xxxx")) {
                        fieldChauffeurAddName.getStyleClass().add("error");
                    } else {
                        fieldChauffeurAddName.getStyleClass().remove("error");
                    }
                }
            });
            fieldChauffeurAddPhone.focusedProperty().addListener((arg0, oldValue, newValue) -> {
                if (!newValue) { // when focus lost
                    if (fieldChauffeurAddPhone.getText().equals("xx.xx.xxxx")) {
                        fieldChauffeurAddPhone.getStyleClass().add("error");
                    } else {
                        fieldChauffeurAddPhone.getStyleClass().remove("error");
                    }
                }
            });
            fieldChauffeurAddId.focusedProperty().addListener((arg0, oldValue, newValue) -> {
                if (!newValue) { // when focus lost
                    if (fieldChauffeurAddId.getText().equals("xx.xx.xxxx")) {
                        fieldChauffeurAddId.getStyleClass().add("error");
                    } else {
                        fieldChauffeurAddId.getStyleClass().remove("error");
                    }
                }
            });
        }
    }

    public String[] getInput() {
        String[] input = new String[5];
        input[0] = fieldChauffeurAddName.getText();
        input[1] = fieldChauffeurAddAddress.getText();
        input[2] = fieldChauffeurAddEmail.getText();
        input[3] = fieldChauffeurAddPhone.getText();
        input[4] = fieldChauffeurAddId.getText();
        return input;
    }

    /*private void executeAdd() {
        String[] input = getInput();
        try {
            String name = input[0].trim();
            String address = input[1].trim();
            String email = input[2].trim();
            String phone = input[3].trim();
            int employeeID = Integer.parseInt(input[4].trim());

            Chauffeur chauffeur = new Chauffeur(name, address, email, phone, workedHours, isVikar);
            model.addChauffeur(chauffeur);
            *//*gui.setText("Added: " + chauffeur);
            gui.setMode(StudentGUI.SHOW_MODE);*//*
        } catch (Exception e) {
            // gui.setErrorText("Wrong input format: " + e.getMessage());
        }
    }*/


}