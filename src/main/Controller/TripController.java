package main.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by andreea on 11/28/2016.
 */
public class TripController extends Controller implements Initializable {



    public TextField fieldStartDate;
    public TextField fieldStartTime;
    public TextField fieldEndDate;
    public TextField fieldEndTime;
    public TextField fieldDuration;
    public ComboBox fieldDestination;
    public ComboBox fieldDeparture;
    public TextField fieldDistance;
    public TextField fieldPrice;

    public void test(ActionEvent actionEvent) {


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        fieldStartDate.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { // when focus lost
                if (fieldStartDate.getText().equals("xx.xx.xxxx") ) {
                    fieldStartDate.getStyleClass().add("error");
                }
                else {
                    fieldStartDate.getStyleClass().remove("error");
                }
            }
        });
        fieldStartTime.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { // when focus lost
                if (fieldStartTime.getText().equals("xx.xx.xxxx") ) {
                    fieldStartTime.getStyleClass().add("error");
                }
                else {
                    fieldStartTime.getStyleClass().remove("error");
                }
            }
        });

        fieldEndDate.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { // when focus lost
                if (fieldEndDate.getText().equals("xx.xx.xxxx") ) {
                    fieldEndDate.getStyleClass().add("error");
                }
                else {
                    fieldEndDate.getStyleClass().remove("error");
                }
            }
        });
        fieldEndTime.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { // when focus lost
                if (fieldEndTime.getText().equals("xx.xx.xxxx") ) {
                    fieldEndTime.getStyleClass().add("error");
                }
                else {
                    fieldEndTime.getStyleClass().remove("error");
                }
            }
        });
        fieldDuration.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { // when focus lost
                if (fieldDuration.getText().equals("xx.xx.xxxx") ) {
                    fieldDuration.getStyleClass().add("error");
                }
                else {
                    fieldDuration.getStyleClass().remove("error");
                }
            }
        });
        fieldDeparture.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { // when focus lost
                if (fieldDeparture.getValue().equals("xx.xx.xxxx") ) {
                    fieldDeparture.getStyleClass().add("error");
                }
                else {
                    fieldDeparture.getStyleClass().remove("error");
                }
            }
        });
        fieldDistance.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { // when focus lost
                if (fieldDistance.getText().equals("xx.xx.xxxx") ) {
                    fieldDistance.getStyleClass().add("error");
                }
                else {
                    fieldDistance.getStyleClass().remove("error");
                }
            }
        });
        fieldPrice.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { // when focus lost
                if (fieldPrice.getText().equals("xx.xx.xxxx") ) {
                    fieldPrice.getStyleClass().add("error");
                }
                else {
                    fieldPrice.getStyleClass().remove("error");
                }
            }
        });
    }
}
