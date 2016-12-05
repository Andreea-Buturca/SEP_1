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
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.Main;
import main.Model.*;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Created by andreea on 11/28/2016.
 */
public class TripController extends Controller implements Initializable {


    public TextField fieldStartTime;
    public TextField fieldEndTime;
    public ComboBox fieldDestination;
    public ComboBox fieldDeparture;
    public TextField fieldDistance;
    public TextField fieldPrice;
    public DatePicker startDatePicker;
    public DatePicker endDatePicker;
    public CheckBox checkPrivateTrip;
    public Button CreateTourBtn;
    public ListView busListview;
    public ChoiceBox busType;
    public ComboBox stopName;
    public Button addStopBtn;
    public Button removeStopBtn;
    public ListView stopsList;
    public TextField stopTimeField;
    public ListView chauffeurList;

    //Add customer
    public TextField fieldCustomerName;
    public TextField fieldCustomerCompany;
    public TextField fieldCustomerAddress;
    public TextField fieldCustomerEmail;
    public TextField fieldCustomerPhone;
    public ListView customerList;
    public Button saveCustomerBtn;

    private Customer customer = null;

    //list for stops
    private DestinationList stops = new DestinationList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if (fieldStartTime != null) {
            loadBusList();
            loadChauffeurList();

            ObservableList<Destination> destinationItems = FXCollections.observableArrayList();
            destinationItems.addAll(DataHandler.getDestinationList().getArrayDestination());
            fieldDestination.setItems(destinationItems);
            fieldDeparture.setItems(destinationItems);
            stopName.setItems(destinationItems);

        }

        if (checkPrivateTrip != null) {
            checkPrivateTrip.setOnAction(event -> {
                if (checkPrivateTrip.isSelected()) {
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


                    // TODO: 30-Nov-16 getReservation somehow data from here


                    Scene scene = new Scene(root);
                    window.setScene(scene);
                    window.show();


                }
            });
        }

