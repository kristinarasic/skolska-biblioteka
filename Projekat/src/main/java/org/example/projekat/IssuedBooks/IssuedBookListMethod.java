package org.example.projekat.IssuedBooks;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.projekat.database.database.con;


public class IssuedBookListMethod {
    /**
     *
     * @return
     * @throws SQLException
     */
    public static ListView<String> showIssuedBooks() throws SQLException {
        ListView<String> listView = new ListView<>();
        ObservableList<String> bookDetails = FXCollections.observableArrayList();

        PreparedStatement statement = con.prepareStatement("SELECT member.name, member.lastname, member.grade, book.title, book.author FROM borrowed\n" +
                "join member on borrowed.memberIndex = member.memberIndex\n" +
                "join bookcopy on borrowed.bookcopyId = bookcopy.bookcopyId\n" +
                "join book on bookcopy.ISBN = book.ISBN;");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String name = resultSet.getString("member.name");
            String lastname = resultSet.getString("member.lastname");
            int grade = resultSet.getInt("member.grade");
            String title = resultSet.getString("book.title");
            String author = resultSet.getString("book.author");

            String bookDetail = String.format("Name: %s\nLastname: %s\nGrade: %d\nTitle: %s\nAuthor: %s\n",
                    name, lastname, grade, title, author);

            bookDetails.add(bookDetail);
        }

        listView.setItems(bookDetails);

        resultSet.close();
        statement.close();

        return listView;
    }
}