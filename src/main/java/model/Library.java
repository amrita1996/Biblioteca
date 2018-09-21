package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Library {

    private final List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return books.equals(library.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(books);
    }



    @Override
    public String toString() {
        return "" + books;
    }

    public List<String> getDetailsOfBooks() {
        List<String> titles = new ArrayList<>();
        for (Book book : books) {
            titles.add("\n"+book.getTitle()+"-"+book.getAuthor()+"-"+book.getYear());
        }
        return titles;
    }
}
