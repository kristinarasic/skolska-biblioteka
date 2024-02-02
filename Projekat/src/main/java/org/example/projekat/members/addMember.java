package org.example.projekat.members;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.example.projekat.database.database;
import org.example.projekat.exceptions.invalidLoginException;
import org.example.projekat.login.menu;

import java.sql.SQLException;


public class addMember extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button back = new Button("Go back");

        Label memberIndex = new Label("Member index:");
        Label name = new Label("Name:");
        Label lastname = new Label("Last name:");
        Label email = new Label("Email:");
        Label phoneNumber = new Label("Phone number:");
        Label grade = new Label("Grade::");
        Label age = new Label("Age:");

        TextField memberIndexInput = new TextField();
        TextField nameInput = new TextField();
        TextField lastnameInput = new TextField();
        TextField emailInput = new TextField();
        TextField phoneNumberInput = new TextField();
        TextField gradeInput = new TextField();
        TextField ageInput = new TextField();

        memberIndexInput.setPromptText("Enter member index");
        nameInput.setPromptText("Enter name");
        lastnameInput.setPromptText("Enter lastname");
        emailInput.setPromptText("Enter email");
        phoneNumberInput.setPromptText("Enter phone number");
        gradeInput.setPromptText("Enter grade");
        ageInput.setPromptText("Enter age");

        HBox memberIndexBox = new HBox(memberIndex,memberIndexInput);
        HBox nameBox = new HBox(name,nameInput);
        HBox lastnameBox = new HBox(lastname,lastnameInput);
        HBox emailBox = new HBox(email,emailInput);
        HBox phoneNumberBox = new HBox(phoneNumber,phoneNumberInput);
        HBox gradeBox = new HBox(grade,gradeInput);
        HBox ageBox = new HBox(age,ageInput);

        Button addMemberButton = new Button("Add member");

        addMemberButton.setOnAction(e -> {
            String memberIndexData = memberIndexInput.getText();
            String nameData = nameInput.getText();
            String lastnameData = lastnameInput.getText();
            String emailData = emailInput.getText();
            String phoneNumberData = phoneNumberInput.getText();
            String gradeData = gradeInput.getText();
            String ageData = ageInput.getText();
            if (!memberIndexData.matches("\\d+") || !gradeData.matches("\\d+") || !ageData.matches("\\d+") || memberIndexData.isBlank() || lastnameData.isBlank() || emailData.isBlank() || phoneNumberData.isBlank() || gradeData.isBlank() || ageData.isBlank() || Integer.parseInt(gradeData) > 8 || Integer.parseInt(ageData) > 16) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please input all values corectly.");
                alert.showAndWait();



            }
            else{

            try {
                database.openConnection();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            try {
                addMemberMethod.addMember(memberIndexData, nameData, lastnameData, emailData, phoneNumberData, gradeData, ageData);
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Member added!", ButtonType.CLOSE);
                a.showAndWait();



            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (invalidLoginException ex) {
                throw new RuntimeException(ex);
            }
            menu page = new menu();
            page.start(stage);}
        });
        back.setOnAction(e -> {
            menu page = new menu();
            page.start(stage);
        });
        Image backgroundImage = new Image("file:src/main/java/org/example/projekat/img/books.jpg");

        // Create a background image
        BackgroundImage background = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        HBox buttons = new HBox(addMemberButton,back);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);
        buttons.setStyle("-fx-font-size: 15");
        VBox v = new VBox(memberIndexBox, nameBox, lastnameBox, emailBox,phoneNumberBox, gradeBox, ageBox, buttons);
        v.setAlignment(Pos.CENTER);
        v.setSpacing(10);
        v.setPadding(new Insets(50));
        v.setBackground(new Background(background));

        Scene scene = new Scene(v, 500, 400);
        stage.setTitle("Add member!");
        stage.setScene(scene);
        stage.show();

    }



}
