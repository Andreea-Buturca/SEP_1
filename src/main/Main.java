package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.Model.Systemm;

import java.lang.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("./View/mainScreen.fxml"));
        primaryStage.setTitle("VIA BUS");
        Scene scene = new Scene(root, 1000, 600);
        scene.getStylesheets().add(getClass().getResource("./View/main.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);

        Systemm systemm = new Systemm();


    }
}
