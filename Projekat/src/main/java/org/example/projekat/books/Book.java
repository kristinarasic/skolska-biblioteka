package org.example.projekat.books;

public class Book {
    private String title;
    private String author;
    private String ISBN;
    private String publichYear;
    private String numberOfCopies;
    private String rating;

    public Book() {
    }

    public Book(String title, String author, String ISBN, String publichYear, String numberOfCopies, String rating) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publichYear = publichYear;
        this.numberOfCopies = numberOfCopies;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getPublichYear() {
        return publichYear;
    }

    public String getNumberOfCopies() {
        return numberOfCopies;
    }

    public String getRating() {
        return rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setPublichYear(String publichYear) {
        this.publichYear = publichYear;
    }

    public void setNumberOfCopies(String numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", publichYear='" + publichYear + '\'' +
                ", numberOfCopies='" + numberOfCopies + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}
