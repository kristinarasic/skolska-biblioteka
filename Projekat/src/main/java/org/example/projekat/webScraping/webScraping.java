package org.example.projekat.webScraping;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.example.projekat.database.database;
import org.example.projekat.login.menu;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class webScraping extends Application {



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Top 250 books");
        String url = "https://www.goodreads.com/list/show/14220.IMDB_250";
        Map<String, String> books = new HashMap<>();

        Button back = new Button("Go back");
        try {
            database.openConnection();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        try {

            books = webScrapingMethod.scrapeTopBooks(url);



        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        back.setOnAction(e -> {
            menu page = new menu();
            page.start(stage);
        });

        ObservableList<String> bookList = FXCollections.observableArrayList();
        for (Map.Entry<String, String> entry : books.entrySet()) {
            bookList.add(entry.getKey() + " - " + entry.getValue());
        }

        ListView<String> listView = new ListView<>(bookList);

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
        VBox vBox = new VBox(listView, button);
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

