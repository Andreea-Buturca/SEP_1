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
import javafx.stage.Window;
import main.Model.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by andreea on 11/28/2016.
 */
public class TripTempController extends Controller implements Initializable {


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

    //list for stops
    private DestinationList stops = new DestinationList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if (toggleHours != null) {
            toggleHours.setOnAction(event -> toggleHours.setText((toggleHours.getText().equals("Hours")) ? "Days" : "Hours"));

            loadBusList();
            loadChauffeurList();

            ObservableList<String> destinationItems = FXCollections.observableArrayList();
            for (Destination destination : DataHandler.getDestinationList().getArrayDestination()) {
                destinationItems.add(destination.toString());
            }
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


                    // TODO: 30-Nov-16 get somehow data from here


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
        if (!validateEmptyField(fieldDuration) || !validateNumberField(fieldDuration)) alert += "Duration, ";
        if (!validateEmptyField(fieldDistance) || !validateNumberField(fieldDistance)) alert += "Distance, ";
        if (!validateEmptyField(fieldPrice) || !validateNumberField(fieldPrice)) alert += "Price, ";
        if (!validateEmptyCombo(fieldDestination)) alert += "Destination, ";
        if (!validateEmptyCombo(fieldDeparture)) alert += "Departure, ";
        if (busListview.getSelectionModel().getSelectedItem() == null) alert += "Bus, ";
        if (chauffeurList.getSelectionModel().getSelectedItem() == null) alert += "Chauffeur, ";

        if (checkPrivateTrip.isSelected()) {
            //System.out.println(tests.getText());
        }

        // TODO: 30-Nov-16 check if selected bus and chauffeur from list

        if (length == alert.length()) {
            //save it DataHandler. .....
            String[] lineToken = busListview.getSelectionModel().getSelectedItem().toString().split(", ");
            String regPlate = lineToken[0].trim();
            // TODO: 01-Dec-16 finish creating trip
            // DataHandler.getTrips().add(new Trip(DataHandler.getBusList().findByRegplate(regPlate), ));


        } else {
            //alert
            alertdisplay("Wrong Input", alert);
        }
    }

    public void addCustomerData(ActionEvent actionEvent) {

        Window window = saveCustomerBtn.getScene().getWindow();
        //System.out.println(tests.getText());
        window.getOnCloseRequest();
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

        // TODO: 02-Dec-16 waiting for bus model

        chauffeurList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        ObservableList<String> items = FXCollections.observableArrayList();
        for (Chauffeur chauffeur : chauffeurs.getArrayChauffeur()) {
            items.add(chauffeur.getName());
        }
        chauffeurList.setItems(items);
    }

    private void loadBusList() {

        ArrayList<Bus> busArray;

        if (busType.getValue().equals("Mini Bus"))
            busArray = DataHandler.getBusList().searchByType("main.Model.MiniBus");
        else if (busType.getValue().equals("Party Bus"))
            busArray = DataHandler.getBusList().searchByType("main.Model.PartyBus");
        else if (busType.getValue().equals("Luxury Bus"))
            busArray = DataHandler.getBusList().searchByType("main.Model.LuxuryBus");
        else busArray = DataHandler.getBusList().searchByType("main.Model.ClassicBus");

        // TODO: 02-Dec-16 waiting for bus model

        busListview.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        ObservableList<String> items = FXCollections.observableArrayList();
        for (Bus bus : busArray) {
            items.add(bus.toString());
        }
        busListview.setItems(items);


    }

    public void loadCustomerList() {
        CustomerList customers = DataHandler.getCustomerList();
        ArrayList<Customer> searchedCustomers = new ArrayList<>();

        if (validateEmptyField(fieldCustomerName))
            if (customers.findByName(fieldCustomerName.getText()) != null)
                searchedCustomers.add(customers.findByName(fieldCustomerName.getText()));
        if (validateEmptyField(fieldCustomerPhone))
            if (customers.findByPhone(fieldCustomerPhone.getText()) != null)
                searchedCustomers.add(customers.findByPhone(fieldCustomerPhone.getText()));
        if (validateEmptyField(fieldCustomerCompany))
            if (customers.findByCompany(fieldCustomerCompany.getText()) != null)
                searchedCustomers.add(customers.findByCompany(fieldCustomerCompany.getText()));

        ObservableList<String> customerItems = FXCollections.observableArrayList();

        if (searchedCustomers.size() != 0) {
            for (Customer customer : searchedCustomers) {
                customerItems.add(customer.toString());
            }
        } else {
            for (Customer customer : customers.getArrayCustomer()) {
                customerItems.add(customer.toString());
            }
        }

        customerList.setItems(customerItems);
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


        ObservableList<String> destinationItems = FXCollections.observableArrayList();
        for (Destination destination : stops.getArrayDestination()) {
            destinationItems.add(destination.getStopString());
        }
        stopsList.setItems(destinationItems);
    }

    public static void edit(Trip trip) {



    }

    public void editTour(ActionEvent actionEvent) {

    }
}
