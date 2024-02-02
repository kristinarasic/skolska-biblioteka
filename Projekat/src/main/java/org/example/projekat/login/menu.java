package org.example.projekat.login;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.example.projekat.IssuedBooks.IssueBook;
import org.example.projekat.IssuedBooks.IssuedBookList;
import org.example.projekat.IssuedBooks.releseHold;
import org.example.projekat.books.BookList;
import org.example.projekat.books.addBook;
import org.example.projekat.members.addMember;
import org.example.projekat.webScraping.webScraping;

import java.io.IOException;

public class menu extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        BorderPane bp = new BorderPane();
        VBox v = new VBox(10);
        Button addBook = new Button("Add book");
        Button addMember = new Button("Add member");
        Button issuedBookList = new Button("Issued book list");
        Button bookList = new Button("Book list");
        Button issueBook = new Button("Issue book");
        Button releseHold = new Button("Relese hold");
        Button goodreadsTop250 = new Button("goodreads top 250 books");
        Button logout = new Button("Log out!");
        Image backgroundImage = new Image("file:src/main/java/org/example/projekat/img/books.jpg");

        // Create a background image
        BackgroundImage background = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        v.borderProperty();
        v.setAlignment(Pos.CENTER);
        v.setStyle("-fx-font-size: 15");
        v.setBackground(new Background(background));
        v.getChildren().addAll(addBook,addMember,issuedBookList,bookList,issueBook, releseHold, goodreadsTop250, logout);
        Scene scene = new Scene(v, 500, 400);
        stage.setTitle("Menu");
        addBook.setOnAction(e -> {
            org.example.projekat.books.addBook page = new addBook();
            page.start(stage);
        });
        addMember.setOnAction(e -> {
            org.example.projekat.members.addMember page = new addMember();
            page.start(stage);
        });
        issuedBookList.setOnAction(e -> {
            IssuedBookList page = new IssuedBookList();
            page.start(stage);
        });

        bookList.setOnAction(e -> {
            BookList page = new BookList();
            page.start(stage);
        });
        issueBook.setOnAction(e -> {
            IssueBook page = new IssueBook();
            page.start(stage);
        });
        releseHold.setOnAction(e -> {
            org.example.projekat.IssuedBooks.releseHold page = new releseHold();
            page.start(stage);
        });
        goodreadsTop250.setOnAction(e -> {
            org.example.projekat.webScraping.webScraping page = new webScraping();
            page.start(stage);
        });
        logout.setOnAction(e -> {
            org.example.projekat.login.login page = new login();
            try {
                page.start(stage);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });


        stage.setScene(scene);
        stage.show();
    }
}
