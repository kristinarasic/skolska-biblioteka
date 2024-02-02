package org.example.projekat.IssuedBooks;

public class bookcopy {
    private String ISBN;
    private String bookcopyID;

    public bookcopy() {
    }

    public bookcopy(String ISBN, String bookcopyID) {
        this.ISBN = ISBN;
        this.bookcopyID = bookcopyID;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getBookcopyID() {
        return bookcopyID;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setBookcopyID(String bookcopyID) {
        this.bookcopyID = bookcopyID;
    }

    @Override
    public String toString() {
        return "bookcopy{" +
                "ISBN='" + ISBN + '\'' +
                ", bookcopyID='" + bookcopyID + '\'' +
                '}';
    }
}
