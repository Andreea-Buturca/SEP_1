package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.Model.DataHandler;

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
    }

    public static void main(String[] args) {

//for now just creating empty objects
        DataHandler.testCreate();

        //creating test data
        DataHandler.testData();

        //DataHandler.load();

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