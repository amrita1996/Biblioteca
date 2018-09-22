package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Library {

    private final List<Book> allBooks;
    private final List<Book> currentBooks;

    public Library(List<Book> books) {
        this.allBooks = books;
        currentBooks = new ArrayList<>(allBooks);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return allBooks.equals(library.allBooks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allBooks);
    }


    @Override
    public String toString() {
        return "" + allBooks;
    }

    public List<String> getDetailsOfBooks() {
        List<String> titles = new ArrayList<>();
        for (Book book : currentBooks) {
            titles.add(book.toString());
        }
        return titles;
    }

    public boolean checkout(String requestedTitle) {
        Book requestedBook = new Book(requestedTitle,"unknown Author", new Year(0));
        if(currentBooks.contains(requestedBook)) {
            currentBooks.remove(requestedBook);
            return true;
        }
        return false;
    }

    public boolean returnBook(String requestedTitle) {
        Book requestedBook = new Book(requestedTitle,"unknown Author", new Year(0));
        if(allBooks.contains(requestedBook) && !currentBooks.contains(requestedBook)) {
            currentBooks.add(requestedBook);
            return true;
        }
        return false;
    }
}
