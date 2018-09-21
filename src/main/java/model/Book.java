package model;


import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private Year year;

    public Book(String title, String author, Year year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return "" + title + " " + author + " " + year + "\n";
    }

    public String getAuthor() {
        return author;
    }

    public Year getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return title.equals(book.title) && author.equals(book.author) && year.equals(book.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    public String getTitle() {
        return title;
    }
}
