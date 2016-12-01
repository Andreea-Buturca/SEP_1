package main.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.Model.Customer;
import main.Model.DataHandler;
import main.Model.Passenger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
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
    public Button buttonAddCustomer;
    public Button buttonAddPassenger;
    public Button buttonRemovePassenger;
    public Button buttonSaveReservation;
    public Button buttonCancelReservation;
    public ListView listViewCustomer;
    public ListView listViewPassenger;

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
 public void addCustomer(ActionEvent actionEvent) throws FileNotFoundException, ParseException {
        String alert = "There are some mistakes: ";
        int length = alert.length();

        if (!validateEmptyField(fieldNameCustomer) ) alert += "Name, ";
      //  if (!validateEmptyField(fieldNameCompany) ) alert += "Company name, ";
        if (!validateEmptyField(fieldAddressCustomer) ) alert += "Address, ";
        if (!validateEmptyField(fieldEmailCustomer) ) alert += "Email, ";
        if (!validateEmptyField(fieldPhoneCustomer) || !validateLength(fieldPhoneCustomer, 8)) alert += "Phone, ";

        if (length == alert.length()) {
            //save it DataHandler. .....
            String name = fieldNameCustomer.getText();
            String address = fieldAddressCustomer.getText();
            String email = fieldEmailCustomer.getText();
            String phone = fieldPhoneCustomer.getText();
            boolean isCompany=false;
            if(isCompany) {
                DataHandler.getCustomerList().addCustomer(new Customer(name, address, email, phone));
            }
            else if(isCompany==true)
            {
            String companyName = fieldNameCompany.getText();
            DataHandler.getCustomerList().addCustomer(new Customer(name, address, email, phone, isCompany, companyName));
            }

            successdisplay("Success", "Customer was created.");
        } else {
            //alert
            alertdisplay("Wrong Input", alert);
        }
    }

    public void addPassenger(ActionEvent actionEvent) throws IOException {
        String alert = "There are some mistakes: ";
        int length = alert.length();

        if (!validateEmptyField(fieldNamePassenger) ) alert += "Name, ";
        if (!validateEmptyField(fieldAddressPassenger) ) alert += "Address, ";
        if (!validateEmptyField(fieldEmailPassenger) ) alert += "Email, ";
        if (!validateEmptyField(fieldSeatNr) || !validateNumberField(fieldSeatNr)) alert += "Seat number, ";

        if (length == alert.length()) {
            //save it DataHandler. .....
        } else {
            //alert
            alertdisplay("Wrong Input", alert);
        }
    }

    public void loadCustomerList() {
        listViewCustomer.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        ObservableList<String> items = FXCollections.observableArrayList();
        for (Customer customer : DataHandler.getCustomerList().getCustomers()) {
            items.add(customer.toString());
        }
        listViewCustomer.setItems(items);
    }
    public void loadPassengerList() {
        listViewPassenger.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        ObservableList<String> items = FXCollections.observableArrayList();
        for (Passenger passenger : DataHandler.getPassengerList().getPassengers()) {
            items.add(passenger.toString());
        }
        listViewPassenger.setItems(items);
    }
    public void initialize(URL location, ResourceBundle resources) {
        if (listViewCustomer != null) {
            loadCustomerList();
        }
        if (listViewPassenger != null) {
            loadPassengerList();
        }
    }

    public void removePassenger(ActionEvent actionEvent) throws IOException {
    }
    public void cancelReservation(ActionEvent actionEvent) throws IOException {
    }
    public void saveReservation(ActionEvent actionEvent) throws IOException {


        String alert = "There are some mistakes: ";
        int length = alert.length();


        if (!validateEmptyField(fieldDefaultPrice) || !validateNumberField(fieldDefaultPrice)) alert += "Price, ";
        if (!validateEmptyField(fieldExtraServices) || !validateNumberField(fieldExtraServices)) alert += "Extra services, ";
        if (!validateEmptyField(fieldDiscount) || !validateNumberField(fieldDiscount)) alert += "Discount, ";

        if (length == alert.length()) {
            //save it DataHandler. .....
        } else {
            //alert
            alertdisplay("Wrong Input", alert);
        }
    }

}



