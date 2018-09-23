package model;

import java.util.ArrayList;
import java.util.List;

public class BookAndMovieGenerator {

    private List<Book> addBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Harry potter and the prisoner of Askaban", "J K Rouling", new Year(2003)));
        books.add(new Book("Harry potter and the order of pheonix", "J K Rouling", new Year(2003)));
        return books;
    }

    private List<Movie> addMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Silver linings playbook", new Year(2012),"David O Russel",new Rating(8)));
        movies.add(new Movie("American Hustle", new Year(2013),"David O Russel",new Rating(7)));
        return movies;
    }

    public List<Item> generate() {
        List<Item> items = new ArrayList<>(addBooks());
        items.addAll(addMovies());
        return items;
    }
}
