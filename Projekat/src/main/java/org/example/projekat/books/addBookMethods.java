package org.example.projekat.books;

import org.example.projekat.IssuedBooks.bookcopy;
import org.example.projekat.exceptions.exceptions;
import org.example.projekat.exceptions.invalidLoginException;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.example.projekat.database.database.con;

/**
 *
 */


public class addBookMethods {
    /**
     * @return
     * @throws SQLException
     * @throws exceptions.InvalidInputException
     */
    public static Book addBook(String title, String author, String ISBN, String publishYear, String numberOfCopies, String rating) throws SQLException, exceptions.InvalidInputException {
        Book book = new Book();


        PreparedStatement statement = con.prepareStatement("INSERT INTO book (title, author, ISBN, publishYear, numberOfCopies, rating) VALUES (?, ?, ?, ?, ?, ?)");
        statement.setString(1, title);
        statement.setString(2, author);
        statement.setString(3, ISBN);
        statement.setString(4, publishYear);
        statement.setString(5, numberOfCopies);
        statement.setString(6, rating);


            // Validate input

                int rowsAffected = statement.executeUpdate();


                if (rowsAffected > 0) {

                    book.setTitle(title);
                    book.setAuthor(author);
                    book.setISBN(ISBN);
                    book.setPublichYear(publishYear);
                    book.setNumberOfCopies(numberOfCopies);
                    book.setRating(rating);

                } else {

                    System.out.println("Failed to add the book to the database.");
                }
                

        return book;

    }

    /**
     * @return
     * @throws SQLException
     * @throws invalidLoginException
     */
    public static bookcopy addBookCopy(String ISBN) throws SQLException, invalidLoginException {
        bookcopy book = new bookcopy();


        PreparedStatement statement = con.prepareStatement("INSERT INTO bookcopy (ISBN) VALUES (?)");
        statement.setString(1, ISBN);



        int rowsAffected = statement.executeUpdate();


        if (rowsAffected > 0) {


            book.setISBN(ISBN);


        } else {

            System.out.println("Failed to add the book to the database.");
        }

        return book;
    }




}
