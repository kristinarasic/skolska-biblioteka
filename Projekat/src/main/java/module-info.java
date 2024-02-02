module org.example.projekat {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.jsoup;


    opens org.example.projekat to javafx.fxml;

    exports org.example.projekat.JunitTest;
    opens org.example.projekat.JunitTest to javafx.fxml;
    exports org.example.projekat.books;
    opens org.example.projekat.books to javafx.fxml;
    exports org.example.projekat.members;
    opens org.example.projekat.members to javafx.fxml;
    exports org.example.projekat.login;
    opens org.example.projekat.login to javafx.fxml;
    exports org.example.projekat.IssuedBooks;
    opens org.example.projekat.IssuedBooks to javafx.fxml;
    exports org.example.projekat.exceptions;
    opens org.example.projekat.exceptions to javafx.fxml;
    exports org.example.projekat.webScraping;
    opens org.example.projekat.webScraping to javafx.fxml;
    exports org.example.projekat.database;
    opens org.example.projekat.database to javafx.fxml;
    exports org.example.projekat.main;
    opens org.example.projekat.main to javafx.fxml;
}