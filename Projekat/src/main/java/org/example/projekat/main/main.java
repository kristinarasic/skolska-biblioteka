package org.example.projekat.main;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.projekat.login.login;

public class main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        login login = new login();


        try {
            login.start(primaryStage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
