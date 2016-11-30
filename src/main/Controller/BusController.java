package main.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import main.Model.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;

/**
 * Created by MartinNtb on 28-Nov-16.
 */
public class BusController extends Controller implements Initializable {


    public ListView busListview;
    public Button deleteBus;
    public Button addBus;
    public TextField regPlate;
    public TextField seatNumber;
    public ChoiceBox typeChoice;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (busListview != null) {  // BusController is shared between buslist and add bus,
                                    // in add bus there is no listview so i have to use that condition
            try {
                busListview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                BusFile file = new BusFile("BusList.txt");
                BusList buslist = file.readFile();
                ObservableList<String> items = FXCollections.observableArrayList();
                for (int i = 0; i < buslist.getSize(); i++) {
                    items.add(buslist.getAtIndex(i).toString());
                }
                busListview.setItems(items);
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


    public void deleteBus(ActionEvent actionEvent) throws FileNotFoundException, ParseException {
        ObservableList<String> selected;
        selected = busListview.getSelectionModel().getSelectedItems();
        BusFile file = new BusFile("BusList.txt");
        BusList buslist = file.readFile();
        for (int i = 0; i < selected.size(); i++) {
            String[] lineToken = selected.get(i).split(", ");
            String regPlate = lineToken[0].trim();
            Bus bus = buslist.findByRegplate(regPlate);
            buslist.removeBus(bus);
        }
        file.writeTextFile(buslist);
        try {
            buslist = file.readFile();
            ObservableList<String> items = FXCollections.observableArrayList();
            for (int i = 0; i < buslist.getSize(); i++) {
                items.add(buslist.getAtIndex(i).toString());
            }
            busListview.setItems(items);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


    public void addBus(ActionEvent actionEvent) throws FileNotFoundException, ParseException {
        BusFile file = new BusFile("BusList.txt");
        BusList buslist = file.readFile();

        // String type = (String) typeChoice.getSelectionModel().getSelectedItem();
        String regplate = regPlate.getText();
        int seats = Integer.parseInt(seatNumber.getText());
        Bus bus = new Bus(regplate, seats);

      /*  int seats = Integer.parseInt(seatNumber.getTypeSelector());
        if (type.equals("Classic Bus")) {
            bus = new ClasicBus(regplate,seats);
        } else if (type.equals("Mini Bus")) {
            bus = new MiniBus(regplate,seats);
        } else if (type.equals("Party Bus")) {
            bus = new PartyBus(regplate,seats);
        } else if (type.equals("Luxury Bus")) {
            bus = new LuxuryBus(regplate,seats);
        }*/
        // TODO: 29-Nov-16 if we are going to use more classes than we have to solve this also.

        buslist.addBus(bus);
        file.writeTextFile(buslist);

    }
}
