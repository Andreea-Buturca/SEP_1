package main.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import main.Main;
import main.Model.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Created by MartinNtb on 27-Nov-16.
 */
public class ReservationController extends Controller implements Initializable {

    public Button mkReservationView;
    public TextField fieldDestination;
    public TextField fieldDeparture;
    public TextField fieldNrPassengers;
    public TextField fieldNameCustomer;
    public TextField fieldNameCompany;
    public TextField fieldAddressCustomer;
    public TextField fieldEmailCustomer;
    public TextField fieldPhoneCustomer;
    public TextField fieldNamePassenger;
    public TextField fieldAddressPassenger;
    public TextField fieldEmailPassenger;
    public TextField fieldDefaultPrice;
    public TextField fieldExtraServices;
    public TextField fieldDiscount;
    public Button buttonAddCustomer;
    public Button buttonAddPassenger;
    public Button buttonRemovePassenger;
    public Button buttonSaveReservation;
    public Button buttonCancelReservation;
    public ListView listViewCustomer;
    public ListView listViewPassenger;
    public Label labelTotalPrice;
    public DatePicker datepickerBirthday;
    public TableView tableTrips;

    public void controlData(ActionEvent actionEvent) throws IOException {
        String alert = "There are some mistakes: \n";
        int length = alert.length();
        if (!validateNumberField(fieldNrPassengers)) alert += "Nr of passengers \n";
        if (tableTrips.getSelectionModel().getSelectedItem() == null) alert += "Select trip \n";

        if (length == alert.length()) {
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
        } else {
            //alert
            alertdisplay("Wrong Input", alert);
        }
    }

    private void calculatePrice(){
        double price = 0;

        if (validateEmptyField(fieldDefaultPrice) && validateNumberField(fieldDefaultPrice)) {
            price = Integer.parseInt(fieldDefaultPrice.getText());
        }
        if (validateEmptyField(fieldExtraServices) && validateNumberField(fieldExtraServices)) {
            price = price + Integer.parseInt(fieldExtraServices.getText());
        }
        if (validateEmptyField(fieldDiscount) && validateNumberField(fieldDiscount)) {
            price = price - Integer.parseInt(fieldDiscount.getText());
        }

        price = price*listViewPassenger.getItems().size();

        labelTotalPrice.setText(price + "DKK");


    }

    public void addCustomer(ActionEvent actionEvent) throws FileNotFoundException, ParseException {
        String alert = "There are some mistakes: ";
        int length = alert.length();

        if (!validateEmptyField(fieldNameCustomer)) alert += "Name, ";
        if (!validateEmptyField(fieldAddressCustomer)) alert += "Address, ";
        if (!validateEmptyField(fieldPhoneCustomer) || !validateLength(fieldPhoneCustomer, 8)) alert += "Phone, ";

        if (length == alert.length()) {
            //save it DataHandler. .....
            String name = fieldNameCustomer.getText();
            String address = fieldAddressCustomer.getText();
            String email = fieldEmailCustomer.getText();
            String phone = fieldPhoneCustomer.getText();
            boolean isCompany = true;
            isCompany = validateEmptyField(fieldNameCompany);

            if (isCompany == false) {
                DataHandler.getCustomerList().add(new Customer(name, address, email, phone));
            } else if (isCompany == true) {
                String companyName = fieldNameCompany.getText();
                DataHandler.getCustomerList().add(new Customer(name, address, email, phone, isCompany, companyName));
            }

            successdisplay("Success", "Customer was created.");
            loadCustomerList();
        } else {
            //alert
            alertdisplay("Wrong Input", alert);
        }
    }

