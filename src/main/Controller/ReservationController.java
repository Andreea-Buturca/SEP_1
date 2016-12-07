package main.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import main.Main;
import main.Model.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
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
    public TextArea noteReservation;
    public TextArea noteReservationWindowed;
    public ListView tripListReservation;
    public Label reservationLabel;

    private String note;
    private Reservation editing;
    private Trip trip;
    private PassengerList passengerList = new PassengerList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (listViewCustomer != null) {
            loadCustomerList();
        }
        if (listViewPassenger != null) {
            loadPassengerList();
        }
        if (tripListReservation != null) {
            loadTrips();
        }
    }


    //makeReservationView
    public void searchTrip(KeyEvent keyEvent) {
        findTrip();
    }

    private void loadTrips() {
        TripList trips;
        trips = DataHandler.getTrips();
        tripListReservation.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        ObservableList<Trip> items = FXCollections.observableArrayList();
        if (trips.getSize() != 0) {
            items.addAll(trips.getArrayTrip());
        }
        tripListReservation.setItems(items);
    }

    private void findTrip() {
        if (tripListReservation != null) {
            TripList matching = DataHandler.getTrips();
            if (fieldDestination.getText() != null && (!fieldDestination.getText().equals("")))
                matching = matching.findAllByDestination(fieldDestination.getText());
            if (fieldDeparture.getText() != null && (!fieldDeparture.getText().equals("")))
                matching = matching.findAllByDeparture(fieldDeparture.getText());
            if (fieldNrPassengers.getText() != null && (!fieldNrPassengers.getText().equals(""))) {
                if (validateNumberField(fieldNrPassengers)) {
                    matching = matching.findAllByPassengers(fieldNrPassengers.getText());
                }
            }
            ObservableList<Trip> items = FXCollections.observableArrayList();
            for (int i = 0; i < matching.getSize(); i++) {
                items.add(matching.get(i));
            }
            tripListReservation.setItems(items);
        }

    }

    private void openWindowedNote() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../View/noteReservation.fxml"));
        Parent parent = fxmlLoader.load();
        Scene sceneNote = new Scene(parent);
        Stage window = new Stage();
        ReservationController reservationController = fxmlLoader.getController();
        reservationController.setNote(note);
        window.setTitle("Edit trip");
        window.setScene(sceneNote);
        window.setResizable(false);
        window.showAndWait();
    }

    public void controlData(ActionEvent actionEvent) throws IOException {
        String alert = "There are some mistakes: \n";
        int length = alert.length();
        if (tripListReservation.getSelectionModel().getSelectedItem() == null) alert += "Select trip \n";

        if (length == alert.length()) {
            if (noteReservation != null) {
                if (noteReservation.getText() != null) {
                    note = noteReservation.getText();
                }
            }

            Stage stage = (Stage) mkReservationView.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../View/makeReservationData.fxml"));
            Parent root = fxmlLoader.load();

            ReservationController editReservation = fxmlLoader.getController();
            editReservation.setTrip((Trip) tripListReservation.getSelectionModel().getSelectedItem());

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            if (!note.equals("")) {
                openWindowedNote();
            }
        } else {
            //alert
            alertdisplay("Wrong Input", alert);
        }
    }

    //makeReservationData

    private void setNote(String note) {
        noteReservationWindowed.setText(note);
    }

    private void setTrip(Trip trip) {
        this.trip = trip;
        fieldDefaultPrice.setText(Integer.toString(trip.getPrice()));
    }

    public void priceListener(KeyEvent keyEvent) {
        calculatePrice();
    }

    private void calculatePrice() {
        double price = 0;

        if (validateEmptyField(fieldDefaultPrice) && (validateNumberField(fieldDefaultPrice) || validateDoubleNumberField(fieldDefaultPrice))) {
            price = Double.parseDouble(fieldDefaultPrice.getText());
        }
        if (validateEmptyField(fieldExtraServices) && (validateNumberField(fieldExtraServices) || validateDoubleNumberField(fieldExtraServices))) {
            price = price + Double.parseDouble(fieldExtraServices.getText());
        }

        price = price * listViewPassenger.getItems().size();

        if (validateEmptyField(fieldDiscount) && (validateNumberField(fieldDiscount) || validateDoubleNumberField(fieldDiscount))) {
            price = price - Double.parseDouble(fieldDiscount.getText());
        }

        labelTotalPrice.setText(price + " DKK");


    }

    private void loadCustomerList() {
        listViewCustomer.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        ObservableList<Customer> items = FXCollections.observableArrayList();
        items.addAll(DataHandler.getCustomerList().getArrayCustomer());
        listViewCustomer.setItems(items);
    }

    private void loadPassengerList() {
        listViewPassenger.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        ObservableList<Passenger> items = FXCollections.observableArrayList();
        items.addAll(passengerList.getArrayPassenger());
        listViewPassenger.setItems(items);
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
            boolean isCompany;
            isCompany = validateEmptyField(fieldNameCompany);

            if (!isCompany) {
                DataHandler.getCustomerList().add(new Customer(name, address, email, phone));
            } else if (isCompany) {
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
        String alert = "There are some mistakes: ";
        int length = alert.length();

        if (!validateEmptyField(fieldNamePassenger)) alert += "Name, ";
        if (!validateEmptyDate(datepickerBirthday)) alert += "Birthday ";

        if (length == alert.length()) {
            String name = fieldNamePassenger.getText();
            String address = fieldAddressPassenger.getText();
            String email = fieldEmailPassenger.getText();
            LocalDate birthday = datepickerBirthday.getValue();
            passengerList.add(new Passenger(name, address, email, birthday));
            successdisplay("Success", "Passenger was added.");
            loadPassengerList();
            calculatePrice();
        } else {
            //alert
            alertdisplay("Wrong Input", alert);
        }
    }

    public void removePassenger(ActionEvent actionEvent) throws FileNotFoundException, ParseException {
        passengerList.removePassenger((Passenger) listViewPassenger.getSelectionModel().getSelectedItem());
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
        Scene scene = new Scene(root != null ? root : null);
        assert stage != null;
        stage.setScene(scene);
        stage.show();
    }

    public void setEditData(Reservation reservation) {
        menu.setVisible(false);
        reservationLabel.setText("Edit Reservation");
        buttonSaveReservation.setText("Edit Reservation");

        listViewCustomer.getSelectionModel().select(reservation.getCustomer());
        passengerList = reservation.getReservationPassengers();

        loadCustomerList();
        loadPassengerList();

        fieldDefaultPrice.setText(Double.toString(reservation.getDefaultPricePerson()));
        if (reservation.getPriceExtraServices() != 0) {
            fieldExtraServices.setText(Double.toString(reservation.getPriceExtraServices()));
        }
        if (reservation.getDiscount() != 0) {
            System.out.println(reservation.getDiscount());
            fieldDiscount.setText(Double.toString(reservation.getDiscount()));
        }

        editing = reservation;
    }

    public void saveReservation(ActionEvent actionEvent) throws IOException {
        String alert = "There are some mistakes: \n";
        int length = alert.length();
        if (listViewCustomer.getSelectionModel().getSelectedItem() == null) alert += "Select Customer \n";
        if (listViewPassenger.getItems().size() == 0) alert += "Add passenger \n";
        if (!validateNumberField(fieldDefaultPrice) && !validateDoubleNumberField(fieldDefaultPrice))
            alert += "Price \n";

        if (length == alert.length()) {
            //save it DataHandler. .....
            Customer customer = (Customer) listViewCustomer.getSelectionModel().getSelectedItem();
            DataHandler.getCustomerList().getCustomer(DataHandler.getCustomerList().getIndex((Customer) listViewCustomer.getSelectionModel().getSelectedItem())).addPointToCustomer();
            String[] priceLine = labelTotalPrice.getText().split(" ");
            double price = Double.parseDouble(priceLine[0]);

            if (editing != null) {
                trip = editing.getTrip();
                DataHandler.getReservationList().remove(editing);
            }

            Reservation reservation = new Reservation(trip, customer, passengerList, price);

            if (validateEmptyField(fieldDiscount) && (validateNumberField(fieldDiscount) || validateDoubleNumberField(fieldDiscount))) {
                reservation.setDiscount(Double.parseDouble(fieldDiscount.getText()));
                System.out.println(Double.parseDouble(fieldDiscount.getText()));
            }
            if (validateEmptyField(fieldExtraServices) && (validateNumberField(fieldExtraServices) || validateDoubleNumberField(fieldExtraServices))) {
                reservation.setPriceExtraServices(Double.parseDouble(fieldExtraServices.getText()));
            }
            reservation.setFinalPrice();
            DataHandler.getReservationList().add(reservation);
            if (editing != null) {
                successdisplay("Edited", "Reservation edited.");

                Stage stage = (Stage) labelTotalPrice.getScene().getWindow();
                stage.close();
            } else {
                successdisplay("Created", "Reservation created.");
            }

            Parent root = FXMLLoader.load(getClass().getResource("../View/mainScreen.fxml"));
            Scene scene = new Scene(root);
            Main.stage.setScene(scene);
            Main.stage.show();

        } else {
            //alert
            alertdisplay("Wrong Input", alert);
        }
    }


}






