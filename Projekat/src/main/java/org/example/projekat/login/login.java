package org.example.projekat.login;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.example.projekat.database.database;

import java.io.IOException;
import java.sql.SQLException;

public class login extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Label username = new Label("Username:");
        Label password = new Label("Password:");
        TextField usernameInput = new TextField();
        PasswordField passwordInput = new PasswordField();
        String s = usernameInput.toString();
        usernameInput.setPromptText("Enter username");
        passwordInput.setPromptText("*******");
        Button loginButton = new Button("Log in");

        loginButton.setOnAction(e -> {
            String usernameData = usernameInput.getText();
            String passwordData = passwordInput.getText();

            try {
                database.openConnection();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            try {
                if(loginMethods.userAcc(usernameData,passwordData)){
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Logged in!", ButtonType.CLOSE);
                a.showAndWait();
                    menu page = new menu();
                    page.start(stage);
                }
                else{
                    Alert b = new Alert(Alert.AlertType.INFORMATION, "Incorrect", ButtonType.CLOSE);


                    b.showAndWait();
                }

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        });
        Image backgroundImage = new Image("file:C:\\Users\\Tina\\Desktop\\books.jpg");

        // Create a background image
        BackgroundImage background = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        VBox login = new VBox(username, usernameInput, password, passwordInput, loginButton);
        login.setAlignment(Pos.CENTER);
        login.setStyle("-fx-font-size: 15");
        login.setSpacing(10);
        loginButton.setStyle("-fx-background-color: #d8e4d2 ");
        login.setPadding(new Insets(50));
        login.setBackground(new Background(background));
        Scene scene = new Scene(login, 500, 400);

        stage.setTitle("LOG IN!");
        stage.setScene(scene);
        stage.show();


    }


    public static void main(String[] args) {
        launch();
    }
}