package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.Model.DataHandler;

import java.lang.*;

public class Main extends Application {

    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("./View/mainScreen.fxml"));
        primaryStage.setTitle("VIA BUS");
        Scene scene = new Scene(root, 1000, 600);
        scene.getStylesheets().add(getClass().getResource("./View/main.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        stage = primaryStage;
    }


    public static void main(String[] args) {

//for now just creating empty objects
        DataHandler.testCreate();


        // TODO: 30-Nov-16 make load from file when done
        // TODO: 30-Nov-16 override onclose to make backup
        //DataHandler.load();

        launch(args);
    }
}
/*NOTES and Qs:
1. Do we have to handle all the exceptions?











 */