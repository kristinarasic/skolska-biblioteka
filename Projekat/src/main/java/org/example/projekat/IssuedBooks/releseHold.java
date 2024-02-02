package org.example.projekat.IssuedBooks;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.example.projekat.database.database;
import org.example.projekat.login.menu;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;


public class releseHold extends Application {
    /**
     *
     * @param args
     */

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        ComboBox<String> issuedBooks = new ComboBox<>();
        Button back = new Button("Go back");

        Set<String> issuedBooksData = new HashSet<>();
        try {
            database.openConnection();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        issuedBooksData = releseHoldMethod.issuedBooksData();
        issuedBooks.getItems().addAll(issuedBooksData);



        Button releseHold = new Button("Relese hold");

        Set<String> finalIsssuedBookData = issuedBooksData;
        releseHold.setOnAction(event -> {
            try {
                releseHoldMethod.releaseHold(issuedBooks.getValue());
                finalIsssuedBookData.clear();
                finalIsssuedBookData.addAll(releseHoldMethod.issuedBooksData());
                issuedBooks.getItems().clear();
                issuedBooks.getItems().addAll(finalIsssuedBookData);


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        });
        back.setOnAction(e -> {
            menu page = new menu();
            page.start(stage);
        });



        Image backgroundImage = new Image("file:C:\\Users\\Tina\\Desktop\\books.jpg");
        VBox button = new VBox(releseHold,back);
        button.setStyle("-fx-font-size: 16; -fx-padding: 135");
        button.setSpacing(20);
        button.setAlignment(Pos.CENTER);

        BackgroundImage background = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);


        HBox root = new HBox(10);
        root.getChildren().addAll(issuedBooks);
        VBox vbox = new VBox();
        vbox.setFillWidth(true);

        vbox.setBackground(new Background(background));
        vbox.setStyle("-fx-padding: 30");
        vbox.getChildren().addAll(root,button);

        Scene scene = new Scene(vbox, 600, 400);
        stage.setTitle("Relese Book");
        stage.setScene(scene);

        stage.show();
    }
}
