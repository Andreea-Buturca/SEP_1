package main.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by MartinNtb on 27-Nov-16.
 */
public class ReservationController extends Controller {

    public Button mkReservationView;

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
}



