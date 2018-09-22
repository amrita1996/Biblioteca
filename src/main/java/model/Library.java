package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Library {

    private final List<Book> allBooks;
    private final List<Book> currentBooks;
    private final List<Movie> allMovies;
    private final List<Movie> currentMovies;

    public Library(List<Book> books, List<Movie> movies) {
        this.allBooks = books;
        currentBooks = new ArrayList<>(allBooks);
        this.allMovies = movies;
        currentMovies = new ArrayList<>(allMovies);
    }

    public List<String> getDetailsOfBooks() {
        List<String> details = new ArrayList<>();
        for (Book book : currentBooks) {
            details.add(book.toString());
        }
        return details;
    }

    public List<String> getDetailsOfMovies() {
        List<String> details = new ArrayList<>();
        for (Movie movie : currentMovies) {
            details.add(movie.toString());
        }
        return details;
    }

    public boolean checkoutBook(String requestedTitle) {
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
}
