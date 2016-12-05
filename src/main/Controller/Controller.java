package main.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import main.Main;
import main.Model.DataHandler;
import main.Model.Reservation;
import main.Model.Trip;
import main.Model.TripList;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public MenuBar menu;
    public MenuItem homeHome;
    public MenuItem homeTour;
    public MenuItem homeReserve;
    public MenuItem homeSearch;
    public MenuItem homeBus;
    public MenuItem homeBusAdd;
    public MenuItem homeDriver;
    public MenuItem homeDriverAdd;


    //main screen
    public Button createTour;
    public Button mkReservation;
    public Button findTrip;
    //tripList
    public ListView tripList;
    public TableColumn departureCol;
    public TableColumn destinationCol;
    public TableColumn durationCol;
    public TableColumn chauffeurCol;
    public TableColumn busCol;
    public TableColumn tourCol;
    public TableColumn freeCol;
    public TableColumn priceCol;


    //bus list
    public Button addBusView;

    //chauffeur list
    public Button addChauffeur;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (tripList != null) {
            showList();
        }
        System.out.println(DataHandler.getReservationList().getArrayReservation().toString());
    }

    private void showList() {
        TripList trips = DataHandler.getTrips();
        ObservableList<Trip> data = FXCollections.observableArrayList();
        for (int i = 0; i < trips.getSize(); i++) {
            data.add(trips.get(i));
        }
        tripList.setItems(data);
    }

    //todo how much he paid, times

    public void changeView(MouseEvent mouseEvent) throws IOException {

        Parent root = null;

        //main
        if ((mouseEvent.getSource() == createTour)) {
            root = FXMLLoader.load(getClass().getResource("../View/createTour.fxml"));
        } else if ((mouseEvent.getSource() == mkReservation)) {
            root = FXMLLoader.load(getClass().getResource("../View/makeReservation.fxml"));
        } else if ((mouseEvent.getSource() == findTrip)) {
            root = FXMLLoader.load(getClass().getResource("../View/search.fxml"));
        }

        //bus view
        else if ((mouseEvent.getSource() == addBusView)) {
            root = FXMLLoader.load(getClass().getResource("../View/addBus.fxml"));
        }

        //chauffeur view
        else if ((mouseEvent.getSource() == addChauffeur)) {
            root = FXMLLoader.load(getClass().getResource("../View/AddChauffeur.fxml"));
        } else {
            // root = FXMLLoader.load(getClass().getResource("../View/mainScreen.fxml"));
        }

        if (root != null) {
            Scene scene = new Scene(root);

            Main.stage.setScene(scene);
            Main.stage.show();
        }
    }


    public void changeViewMenu(ActionEvent actionEvent) throws IOException {

        Parent root = null;

        if ((actionEvent.getSource() == homeHome)) {
            root = FXMLLoader.load(getClass().getResource("../View/mainScreen.fxml"));
        } else if ((actionEvent.getSource() == homeTour)) {
            root = FXMLLoader.load(getClass().getResource("../View/createTour.fxml"));
        } else if ((actionEvent.getSource() == homeBus)) {
            root = FXMLLoader.load(getClass().getResource("../View/busList.fxml"));
        } else if ((actionEvent.getSource() == homeBusAdd)) {
            root = FXMLLoader.load(getClass().getResource("../View/addBus.fxml"));
        } else if ((actionEvent.getSource() == homeReserve)) {
            root = FXMLLoader.load(getClass().getResource("../View/makeReservation.fxml"));
        } else if ((actionEvent.getSource() == homeSearch)) {
            root = FXMLLoader.load(getClass().getResource("../View/search.fxml"));
        } else if ((actionEvent.getSource() == homeDriver)) {
            root = FXMLLoader.load(getClass().getResource("../View/chauffeurList.fxml"));
        } else if ((actionEvent.getSource() == homeDriverAdd)) {
            root = FXMLLoader.load(getClass().getResource("../View/addChauffeur.fxml"));
        } else {
            //root = FXMLLoader.load(getClass().getResource("./View/mainScreen.fxml"));
        }


        if (root != null) {
            Scene scene = new Scene(root);
            Main.stage.setScene(scene);
            Main.stage.show();
        }

    }

    protected void test() {
    }


    protected boolean validateEmptyField(TextField textField) {
        return !textField.getText().isEmpty();

    }

    protected boolean validateNumberField(TextField textField) {
        return textField.getText().matches("[0-9]+");

    }

    protected boolean validateNumberPlate(TextField textField) {
        return textField.getText().matches("[A-Z]{2}[0-9]{5}");

    }

    protected boolean validateLength(TextField textField, int length) {
        if (length < 1) length = length * (-1);
        return textField.getText().length() == length;

    }

    protected boolean validateTimeField(TextField textField) {
        return textField.getText().matches("([01]?[0-9]|2[0-3]):[0-5][0-9]");

    }

    protected boolean validateEmptyDate(DatePicker datePicker) {
        return datePicker.getValue() != null;

    }

    protected boolean validateEmptyCombo(ComboBox comboBox) {
        return comboBox.getValue() != null;

    }


    protected void alertdisplay(String title, String message) {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    protected void successdisplay(String title, String message) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

