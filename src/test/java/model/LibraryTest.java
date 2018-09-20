package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LibraryTest {

    @DisplayName("Should display the list of books in string format")
    @Test
    void toStringTest() {
        Library library = new Library(new BookGenerator().addBooks());
        String expected = "[Harry potter and the prisoner of Askaban\n" +
                ", Harry potter and the order of pheonix\n" +
                "]";
        assertEquals(expected,library.toString());
    }


    @DisplayName("two libraries with same list of books should be equal")
    @Test
    void equalsTest() {
        Library library1 = new Library(new BookGenerator().addBooks());
        Library library2 = new Library(new BookGenerator().addBooks());
        assertEquals(library1,library2);
    }

    @Test
    void getTitlesOfBooksTest() {
        Library library = new Library(new BookGenerator().addBooks());
        List<String> titles = library.getTitlesOfBooks();
        List<String> expected = Arrays.asList("Harry potter and the prisoner of Askaban", "Harry potter and the order of pheonix");
        assertEquals(expected,titles);
    }
}