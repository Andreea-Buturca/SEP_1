package main.Controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import main.Model.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
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
    public CheckBox checkBoxVikar;
    public CheckBox checkBoxDistanceLong;
    public CheckBox checkBoxDistanceMedium;
    public CheckBox checkBoxDistanceShort;
    public CheckBox checkBoxClasicBus;
    public CheckBox checkBoxMiniBus;
    public CheckBox checkBoxPartyBus;
    public CheckBox checkboxLuxuryBus;
    public CheckBox checkBoxWeekend;
    public CheckBox checkBoxWeek;
    private Chauffeur chauffeur;

    public void loadList() {
        listViewChauffeurList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        ObservableList<String> items = FXCollections.observableArrayList();
        for (Chauffeur chauffeur : DataHandler.getChauffeurList().getChauffeurList()) {
            items.add(chauffeur.toString());
        }
        listViewChauffeurList.setItems(items);
    }

    public void initialize(URL location, ResourceBundle resources) {
        if (listViewChauffeurList != null) {
            loadList();
        }
    }

    public void addChauffeur(ActionEvent actionEvent) throws FileNotFoundException, ParseException {
        String alert = "There are some mistakes: ";
        int length = alert.length();

        if (!validateEmptyField(fieldChauffeurAddName)) alert += "Name, ";
        if (!validateEmptyField(fieldChauffeurAddAddress)) alert += "Address, ";
        if (!validateEmptyField(fieldChauffeurAddEmail)) alert += "Email, ";
        if (!validateEmptyField(fieldChauffeurAddPhone) || !validateLength(fieldChauffeurAddPhone, 8))
            alert += "Phone, ";
        if (!validateEmptyField(fieldChauffeurAddId) || !validateLength(fieldChauffeurAddId, 5))
            alert += "Employee ID(5 digit nr), ";
        if (!validateEmptyDate(birthdayPicker)) alert += "Birthday, ";

        if (length == alert.length()) {

            //save it DataHandler.
            String name = fieldChauffeurAddName.getText();
            String address = fieldChauffeurAddAddress.getText();
            String email = fieldChauffeurAddEmail.getText();
            String phone = fieldChauffeurAddPhone.getText();
            MyDate birthday = new MyDate(birthdayPicker.getValue());
            int chauffeurID = Integer.parseInt(fieldChauffeurAddId.getText());
            boolean isVikar = false;
            int preferredDistance = 0;
            String preferredTourType = "";
            int workedHours = 0;
            String bus = "";

            if (!checkBoxVikar.isSelected()) {
                DataHandler.getChauffeurList().add(new Chauffeur(name, address, email, phone, birthday, chauffeurID, isVikar));
            }
            else if (checkBoxVikar.isSelected()) {
                isVikar = true;
                DataHandler.getChauffeurList().add(new Chauffeur(name, address, email, phone, birthday, chauffeurID, isVikar));
            }
           /* if (checkBoxDistanceShort.isSelected()) {
                chauffeur.setPreferredShortDistance(400);
                preferredDistance = chauffeur.getPreferredDistance();
                DataHandler.getChauffeurList().add(new Chauffeur(name, address, email, phone, chauffeurID, preferredDistance, preferredTourType, workedHours, isVikar));
            }
            if (checkBoxDistanceMedium.isSelected()) {
                chauffeur.setPreferredMediumDistance(1000);
                preferredDistance = chauffeur.getPreferredDistance();
                DataHandler.getChauffeurList().add(new Chauffeur(name, address, email, phone, chauffeurID, preferredDistance, preferredTourType, workedHours, isVikar));
            }
            if (checkBoxDistanceLong.isSelected()) {
                chauffeur.setPreferredLongDistance(3001);
                preferredDistance = chauffeur.getPreferredDistance();
                DataHandler.getChauffeurList().add(new Chauffeur(name, address, email, phone, chauffeurID, preferredDistance, preferredTourType, workedHours, isVikar));
            }
            if (checkBoxClasicBus.isSelected()) {
                bus = "Clasic Bus";
                DataHandler.getChauffeurList().add(new Chauffeur(name, address, email, phone, chauffeurID, preferredDistance, preferredTourType, workedHours, isVikar));
            }
            if (checkboxLuxuryBus.isSelected()) {
                bus = "Luxury Bus";
                DataHandler.getChauffeurList().add(new Chauffeur(name, address, email, phone, chauffeurID, preferredDistance, preferredTourType, workedHours, isVikar));
            }
            if (checkBoxPartyBus.isSelected()) {
                bus = "Party Bus";
                DataHandler.getChauffeurList().add(new Chauffeur(name, address, email, phone, chauffeurID, preferredDistance, preferredTourType, workedHours, isVikar));
            }
            if (checkBoxMiniBus.isSelected()) {
                bus = "Mini Bus";
                DataHandler.getChauffeurList().add(new Chauffeur(name, address, email, phone, chauffeurID, preferredDistance, preferredTourType, workedHours, isVikar));
            }
            if (checkBoxWeekend.isSelected()) {
                chauffeur.setPreferredWeekendHours(10);
                workedHours = chauffeur.getPreferredWorkedHours();
                DataHandler.getChauffeurList().add(new Chauffeur(name, address, email, phone, chauffeurID, preferredDistance, preferredTourType, workedHours, isVikar));
            }
            if (checkBoxWeek.isSelected()) {
                chauffeur.setPreferredWeekHours();
                workedHours = chauffeur.getPreferredWorkedHours();
                DataHandler.getChauffeurList().add(new Chauffeur(name, address, email, phone, chauffeurID, preferredDistance, preferredTourType, workedHours, isVikar));
            }*/

           successdisplay("Success", "Chauffeur was added.");
        } else {
            //alert
            alertdisplay("Wrong Input", alert);
        }
    }


    public void deleteChauffeur(ActionEvent actionEvent) throws FileNotFoundException, ParseException {
        ObservableList<String> selected;
        selected = listViewChauffeurList.getSelectionModel().getSelectedItems();
        for (String aSelected : selected) {
            String[] lineToken = aSelected.split(", ");
            String name = lineToken[0].trim();
            DataHandler.getChauffeurList().removeChauffeur(DataHandler.getChauffeurList().getChauffeurByName(name));
        }
        loadList();
        successdisplay("Success", "Chauffeur was deleted.");
    }
}