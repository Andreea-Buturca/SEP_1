package main.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by MartinNtb on 28-Nov-16.
 */
public class TestController implements Initializable {


    public TextField testtext;
    public Button testbtn;
    public CheckBox testcheck;

    public void test(ActionEvent actionEvent) throws IOException {

        if (actionEvent.getSource() == testbtn) {
            Parent root = FXMLLoader.load(getClass().getResource("../View/mainScreen.fxml"));
            Scene scene = new Scene(root, 1000, 600);
            Stage window = new Stage();
            window.setScene(scene);
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("itile");
            window.showAndWait();
        }


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        testtext.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) {

                if (!testtext.getText().matches("[1-5](\\.[0-9]{1,2}){0,1}|6(\\.0{1,2}){0,1}")) {
                    // when it not matches the pattern (1.0 - 6.0)
                    // set the textField empty
                    testtext.getStyleClass().add("error");
                }
                else {
                    testtext.getStyleClass().remove("error");
                }
            }
        });
    }

    public void novva(ActionEvent actionEvent) {
        System.out.println("check");
    }
}
