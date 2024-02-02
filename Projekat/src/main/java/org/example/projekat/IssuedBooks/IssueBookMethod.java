package org.example.projekat.IssuedBooks;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import static org.example.projekat.database.database.con;


public class IssueBookMethod {
    /**
     *
     * @return
     */
    public static Set<String> membersData() {

        Set<String> membersData = new HashSet<>();
        try {
            String query = "SELECT name, lastname, memberIndex FROM member";

            try (PreparedStatement statement = con.prepareStatement(query)) {
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String lastname = resultSet.getString("lastname");
                    String indeks = resultSet.getString("memberIndex");

                    membersData.add(name + " " + lastname + "-" + indeks);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return membersData;
    }

    /**
     *
     * @return
     */
    public static Set<String> bookCopyData() {

        Set<String> bookData = new HashSet<>();
        try {
            String query = "SELECT book.title, book.author, book.ISBN, bookcopy.bookcopyID\n" +
                    "FROM bookcopy\n" +
                    "JOIN book ON bookcopy.ISBN = book.ISBN\n" +
                    "LEFT JOIN borrowed ON bookcopy.bookcopyID = borrowed.bookcopyID\n" +
                    "WHERE borrowed.bookcopyID IS NULL;\n";

            try (PreparedStatement statement = con.prepareStatement(query)) {
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    String title = resultSet.getString("book.title");
                    String author = resultSet.getString("book.author");
                    String ISBN = resultSet.getString("book.ISBN");
                    String bookcopyID = resultSet.getString("bookcopy.bookcopyID");



                    bookData.add(ISBN + " - " + title + ", " + author + " - " + bookcopyID);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookData;
    }
    public static borrowed issue(String selectedValue1, String selectedValue2) throws SQLException {
        borrowed book = new borrowed();
        if(selectedValue1 == null && selectedValue2 == null){
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Please select a book and a member!", ButtonType.CLOSE);
            a.showAndWait();
        }
        else if(selectedValue1 == null){
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Please select a member!", ButtonType.CLOSE);
            a.showAndWait();
        }
        else if(selectedValue2 == null){
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Please select a book!", ButtonType.CLOSE);
            a.showAndWait();

        }
        else{
        PreparedStatement statement = con.prepareStatement("INSERT INTO borrowed (memberIndex, bookcopyID) VALUES (?, ?)");
        String bookcopyID[] = selectedValue2.split("-");
        String memberIndex[] = selectedValue1.split("-");
        statement.setString(1, memberIndex[1].strip());
        statement.setString(2, bookcopyID[2].strip());
        int rowsAffected = statement.executeUpdate();
        if (rowsAffected > 0) {

            book.setBookcopyID(bookcopyID[2]);
            book.setMemberIndex(memberIndex[1]);
            Alert m = new Alert(Alert.AlertType.INFORMATION, "Book successfuly issued!!", ButtonType.CLOSE);
            m.showAndWait();

        } else {

            System.out.println("Failed to add the book to the database.");
        }}
        return book;
    }

}
