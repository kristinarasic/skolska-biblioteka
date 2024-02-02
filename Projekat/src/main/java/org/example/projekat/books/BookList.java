package org.example.projekat.books;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.example.projekat.database.database;
import org.example.projekat.login.menu;

import java.sql.SQLException;

public class BookList extends Application {



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Book List!");

        ListView<String> list = new ListView<>();
        Button back = new Button("Go back");
        try {
            database.openConnection();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        try {

            list = BookListMethod.showBooks();



        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        back.setOnAction(e -> {
            menu page = new menu();
            page.start(stage);
        });

        Image backgroundImage = new Image("file:src/main/java/org/example/projekat/img/books.jpg");
        HBox button = new HBox(back);
        button.setStyle("-fx-font-size: 23");
        button.setStyle("-fx-padding: 15");
        button.setAlignment(Pos.CENTER);

        BackgroundImage background = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        VBox vBox = new VBox(list, button);
        vBox.setFillWidth(true);
        vBox.setStyle("-fx-padding: 30");
        vBox.setAlignment(Pos.CENTER);
        vBox.setBackground(new Background(background));
        Scene scene = new Scene(vBox, 500, 600);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

}

