package main.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.Model.*;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by MartinNtb on 27-Nov-16.
 */
public class SearchController extends Controller {


    public ListView matchingCustomers;
    public TextField name;
    public TextField companyName;
    public TextField address;
    public TextField email;
    public TextField phone;
    public TextField destination;
    public TextField departure;
    public DatePicker date;
    public ListView matchingTrips;
    public Button removeReservation;
    public Button removeTrip;

    public void searchCustomer(ActionEvent actionEvent) throws FileNotFoundException, ParseException {
        if (name != null) {
            if (companyName != null) {
                if (address != null) {
                    if (email != null) {
                        if (phone != null) {
                            if (matchingCustomers != null) {
                                CustomerList matching = DataHandler.getCustomerList();
                                if (name.getText() != null && (!name.getText().equals("")))
                                    matching = matching.findAllByName(name.getText());
                                if (address.getText() != null && (!address.getText().equals("")))
                                    matching = matching.findAllByAddress(address.getText());
                                if (email.getText() != null && (!email.getText().equals("")))
                                    matching = matching.findAllByEmail(email.getText());
                                if (phone.getText() != null && (!phone.getText().equals("")))
                                    matching = matching.findAllByPhone(phone.getText());

                                ObservableList<String> items = FXCollections.observableArrayList();
                                for (int i = 0; i < matching.getSize(); i++) {
                                    items.add(matching.getArrayCustomer().get(i).toString());
                                }
                                matchingCustomers.setItems(items);
                            }
                        }
                    }
                }
            }
        }
    }

    public void searchTrip(ActionEvent actionEvent) throws FileNotFoundException, ParseException {
        if (destination != null) {
            if (departure != null) {
                if (date != null) {
                    if (matchingTrips != null) {
                        TripList matching = DataHandler.getTrips();
                        if (destination.getText() != null && (!destination.getText().equals("")))
                            matching = matching.findAllByDestination(destination.getText());
                        if (departure.getText() != null && (!departure.getText().equals("")))
                            matching = matching.findAllByDeparture(departure.getText());
                        if (date.getValue() != null)
                            matching = matching.findAllByDate(date.getValue());
                        ObservableList<String> items = FXCollections.observableArrayList();
                        for (int i = 0; i < matching.getSize(); i++) {
                            items.add(matching.get(i).toString());
                        }
                        matchingTrips.setItems(items);
                    }
                }

            }
        }
    }

    public void removeTrip(ActionEvent actionEvent) {
        ObservableList<String> selected;
        selected = matchingTrips.getSelectionModel().getSelectedItems();
        for (String aSelected : selected) {
            System.out.println(aSelected.toString());
            DataHandler.getTrips().getArrayTrip().remove(DataHandler.getTrips().findByToString(aSelected.toString()));
        }
    }

    public void removeReservation(ActionEvent actionEvent) {
        ObservableList<String> selected;
        selected = matchingCustomers.getSelectionModel().getSelectedItems();
        for (String aSelected : selected) {
            String[] lineToken = aSelected.split(":");
            String phone = lineToken[3].trim();
            System.out.println(phone);
            DataHandler.getCustomerList().remove(DataHandler.getCustomerList().findByPhone(phone));
        }
    }

    public void editReservation(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../View/makeReservationDate.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Scene scene = new Scene(root, 1000, 600);
        Stage window = new Stage();
        ReservationController reservationController = fxmlLoader.<ReservationController>getController();
        reservationController.setEditData((Reservation) DataHandler.getReservationList().getArrayReservation().get(0));
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Edit trip");
        window.setScene(scene);
        window.setResizable(false);
        window.showAndWait();
    }

    public void editTrip(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../View/createTour.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Scene scene = new Scene(root, 1000, 600);
        Stage window = new Stage();
        TripController tripController = fxmlLoader.<TripController>getController();
        tripController.setEditData((Trip) DataHandler.getTrips().get(0));
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Edit trip");
        window.setScene(scene);
        window.setResizable(false);
        window.showAndWait();
    }
}


//make on key method in panel
// create new object of list then call methot find by.... save it on saved call it again

    /*
    Datalist data = new DataList();

    if ..... data = data.find by...
    if ..... data = data.find by...
    if ..... data = data.find by...

    print
     */

    /*private void test (){
        TripTempController.edit(new Trip(DataHandler.getBusList().getAtIndex(0), DataHandler.getDestinationList().getAtIndex(0), null, new Date(2012, 1, 1, 1, 1), new Date(2012, 1, 1, 1, 1)));
    }*/





