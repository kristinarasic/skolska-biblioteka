package org.example.projekat.books;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.projekat.database.database.con;


public class BookListMethod {
    /**
     *
     * @return
     * @throws SQLException
     */
    public static ListView<String> showBooks() throws SQLException {
        ListView<String> listView = new ListView<>();
        ObservableList<String> bookDetails = FXCollections.observableArrayList();

        PreparedStatement statement = con.prepareStatement("SELECT title,author,ISBN,publishYear,numberOfCopies,rating FROM book");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            String ISBN = resultSet.getString("ISBN");
            String publishYear = resultSet.getString("publishYear");
            String numberOfCopies = resultSet.getString("numberOfCopies");
            String rating = resultSet.getString("rating");

            // Build a string with book details
            String bookDetail = String.format("Title: %s\nAuthor: %s\nISBN: %s\npublishYear: %s\nnumberOfCopies: %s\nrating: %s\n",
                    title, author, ISBN, publishYear, numberOfCopies, rating);

            bookDetails.add(bookDetail);
        }

        // Set the items in the ListView
        listView.setItems(bookDetails);

        // Close resources
        resultSet.close();
        statement.close();

        return listView;
    }
}