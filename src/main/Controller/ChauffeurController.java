package main.Controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import main.Model.BusList;
import main.Model.Chauffeur;
import main.Model.ChauffeurList;
import main.Model.MyDate;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
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
    public Button buttonAddChauffeur;
    public DatePicker birthdayPicker;
    public Button buttonDeleteChauffeur;
    public ListView listViewChauffeurList;

    public void initialize(URL location, ResourceBundle resources) {
        if (listViewChauffeurList != null) {
            try {
                listViewChauffeurList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                ChauffeurFile file = new ChauffeurFile("ChauffeurList.txt");
                ChauffeurList chauffeurlist = file.readTextFile();
                ObservableList<String> items = FXCollections.observableArrayList();
                for (int i = 0; i < chauffeurlist.getSize(); i++) {
                    items.add(chauffeurlist.getChauffeurByIndex(i).toString());
                }
                listViewChauffeurList.setItems(items);
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

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

   /* public String[] getInput() {
        String[] input = new String[5];
        input[0] = fieldChauffeurAddName.getText();
        input[1] = fieldChauffeurAddAddress.getText();
        input[2] = fieldChauffeurAddEmail.getText();
        input[3] = fieldChauffeurAddPhone.getText();
        input[4] = fieldChauffeurAddId.getText();
        return input;
    }*/

    public void addChauffeur(ActionEvent actionEvent) throws IOException {

        String alert = "There are some mistakes: ";
        int length = alert.length();

        if (!validateEmptyField(fieldChauffeurAddName)) alert += "Name, ";
        if (!validateEmptyField(fieldChauffeurAddAddress)) alert += "Address, ";
        if (!validateEmptyField(fieldChauffeurAddEmail)) alert += "Email, ";
        if (!validateEmptyField(fieldChauffeurAddPhone) || !validateNumberField(fieldChauffeurAddPhone))
            alert += "Phone, ";
        if (!validateEmptyField(fieldChauffeurAddId) || !validateNumberField(fieldChauffeurAddId))
            alert += "Employee ID, ";
        if (!validateEmptyDate(birthdayPicker)) alert += "Birthday, ";

        if (length == alert.length()) {
            //save it DataHandler. .....
            successdisplay("Success", "Chauffeur was added.");
        } else {
            //alert
            alertdisplay("Wrong Input", alert);
        }
    }


    public void deleteChauffeur(ActionEvent actionEvent) throws IOException {
        successdisplay("Success", "Chauffeur was deleted.");
    }
}