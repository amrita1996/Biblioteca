package model;

import java.util.ArrayList;
import java.util.List;

public class BookGenerator {
    public List<Book> addBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Harry potter and the prisoner of Askaban"));
        books.add(new Book("Harry potter and the order of pheonix"));
        return books;
    }
}