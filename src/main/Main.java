package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import main.Model.DataHandler;

import java.util.Optional;

public class Main extends Application {

    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("./View/mainScreen.fxml"));
        primaryStage.setTitle("VIA BUS");
        Scene scene = new Scene(root, 1000, 600);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        stage = primaryStage;
        stage.setOnCloseRequest(we -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm Exit");
            alert.setHeaderText("You are trying to close VIA Bus");
            alert.setContentText("Are you ok with this? (Back up will be created)");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                DataHandler.save();
                DataHandler.backUp();
                stage.close();
            } else {
                we.consume();
            }
        });

    }

    public static void main(String[] args) {

        //DataHandler.testCreate();

        DataHandler.load();

        launch(args);
    }
}



/*NOTES and Qs:


Discuss

Date Constructor Date(int year, int month, int date)
!!! (year + 1900, month, date)
or Date(int year, int month, int date, int hrs, int min)

1. Do we have to handle all the exceptions?
2. What about testclass? We test in main and the whole program.











 */