package main.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by andreea on 11/28/2016.
 */
public class TripController extends Controller implements Initializable {


    public TextField fieldStartTime;
    public TextField fieldEndTime;
    public TextField fieldDuration;
    public ComboBox fieldDestination;
    public ComboBox fieldDeparture;
    public TextField fieldDistance;
    public TextField fieldPrice;
    public DatePicker startDatePicker;
    public DatePicker endDatePicker;
    public CheckBox checkPrivateTrip;
    public Button CreateTourBtn;
    public ToggleButton toggleHours;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        toggleHours.setOnAction(event -> toggleHours.setText((toggleHours.getText().equals("Hours")) ? "Days" : "Hours"));

        //TODO call datahandler to add data to list, combos, ...

    }

    public void createTour(ActionEvent actionEvent) throws IOException {


        String alert = "There are some mistakes: ";
        int length = alert.length();

        if (!validateEmptyField(fieldStartTime) || !validateTimeField(fieldStartTime)) alert += "Start time, ";
        if (!validateEmptyField(fieldEndTime) || !validateTimeField(fieldEndTime)) alert += "End time, ";
        if (!validateEmptyField(fieldDuration) || !validateNumberField(fieldDuration)) alert += "Duration, ";
        if (!validateEmptyField(fieldDistance) || !validateNumberField(fieldDistance)) alert += "Distance, ";
        if (!validateEmptyField(fieldPrice) || !validateNumberField(fieldPrice)) alert += "Price, ";

        if (!validateEmptyDate(startDatePicker)) alert += "Start Date, ";
        if (!validateEmptyDate(endDatePicker)) alert += "End Date, ";

        if (!validateEmptyCombo(fieldDestination)) alert += "Destination, ";
        if (!validateEmptyCombo(fieldDeparture)) alert += "Departure, ";

        if (length == alert.length()) {
            //save it DataHandler. .....
        } else {
            //alert
            alertdisplay("Wrong Input", alert);
        }
    }
}
