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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

/**
 * Created by MartinNtb on 27-Nov-16.
 */
public class SearchController extends Controller {


    public ListView matchingReservations;
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
        findReservations();
    }

    private void findReservations() {
        if (name != null) {
            if (companyName != null) {
                if (address != null) {
                    if (email != null) {
                        if (phone != null) {
                            if (matchingReservations != null) {
                                CustomerList matching = DataHandler.getCustomerList();
                                if (name.getText() != null && (!name.getText().equals("")))
                                    matching = matching.findAllByName(name.getText());
                                if (address.getText() != null && (!address.getText().equals("")))
                                    matching = matching.findAllByAddress(address.getText());
                                if (email.getText() != null && (!email.getText().equals("")))
                                    matching = matching.findAllByEmail(email.getText());
                                if (phone.getText() != null && (!phone.getText().equals("")))
                                    matching = matching.findAllByPhone(phone.getText());
                                ReservationList reservations = DataHandler.getReservationList();
                                ObservableList<Reservation> items = FXCollections.observableArrayList();
                                for (int i = 0; i < matching.getSize(); i++) {
                                    for (int j = 0; j < reservations.getSize(); j++) {
                                        if (reservations.getReservation(j).getCustomer().equals(matching.getCustomer(i))) {
                                            items.add(reservations.getReservation(j));
                                        }
                                    }

                                }
                                matchingReservations.setItems(items);
                            }
                        }
                    }
                }
            }
        }
    }

    public void searchTrip(ActionEvent actionEvent) throws FileNotFoundException, ParseException {
       findTrips();
    }

    private void findTrips(){
        if (matchingTrips != null) {
            TripList matching = DataHandler.getTrips();
            if (destination.getText() != null && (!destination.getText().equals("")))
                matching = matching.findAllByDestination(destination.getText());
            if (departure.getText() != null && (!departure.getText().equals("")))
                matching = matching.findAllByDeparture(departure.getText());
            if (date.getValue() != null)
                matching = matching.findAllByDate(date.getValue());
            ObservableList<Trip> items = FXCollections.observableArrayList();
            for (int i = 0; i < matching.getSize(); i++) {
                items.add(matching.get(i));
            }
            matchingTrips.setItems(items);
        }
    }

    public void removeTrip(ActionEvent actionEvent) {
        ObservableList<Trip> selected;
        selected = matchingTrips.getSelectionModel().getSelectedItems();
        for (Trip aSelected : selected) {
            DataHandler.getTrips().getArrayTrip().remove(aSelected);
        }
        findTrips();
    }

    public void removeReservation(ActionEvent actionEvent) {
        ObservableList<Reservation> selected;
        selected = matchingReservations.getSelectionModel().getSelectedItems();
        for (Reservation aSelected : selected) {
            DataHandler.getReservationList().remove(aSelected);
        }
        findReservations();
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
        if (matchingTrips.getSelectionModel().getSelectedItem() != null) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../View/createTour.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Scene scene = new Scene(root, 1000, 600);
            Stage window = new Stage();
            TripController tripController = fxmlLoader.<TripController>getController();
            tripController.setEditData((Trip) matchingTrips.getSelectionModel().getSelectedItem());
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("Edit trip");
            window.setScene(scene);
            window.setResizable(false);
            window.showAndWait();
        }
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