        if (customerList != null) loadCustomerList();

    }


    public void createTour(ActionEvent actionEvent) throws IOException {


        String alert = "There are some mistakes: ";
        int length = alert.length();

        if (!validateEmptyDate(startDatePicker)) alert += "Start Date, ";
        if (!validateEmptyDate(endDatePicker)) alert += "End Date, ";
        if (!validateEmptyField(fieldStartTime) || !validateTimeField(fieldStartTime)) alert += "Start time, ";
        if (!validateEmptyField(fieldEndTime) || !validateTimeField(fieldEndTime)) alert += "End time, ";
        if (!validateEmptyField(fieldDistance) || !validateNumberField(fieldDistance)) alert += "Distance, ";
        if (!validateEmptyField(fieldPrice) || !validateNumberField(fieldPrice)) alert += "Price, ";
        if (!validateEmptyCombo(fieldDestination)) alert += "Destination, ";
        if (!validateEmptyCombo(fieldDeparture)) alert += "Departure, ";
        if (busListview.getSelectionModel().getSelectedItem() == null) alert += "Bus, ";
        if (chauffeurList.getSelectionModel().getSelectedItem() == null) alert += "Chauffeur, ";

        if (length == alert.length()) {
            //save it DataHandler. .....
            Bus bus = (Bus) busListview.getSelectionModel().getSelectedItem();
            Chauffeur chauffeur = (Chauffeur) chauffeurList.getSelectionModel().getSelectedItem();

            Destination pickUp;
            Destination destination;

            if (DataHandler.getDestinationList().findByName(fieldDeparture.getValue().toString()) != null) {
                pickUp = DataHandler.getDestinationList().findByName(fieldDeparture.getValue().toString());
            } else {
                pickUp = new Destination(fieldDeparture.getValue().toString());
                DataHandler.getDestinationList().add(pickUp);
            }

            if (DataHandler.getDestinationList().findByName(fieldDestination.getValue().toString()) != null) {
                destination = DataHandler.getDestinationList().findByName(fieldDestination.getValue().toString());
            } else {
                destination = new Destination(fieldDestination.getValue().toString());
                DataHandler.getDestinationList().add(destination);
            }

            int distance = Integer.parseInt(fieldDistance.getText());

            // TODO: 04-Dec-16 extra services

            Trip trip = new Trip(bus, chauffeur, pickUp, destination, distance, startDatePicker.getValue(), fieldStartTime.getText(), endDatePicker.getValue(), fieldEndTime.getText(), Integer.parseInt(fieldPrice.getText()));

            if (stops != null) {
                trip.setStops(stops);
            }
            if (checkPrivateTrip.isSelected() && customer != null) {
                trip.setCustomer(customer);
            }

            DataHandler.getTrips().add(trip);

            successdisplay("Created", "Trip was created.");

            Parent root = FXMLLoader.load(getClass().getResource("../View/mainScreen.fxml"));
            Scene scene = new Scene(root);
            Main.stage.setScene(scene);
            Main.stage.show();

        } else {
            //alert
            alertdisplay("Wrong Input", alert);
        }
    }

    public void getDataChoice(ActionEvent actionEvent) {
        loadBusList();
        loadChauffeurList();
    }

    public void getDataFromField(KeyEvent keyEvent) {

        loadBusList();
        loadChauffeurList();
    }

    public void callCustomerList(KeyEvent keyEvent) {
        loadCustomerList();
    }

    private void loadChauffeurList() {
        ChauffeurList chauffeurs;

        chauffeurs = DataHandler.getChauffeurList();

        if (validateEmptyField(fieldDistance) && validateNumberField(fieldDistance)) {
            // chauffeurs = chauffeurs.getAllByPrefferedDistance(Integer.parseInt(fieldDistance.getText()));
        }


        if (startDatePicker.getValue() != null && endDatePicker.getValue() != null && validateTimeField(fieldStartTime) && validateTimeField(fieldEndTime)) {
            String[] lineToken = fieldStartTime.getText().split(":");
            int hours = Integer.parseInt(lineToken[0]);
            int minutes = Integer.parseInt(lineToken[1]);
            Date dateStart = new Date(startDatePicker.getValue().getYear()-1900, startDatePicker.getValue().getMonthValue(), startDatePicker.getValue().getDayOfMonth(), hours, minutes);
            lineToken = fieldEndTime.getText().split(":");
            hours = Integer.parseInt(lineToken[0]);
            minutes = Integer.parseInt(lineToken[1]);
            Date dateEnd = new Date(endDatePicker.getValue().getYear()-1900, endDatePicker.getValue().getMonthValue(), endDatePicker.getValue().getDayOfMonth(), hours, minutes);
            chauffeurs.getAvailable(dateStart, dateEnd);
            //chauffeurs.byprefference
        }


        chauffeurList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        ObservableList<Chauffeur> items = FXCollections.observableArrayList();
        if (chauffeurs.getSize() != 0) {
            items.addAll(chauffeurs.getArrayChauffeur());
        }
        chauffeurList.setItems(items);
    }

    private void loadBusList() {

        BusList buses;

        if (busType.getValue().equals("Mini Bus"))
            buses = new BusList(DataHandler.getBusList().searchByType("main.Model.MiniBus"));
        else if (busType.getValue().equals("Party Bus"))
            buses = new BusList(DataHandler.getBusList().searchByType("main.Model.PartyBus"));
        else if (busType.getValue().equals("Luxury Bus"))
            buses = new BusList(DataHandler.getBusList().searchByType("main.Model.LuxuryBus"));
        else buses = new BusList(DataHandler.getBusList().searchByType("main.Model.ClassicBus"));

        if (startDatePicker.getValue() != null && endDatePicker.getValue() != null && validateTimeField(fieldStartTime) && validateTimeField(fieldEndTime)) {
            String[] lineToken = fieldStartTime.getText().split(":");
            int hours = Integer.parseInt(lineToken[0]);
            int minutes = Integer.parseInt(lineToken[1]);
            Date dateStart = new Date(startDatePicker.getValue().getYear()-1900, startDatePicker.getValue().getMonthValue(), startDatePicker.getValue().getDayOfMonth(), hours, minutes);
            lineToken = fieldEndTime.getText().split(":");
            hours = Integer.parseInt(lineToken[0]);
            minutes = Integer.parseInt(lineToken[1]);
            Date dateEnd = new Date(endDatePicker.getValue().getYear()-1900, endDatePicker.getValue().getMonthValue(), endDatePicker.getValue().getDayOfMonth(), hours, minutes);
            buses.getAvailable(dateStart, dateEnd);
        }

        busListview.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        ObservableList<Bus> items = FXCollections.observableArrayList();
        items.addAll(buses.getArrayBuses());
        busListview.setItems(items);


    }

    private void loadCustomerList() {
        CustomerList customers = DataHandler.getCustomerList();

        if (validateEmptyField(fieldCustomerName))
            if (customers.findAllByName(fieldCustomerName.getText()) != null)
                customers = customers.findAllByName(fieldCustomerName.getText());
        if (validateEmptyField(fieldCustomerPhone))
            if (customers.findAllByPhone(fieldCustomerPhone.getText()) != null)
                customers = customers.findAllByPhone(fieldCustomerPhone.getText());
        if (validateEmptyField(fieldCustomerCompany))
            if (customers.findAllByCompanyName(fieldCustomerCompany.getText()) != null)
                customers = customers.findAllByCompanyName(fieldCustomerCompany.getText());

        ObservableList<Customer> customerItems = FXCollections.observableArrayList();

        if (customers.getSize() != 0) {
            customerItems.addAll(customers.getArrayCustomer());
        } else {
            customerItems.addAll(DataHandler.getCustomerList().getArrayCustomer());
        }

        customerList.setItems(customerItems);
    }

    private void loadStops() {
        ObservableList<Destination> destinationItems = FXCollections.observableArrayList();
        for (Destination destination : stops.getArrayDestination()) {
            destinationItems.add(destination);
        }
        stopsList.setItems(destinationItems);
    }

    public void handleStops(ActionEvent actionEvent) {
        if (actionEvent.getSource() == addStopBtn && validateNumberField(stopTimeField)) {
            stops.add(new Destination(stopName.getValue().toString(), stopTimeField.getText()));
        }

        if (actionEvent.getSource() == removeStopBtn && stopsList.getSelectionModel().getSelectedItem() != null) {
            String[] lineToken = stopsList.getSelectionModel().getSelectedItem().toString().split(", ");
            String stopNameTemp = lineToken[0].trim();
            stops.removeDestination(stops.findByName(stopNameTemp));
        }

        loadStops();
    }

    public void addCustomerData(ActionEvent actionEvent) {

        String alert = "There are some mistakes: ";
        int length = alert.length();

        if (!validateEmptyField(fieldCustomerName)) alert += "Name, ";
        if (!validateEmptyField(fieldCustomerAddress)) alert += "Address, ";
        if (!validateEmptyField(fieldCustomerEmail)) alert += "Email, ";
        if (!validateEmptyField(fieldCustomerPhone) || !validateLength(fieldCustomerPhone, 8)) alert += "Phone, ";

        if (length == alert.length()) {
            //save it DataHandler. .....
            boolean isCompany = validateEmptyField(fieldCustomerCompany);

            if (!isCompany) {
                DataHandler.getCustomerList().add(new Customer(fieldCustomerName.getText(), fieldCustomerAddress.getText(), fieldCustomerEmail.getText(), fieldCustomerPhone.getText()));
            } else if (isCompany) {
                DataHandler.getCustomerList().add(new Customer(fieldCustomerName.getText(), fieldCustomerAddress.getText(), fieldCustomerEmail.getText(), fieldCustomerPhone.getText(), isCompany, fieldCustomerCompany.getText()));


                successdisplay("Success", "Customer was created.");
                loadCustomerList();
            } else {
                //alert
                alertdisplay("Wrong Input", alert);
            }


        } else {
            //alert
            alertdisplay("Wrong Input", alert);
        }

    }

    public void chooseCustomer(ActionEvent actionEvent) {

        if (customerList.getSelectionModel().getSelectedItem() != null) {
            customer = (Customer) customerList.getSelectionModel().getSelectedItem();

            Stage stage = (Stage) saveCustomerBtn.getScene().getWindow();
            stage.close();
        } else {
            alertdisplay("No customer", "Please choose one Customer");
        }
    }

    public void setEditData(Trip trip) {
        fieldStartTime.setText(trip.getTimeStart());
        fieldEndTime.setText(trip.getTimeEnd());
        startDatePicker.setValue(trip.getDateStart());
        endDatePicker.setValue(trip.getDateEnd());
        fieldDestination.setValue(trip.getDestination().toString());
        fieldDeparture.setValue(trip.getPickUpPoint().toString());
        fieldDistance.setText(Integer.toString(trip.getDistance()));
        fieldPrice.setText(Integer.toString(trip.getPrice()));
        checkPrivateTrip.setSelected(trip.isPrivate());

        busListview.getSelectionModel().select(trip.getBus());
        busType.setValue(trip.getBus().getBusType());

        if (trip.getStops() != null) {
            stops = trip.getStops();
            loadStops();
        }

        chauffeurList.getSelectionModel().select(trip.getChauffeur());

        if (trip.getChauffeur() != null) {
            chauffeurList.getSelectionModel().select(trip.getCustomer());
        }
    }
}
