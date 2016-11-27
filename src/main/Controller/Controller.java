package main.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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

    //bus list
    public Button addBus;
    public CheckBox checkPrivateTrip;
    public ToggleButton toggleHours;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if (!(null == checkPrivateTrip)) {
            checkPrivateTrip.setOnAction(event -> {
                System.out.println("test");
            });
            toggleHours.setOnAction(event -> toggleHours.setText((toggleHours.getText().equals("Hours")) ? "Days" : "Hours"));
        }

    }

    public void changeView(MouseEvent mouseEvent) throws IOException {

        Stage stage;
        Parent root;

        if ((mouseEvent.getSource() == createTour)) {
            stage = (Stage) createTour.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../View/createTour.fxml"));
        } else if ((mouseEvent.getSource() == addBus)) {
            stage = (Stage) addBus.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../View/addBus.fxml"));
        }else if ((mouseEvent.getSource() == mkReservation)) {
            stage = (Stage) mkReservation.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../View/makeReservation.fxml"));
        } else {
            stage = (Stage) createTour.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../View/mainScreen.fxml"));
        }


        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void changeViewMenu(ActionEvent actionEvent) throws IOException {

        Stage stage = (Stage) menu.getScene().getWindow();
        Parent root;

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
        }



/*
        public MenuItem homeReserve;
        public MenuItem homeSearch;
        public MenuItem homeDriver;
        public MenuItem homeDriverAdd;*/


        else {
            root = FXMLLoader.load(getClass().getResource("./View/mainScreen.fxml"));
        }


        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


    //@TODO move it to another class

    /*public void loadFile(String filename){

    }
    public int getNumberOfSeatsAvailable(Bus bus){
        return 0;
    }
    public void showList(){

    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    public void modifyReservation(Trip reservation){

    }
    public void saveReservationToFile(String file, Trip reservation){

    }
    public void deleteReservation(Trip reservation){

    }
    public void hireEmployee(){

    }
    public void makeReservatioon(){

    }
    public void findCustomer(Customer customer){

    }
    public void pickSeat(){

    }
    public void giveDiscount(double percentge){

    }
    public void RentBusAndChauffeur(){

    }*/
}

