package main.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import main.Model.*;

import java.io.FileNotFoundException;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;

/**
 * Created by MartinNtb on 28-Nov-16.
 */
public class BusController extends Controller {


    public ListView busListview;
    public Button deleteBus;
    public Button addBusInList;
    public TextField regPlate;
    public TextField seatNumber;
    public ChoiceBox typeChoice;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (busListview != null) {  // BusController is shared between buslist and add bus,
            // in add bus there is no listview so i have to use that condition
            loadList();
        }
    }

    public void loadList() {
        busListview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        ObservableList<String> items = FXCollections.observableArrayList();
        for (Bus bus : DataHandler.getBusList().getArrayBuses()) {
            items.add(bus.toString());
        }
        busListview.setItems(items);
    }


    public void deleteBus(ActionEvent actionEvent) throws FileNotFoundException, ParseException {
        ObservableList<String> selected;
        selected = busListview.getSelectionModel().getSelectedItems();
        for (String aSelected : selected) {
            String[] lineToken = aSelected.split(", ");
            String regPlate = lineToken[0].trim();
            DataHandler.getBusList().removeBus(DataHandler.getBusList().findByRegplate(regPlate));
        }

        loadList();
    }


    public void addBus(ActionEvent actionEvent) throws FileNotFoundException, ParseException {

        String alert = "There are some mistakes: ";
        int length = alert.length();

        if (!validateEmptyField(regPlate) || !validateNumberField(regPlate)) alert += "Registration plate, ";
        if (!validateEmptyField(seatNumber) || !validateNumberField(seatNumber)) alert += "Number of seats, ";

        if (length == alert.length()) {
            String regplate = regPlate.getText();
            int seats = Integer.parseInt(seatNumber.getText());

            if (typeChoice.getValue().equals("Classic Bus")) {
                DataHandler.getBusList().add(new ClassicBus(regplate, seats));
            } else if (typeChoice.getValue().equals("Mini Bus")) {
                DataHandler.getBusList().add(new MiniBus(regplate, seats));
            } else if (typeChoice.getValue().equals("Luxury Bus")) {
                DataHandler.getBusList().add(new LuxuryBus(regplate, seats));
            } else {
                DataHandler.getBusList().add(new PartyBus(regplate, seats));
            }

            successdisplay("Success", "Bus was created.");

        } else {
            //alert
            alertdisplay("Wrong Input", alert);
        }
    }
}
