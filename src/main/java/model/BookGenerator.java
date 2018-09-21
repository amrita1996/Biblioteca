package model;

import java.util.ArrayList;
import java.util.List;

public class BookGenerator {
    public List<Book> addBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Harry potter and the prisoner of Askaban","J K Rouling", new Year(2003)));
        books.add(new Book("Harry potter and the order of pheonix","J K Rouling", new Year(2003)));
        return books;
    }
}
