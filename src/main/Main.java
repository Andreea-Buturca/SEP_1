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
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        stage = primaryStage;
    }


    // TODO: 05-Dec-16 For Marek

    //in createtour try to fill distance to show it


    //change items in combobox, choicebox to normal Object like Bus, Trip ...,  not object to strings and then to object


    // TODO: 05-Dec-16 frequent customer


    public static void main(String[] args) {

//for now just creating empty objects
        DataHandler.testCreate();

        //creating test data
        DataHandler.testData();

        // TODO: 30-Nov-16 make load from file when done
        // TODO: 30-Nov-16 override onclose to make backup
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