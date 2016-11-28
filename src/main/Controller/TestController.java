package main.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by MartinNtb on 28-Nov-16.
 */
public class TestController implements Initializable {


    public TextField testtext;

    public void test(ActionEvent actionEvent) {


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //testtext.getBackground();
        System.out.println(testtext.getBackground());
        System.out.println(testtext.getBorder());

        testtext.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { // when focus lost
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
}
