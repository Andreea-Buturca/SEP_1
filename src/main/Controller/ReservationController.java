package main.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by MartinNtb on 27-Nov-16.
 */
public class ReservationController extends Controller implements Initializable {

    public Button mkReservationView;
    public TextField fieldDestination;
    public TextField fieldDeparture;
    public TextField fieldNrPassengers;
    public TextField fieldArrival;
    public TextField fieldNameCustomer;
    public TextField fieldNameCompany;
    public TextField fieldAddressCustomer;
    public TextField fieldEmailCustomer;
    public TextField fieldPhoneCustomer;
    public TextField fieldNamePassenger;
    public TextField fieldAddressPassenger;
    public TextField fieldEmailPassenger;
    public TextField fieldSeatNr;
    public TextField fieldDefaultPrice;
    public TextField fieldExtraServices;
    public TextField fieldDiscount;

    public void initialize(URL location, ResourceBundle resources) {


        // starts labels for makeReservation

        if (fieldDestination != null) {

            fieldDestination.focusedProperty().addListener((arg0, oldValue, newValue) -> {
                if (!newValue) { // when focus lost
                    if (fieldDestination.getText().equals("xx.xx.xxxx")) {
                        fieldDestination.getStyleClass().add("error");
                    } else {
                        fieldDestination.getStyleClass().remove("error");
                    }
                }
            });
            fieldDeparture.focusedProperty().addListener((arg0, oldValue, newValue) -> {
                if (!newValue) { // when focus lost
                    if (fieldDeparture.getText().equals("xx.xx.xxxx")) {
                        fieldDeparture.getStyleClass().add("error");
                    } else {
                        fieldDeparture.getStyleClass().remove("error");
                    }
                }
            });
            fieldNrPassengers.focusedProperty().addListener((arg0, oldValue, newValue) -> {
                if (!newValue) { // when focus lost
                    if (fieldNrPassengers.getText().equals("xx.xx.xxxx")) {
                        fieldNrPassengers.getStyleClass().add("error");
                    } else {
                        fieldNrPassengers.getStyleClass().remove("error");
                    }
                }
            });
            fieldArrival.focusedProperty().addListener((arg0, oldValue, newValue) -> {
                if (!newValue) { // when focus lost
                    if (fieldArrival.getText().equals("xx.xx.xxxx")) {
                        fieldArrival.getStyleClass().add("error");
                    } else {
                        fieldArrival.getStyleClass().remove("error");
                    }
                }
            });
        }

        // starts labels for makeReservationDate

        if (fieldNameCustomer != null) {
            fieldNameCustomer.focusedProperty().addListener((arg0, oldValue, newValue) -> {
                if (!newValue) { // when focus lost
                    if (fieldNameCustomer.getText().equals("xx.xx.xxxx")) {
                        fieldNameCustomer.getStyleClass().add("error");
                    } else {
                        fieldNameCustomer.getStyleClass().remove("error");
                    }
                }
            });
            fieldNameCompany.focusedProperty().addListener((arg0, oldValue, newValue) -> {
                if (!newValue) { // when focus lost
                    if (fieldNameCompany.getText().equals("xx.xx.xxxx")) {
                        fieldNameCompany.getStyleClass().add("error");
                    } else {
                        fieldNameCompany.getStyleClass().remove("error");
                    }
                }
            });
            fieldAddressCustomer.focusedProperty().addListener((arg0, oldValue, newValue) -> {
                if (!newValue) { // when focus lost
                    if (fieldAddressCustomer.getText().equals("xx.xx.xxxx")) {
                        fieldAddressCustomer.getStyleClass().add("error");
                    } else {
                        fieldAddressCustomer.getStyleClass().remove("error");
                    }
                }
            });
            fieldEmailCustomer.focusedProperty().addListener((arg0, oldValue, newValue) -> {
                if (!newValue) { // when focus lost
                    if (fieldEmailCustomer.getText().equals("xx.xx.xxxx")) {
                        fieldEmailCustomer.getStyleClass().add("error");
                    } else {
                        fieldEmailCustomer.getStyleClass().remove("error");
                    }
                }
            });
            fieldPhoneCustomer.focusedProperty().addListener((arg0, oldValue, newValue) -> {
                if (!newValue) { // when focus lost
                    if (fieldPhoneCustomer.getText().equals("xx.xx.xxxx")) {
                        fieldPhoneCustomer.getStyleClass().add("error");
                    } else {
                        fieldPhoneCustomer.getStyleClass().remove("error");
                    }
                }
            });
            fieldNamePassenger.focusedProperty().addListener((arg0, oldValue, newValue) -> {
                if (!newValue) { // when focus lost
                    if (fieldNamePassenger.getText().equals("xx.xx.xxxx")) {
                        fieldNamePassenger.getStyleClass().add("error");
                    } else {
                        fieldNamePassenger.getStyleClass().remove("error");
                    }
                }
            });
            fieldAddressPassenger.focusedProperty().addListener((arg0, oldValue, newValue) -> {
                if (!newValue) { // when focus lost
                    if (fieldAddressPassenger.getText().equals("xx.xx.xxxx")) {
                        fieldAddressPassenger.getStyleClass().add("error");
                    } else {
                        fieldAddressPassenger.getStyleClass().remove("error");
                    }
                }
            });
            fieldEmailPassenger.focusedProperty().addListener((arg0, oldValue, newValue) -> {
                if (!newValue) { // when focus lost
                    if (fieldEmailPassenger.getText().equals("xx.xx.xxxx")) {
                        fieldEmailPassenger.getStyleClass().add("error");
                    } else {
                        fieldEmailPassenger.getStyleClass().remove("error");
                    }
                }
            });
            fieldSeatNr.focusedProperty().addListener((arg0, oldValue, newValue) -> {
                if (!newValue) { // when focus lost
                    if (fieldSeatNr.getText().equals("xx.xx.xxxx")) {
                        fieldSeatNr.getStyleClass().add("error");
                    } else {
                        fieldSeatNr.getStyleClass().remove("error");
                    }
                }
            });
            fieldDefaultPrice.focusedProperty().addListener((arg0, oldValue, newValue) -> {
                if (!newValue) { // when focus lost
                    if (fieldDefaultPrice.getText().equals("xx.xx.xxxx")) {
                        fieldDefaultPrice.getStyleClass().add("error");
                    } else {
                        fieldDefaultPrice.getStyleClass().remove("error");
                    }
                }
            });
            fieldExtraServices.focusedProperty().addListener((arg0, oldValue, newValue) -> {
                if (!newValue) { // when focus lost
                    if (fieldExtraServices.getText().equals("xx.xx.xxxx")) {
                        fieldExtraServices.getStyleClass().add("error");
                    } else {
                        fieldExtraServices.getStyleClass().remove("error");
                    }
                }
            });
            fieldDiscount.focusedProperty().addListener((arg0, oldValue, newValue) -> {
                if (!newValue) { // when focus lost
                    if (fieldDiscount.getText().equals("xx.xx.xxxx")) {
                        fieldDiscount.getStyleClass().add("error");
                    } else {
                        fieldDiscount.getStyleClass().remove("error");
                    }
                }
            });
        }
    }


    public void controlData(ActionEvent actionEvent) throws IOException {


        Stage stage;
        Parent root;

        if ((actionEvent.getSource() == mkReservationView)) {
            stage = (Stage) mkReservationView.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../View/makeReservationDate.fxml"));
        } else {
            stage = (Stage) mkReservationView.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../View/mainScreen.fxml"));
        }


        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
}



