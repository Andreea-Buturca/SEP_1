package main.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.awt.SystemColor.window;

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
    public TextField tests;
    public Button saveCustomerBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if (toggleHours != null) {
            toggleHours.setOnAction(event -> toggleHours.setText((toggleHours.getText().equals("Hours")) ? "Days" : "Hours"));
        }

        if (checkPrivateTrip != null) {
            checkPrivateTrip.setOnAction(event -> {
                System.out.println(checkPrivateTrip.isSelected());
                if (checkPrivateTrip.isSelected()) {
                    System.out.println("selected");

                    Stage window = new Stage();
                    Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("../View/addCustomerData.fxml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    window.initModality(Modality.APPLICATION_MODAL);
                    window.setTitle("Add Customer Data");
                    window.setMinWidth(600);
                    window.setMinHeight(400);
                    window.setResizable(false);

                    // TODO: 30-Nov-16 get somehow data from here

                    Scene scene = new Scene(root);
                    window.setScene(scene);
                    window.showAndWait();


                }
            });
        }
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


        if (checkPrivateTrip.isSelected()) {
            System.out.println(tests.getText());
        }

        // TODO: 30-Nov-16 check if selected bus and chauffeur from list

        if (length == alert.length()) {
            //save it DataHandler. .....
        } else {
            //alert
            alertdisplay("Wrong Input", alert);
        }
    }

    public void addCustomerData(ActionEvent actionEvent) {

        Window window = saveCustomerBtn.getScene().getWindow();
        System.out.println(tests.getText());
        window.getOnCloseRequest();
    }
}