    public void addPassenger(ActionEvent actionEvent) throws IOException {
      //    int nrPassengers = Integer.parseInt(fieldNrPassengers.getText());
     //    for (int i = 0; i < nrPassengers; i++) {
        String alert = "There are some mistakes: ";
        int length = alert.length();

        if (!validateEmptyField(fieldNamePassenger)) alert += "Name, ";
        if (!validateEmptyField(fieldAddressPassenger)) alert += "Address, ";
        if (!validateEmptyDate(datepickerBirthday)) alert += "Birthday ";

        if (length == alert.length()) {
            //save it DataHandler. .....
            String name = fieldNamePassenger.getText();
            String address = fieldAddressPassenger.getText();
            String email = fieldEmailPassenger.getText();
            Date birthday = new Date(datepickerBirthday.getValue().getYear() - 1900, datepickerBirthday.getValue().getMonthValue(), datepickerBirthday.getValue().getDayOfMonth());
            DataHandler.getPassengerList().add(new Passenger(name, address, email, birthday));
            successdisplay("Success", "Passenger was added.");
            loadPassengerList();
            calculatePrice();
        } else {
            //alert
            alertdisplay("Wrong Input", alert);
        }
    }


    private void loadCustomerList() {
        listViewCustomer.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        ObservableList<String> items = FXCollections.observableArrayList();
        for (Customer customer : DataHandler.getCustomerList().getArrayCustomer()) {
            items.add(customer.toString());
        }
        listViewCustomer.setItems(items);
    }

    public void loadPassengerList() {
        listViewPassenger.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        ObservableList<String> items = FXCollections.observableArrayList();
        for (Passenger passenger : DataHandler.getPassengerList().getArrayPassenger()) {
            items.add(passenger.toString());
        }
        listViewPassenger.setItems(items);
    }
    public void loadTrips(){
        tableTrips.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        TableView<String> table = new TableView<String>();
        ObservableList<String> items = FXCollections.observableArrayList();
        for (Trip trip : DataHandler.getTrips().getArrayTrip()) {
            items.add(trip.toString());
        }
        tableTrips.setItems(items);
    }

    public void initialize(URL location, ResourceBundle resources) {
        if (listViewCustomer != null) {
            loadCustomerList();
        }
        if (listViewPassenger != null) {
            loadPassengerList();
        }
        if (tableTrips != null) {
            loadTrips();
        }
    }

    public void removePassenger(ActionEvent actionEvent) throws FileNotFoundException, ParseException {
        ObservableList<String> selected;
        selected = listViewPassenger.getSelectionModel().getSelectedItems();
        for (String aSelected : selected) {
            String[] lineToken = aSelected.split(", ");
            String name = lineToken[0].trim();
            DataHandler.getPassengerList().removePassenger(DataHandler.getPassengerList().findByName(name));
        }
        loadPassengerList();
        calculatePrice();
    }

    public void cancelReservation(ActionEvent actionEvent) throws IOException {
        Stage stage = null;
        Parent root = null;
        if (actionEvent.getSource() == buttonCancelReservation) {
            stage = (Stage) buttonCancelReservation.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../View/mainScreen.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void saveReservation(ActionEvent actionEvent) throws IOException {
        String alert = "There are some mistakes: \n";
        int length = alert.length();
        if(listViewCustomer.getSelectionModel().getSelectedItem() == null) alert += "Select Customer \n";
        if(!validateEmptyField(fieldNamePassenger)) alert += "Add passenger \n";
        if (!validateEmptyField(fieldDefaultPrice) || !validateNumberField(fieldDefaultPrice)) alert += "Price \n";

        if (length == alert.length()) {
            //save it DataHandler. .....
            Customer customer = DataHandler.getCustomerList().findByName(listViewCustomer.getSelectionModel().getSelectedItem().toString());
            ArrayList<Passenger> passengers = DataHandler.getPassengerList().getArrayPassenger();
            Trip trip = DataHandler.getTrips().getTrip((Trip) tableTrips.getSelectionModel().getSelectedItem()); // TODO: 12/4/2016 getters from the table!!
            double price = Double.parseDouble(labelTotalPrice.getText());

            Reservation reservation = new Reservation(trip, customer, passengers, price);
            DataHandler.getReservationList().add(reservation);
            successdisplay("Created", "Reservation created.");

            Parent root = FXMLLoader.load(getClass().getResource("../View/mainScreen.fxml"));
            Scene scene = new Scene(root);
            Main.stage.setScene(scene);
            Main.stage.show();

        } else {
            //alert
            alertdisplay("Wrong Input", alert);
        }
    }

    public void priceListener(KeyEvent keyEvent) {
        calculatePrice();
    }
}






