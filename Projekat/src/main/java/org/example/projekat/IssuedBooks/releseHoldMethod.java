package org.example.projekat.IssuedBooks;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import static org.example.projekat.database.database.con;


public class releseHoldMethod {
    /**
     *
     * @return
     */
    public static Set<String> issuedBooksData() {

        Set<String> issuedBookData = new HashSet<>();
        try {
            String query = "select member.name , member.lastname, member.memberIndex, book.title, book.author, book.ISBN, borowedID from borrowed\n" +
                    "join bookcopy on borrowed.bookcopyID = bookcopy.bookcopyID\n" +
                    "join book on bookcopy.ISBN = book.ISBN\n" +
                    "join member on member.memberIndex = borrowed.memberIndex";

            try (PreparedStatement statement = con.prepareStatement(query)) {
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    String name = resultSet.getString("member.name");
                    String lastname = resultSet.getString("member.lastname");
                    String indeks = resultSet.getString("member.memberIndex");
                    String title = resultSet.getString("book.title");
                    String author = resultSet.getString("book.author");
                    String ISBN = resultSet.getString("book.ISBN");
                    String borowed = resultSet.getString("borowedID");

                    issuedBookData.add(name + " - " + lastname + " - " + indeks + " - " + title + " - " + author + " - " + ISBN + " - " + borowed);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return issuedBookData;
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    public static borrowed releaseHold(String selectedValue1) throws SQLException {
        borrowed book = new borrowed();
        if (selectedValue1 == null) {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Please select an issued book!", ButtonType.CLOSE);
            a.showAndWait();
        } else {
            String[] values = selectedValue1.split("-");

            String bookTitle = values[3].trim();
            String bookAuthor = values[4].trim();
            String bookISBN = values[5].trim();
            String memberIndex = values[2].trim();
            String borowedID = values[6].trim();


            try {
                con.setAutoCommit(false);

                String deleteQuery = "DELETE FROM borrowed WHERE borowedID = ?";
                try (PreparedStatement deleteStatement = con.prepareStatement(deleteQuery)) {
                    deleteStatement.setString(1, borowedID);
                    int rowsDeleted = deleteStatement.executeUpdate();

                    if (rowsDeleted > 0) {
                        String insertQuery = "INSERT INTO bookcopy (ISBN) VALUES (?)";
                        try (PreparedStatement insertStatement = con.prepareStatement(insertQuery)) {
                            insertStatement.setString(1, bookISBN);

                            int rowsInserted = insertStatement.executeUpdate();

                            if (rowsInserted > 0) {
                                con.commit();
                                book.setMemberIndex(memberIndex);
                                Alert m = new Alert(Alert.AlertType.INFORMATION, "Book successfuly relesed!!", ButtonType.CLOSE);
                                m.showAndWait();
                            } else {
                                con.rollback();
                                System.out.println("Failed to insert into bookcopy.");
                            }
                        }
                    } else {
                        con.rollback();
                        System.out.println("Failed to delete from borrowed.");
                    }
                } catch (SQLException e) {
                    con.rollback();
                    throw e;
                } finally {
                    con.setAutoCommit(true);
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return book;

        }
    }
