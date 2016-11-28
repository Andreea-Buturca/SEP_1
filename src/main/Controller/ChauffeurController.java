package main.Controller;


import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import main.Model.Chauffeur;
import main.Model.MyDate;

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
    public TextField fieldChauffeurAddBirthday;
    public TextField fieldChauffeurAddId;

    public void initialize(URL location, ResourceBundle resources) {


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
        fieldChauffeurAddBirthday.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { // when focus lost
                if (fieldChauffeurAddBirthday.getText().equals("xx.xx.xxxx")) {
                    fieldChauffeurAddBirthday.getStyleClass().add("error");
                } else {
                    fieldChauffeurAddBirthday.getStyleClass().remove("error");
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
    public String[] getInput() {
        String[] input = new String[6];
        input[0] = fieldChauffeurAddAddress.getText();
        input[1] = fieldChauffeurAddEmail.getText();
        input[2] = fieldChauffeurAddName.getText();
        input[3] = fieldChauffeurAddPhone.getText();
        input[4] = fieldChauffeurAddBirthday.getText();
        input[5] = fieldChauffeurAddId.getText();
               return input;
    }

    public void clear()
    {
        fieldChauffeurAddAddress.setText("");
        fieldChauffeurAddEmail.setText("");
        fieldChauffeurAddName.setText("");
        fieldChauffeurAddPhone.setText("");
        fieldChauffeurAddBirthday.setText("");
        fieldChauffeurAddId.setText("");
    //   errorLabel.setText("");
     //   textFieldPanelForStudent.getTextField(0).requestFocus();
    }
}