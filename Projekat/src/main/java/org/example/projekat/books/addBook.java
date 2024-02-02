package org.example.projekat.books;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.example.projekat.database.database;
import org.example.projekat.exceptions.exceptions;
import org.example.projekat.exceptions.invalidLoginException;
import org.example.projekat.login.menu;


import java.sql.SQLException;

public  class addBook extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {



        Label title = new Label("Title:");
        Label author = new Label("Author:");
        Label ISBN = new Label("ISBN:");
        Label publishingYear = new Label("publishing year:");
        Label numberOfCopies = new Label("Number of copies:");
        Label rating = new Label("Rating:");

        TextField titleInput = new TextField();
        TextField authorInput = new TextField();
        TextField ISBNInput = new TextField();
        TextField publishingYearInput = new TextField();
        TextField numberOfCopiesInput = new TextField();
        TextField ratingInput = new TextField();

        titleInput.setPromptText("Enter title");
        authorInput.setPromptText("Enter author");
        ISBNInput.setPromptText("Enter ISBN");
        publishingYearInput.setPromptText("Enter publishing year");
        numberOfCopiesInput.setPromptText("Enter number of copies");
        ratingInput.setPromptText("Enter rating");

        HBox titleBox = new HBox(title,titleInput);
        HBox authorBox = new HBox(author,authorInput);
        HBox ISBNBox = new HBox(ISBN,ISBNInput);
        HBox publishingYearBox = new HBox(publishingYear,publishingYearInput);
        HBox numberOfCopiesBox = new HBox(numberOfCopies,numberOfCopiesInput);
        HBox ratingBox = new HBox(rating,ratingInput);


        Button addBookButton = new Button("Add Book");
        Button back = new Button("Go back");


        addBookButton.setOnAction(e -> {
            String titleData = titleInput.getText();
            String authorData = authorInput.getText();
            String ISBNData = ISBNInput.getText();
            String publishYearData = publishingYearInput.getText();
            String numberOfCopiesData = numberOfCopiesInput.getText();
            String ratingBoxData = ratingInput.getText();

            if (!ISBNData.matches("\\d+") || !publishYearData.matches("\\d+") || !numberOfCopiesData.matches("\\d+") || (!ratingBoxData.matches("\\d+(\\.\\d+)?"))||titleData.isBlank() || !ISBNData.matches("\\d+") || authorData.isBlank() || ISBNData.isBlank() || publishYearData.isBlank() || numberOfCopiesData.isBlank() || ratingBoxData.isBlank() || Integer.parseInt(publishYearData) > 2024) {
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
                addBookMethods.addBook(titleData, authorData, ISBNData, publishYearData, numberOfCopiesData, ratingBoxData);
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Book added!", ButtonType.CLOSE);
                a.showAndWait();
                try {
                    int intValue = Integer.parseInt(numberOfCopiesData);
                    System.out.println("Converted integer value: " + intValue);
                    for(int i = 0; i < intValue;i++){
                        addBookMethods.addBookCopy(ISBNData);
                    }


                } catch (NumberFormatException ee) {
                    System.err.println("Error converting string to int: " + ee.getMessage());
                }


            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (invalidLoginException ex) {
                throw new RuntimeException(ex);
            } catch (exceptions.InvalidInputException ex) {
                throw new RuntimeException(ex);
            }
            menu page = new menu();
            page.start(stage);}
        });
        back.setOnAction(e -> {
            menu page = new menu();
            page.start(stage);
        });
        Image backgroundImage = new Image("file:C:\\Users\\Tina\\Desktop\\books.jpg");

        // Create a background image
        BackgroundImage background = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        HBox buttons = new HBox(addBookButton,back);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);
        buttons.setStyle("-fx-font-size: 15");

        VBox v = new VBox(titleBox, authorBox, ISBNBox, publishingYearBox,numberOfCopiesBox, ratingBox, buttons);
        v.setAlignment(Pos.CENTER);
        v.setSpacing(10);
        v.setPadding(new Insets(50));
        v.setBackground(new Background(background));

        Scene scene = new Scene(v, 500, 400);
        stage.setTitle("Add book!");
        stage.setScene(scene);
        stage.show();

    }
}