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


public class IssueBook extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        ComboBox<String> members = new ComboBox<>();
        Button back = new Button("Go back");
        back.setOnAction(e -> {
            menu page = new menu();
            page.start(stage);
        });
        Set<String> membersData = new HashSet<>();        try {
            database.openConnection();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        membersData = IssueBookMethod.membersData();
        members.getItems().addAll(membersData);

        ComboBox<String> books = new ComboBox<>();
        Set<String> bookData = new HashSet<>();

        bookData = IssueBookMethod.bookCopyData();
        books.getItems().addAll(bookData);

        Button issueBook = new Button("issue the book");

        Set<String> finalMembersData = membersData;
        Set<String> finalBookData = bookData;
        issueBook.setOnAction(event -> {
            try {
                IssueBookMethod.issue(members.getValue(), books.getValue());
                finalMembersData.clear();
                finalMembersData.addAll(IssueBookMethod.membersData());
                members.getItems().clear();
                members.getItems().addAll(finalMembersData);

                finalBookData.clear();
                finalBookData.addAll(IssueBookMethod.bookCopyData());
                books.getItems().clear();
                books.getItems().addAll(finalBookData);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        });
        Image backgroundImage = new Image("file:src/main/java/org/example/projekat/img/books.jpg");
        VBox button = new VBox(issueBook,back);
        button.setStyle("-fx-font-size: 18; -fx-padding: 135");
        button.setSpacing(20);
        button.setAlignment(Pos.CENTER);

        BackgroundImage background = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);


        HBox root = new HBox(10);
        root.getChildren().addAll(books, members);
        VBox vbox = new VBox();
        vbox.setFillWidth(true);

        vbox.setBackground(new Background(background));
        vbox.setStyle("-fx-padding: 30");
        vbox.getChildren().addAll(root,button);
        Scene scene = new Scene(vbox, 600, 400);
        stage.setTitle("Issue Book");
        stage.setScene(scene);

        stage.show();
    }
}
