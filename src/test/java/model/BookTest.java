package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookTest {

    @DisplayName("Should return the book in string format")
    @Test
    void toStringTest() {
        Book book = new Book("Harry potter and the prisoner of Askaban");
        String expected = "Harry potter and the prisoner of Askaban\n";
        assertEquals(expected,book.toString());
    }

    @DisplayName("Two books with same credentials should be equal")
    @Test
    void equalsTest() {
        Book book1 = new Book("Harry Potter");
        Book book2 = new Book("Harry Potter");
        assertEquals(book1,book2);
    }

    @DisplayName("Should return the title")
    @Test
    void getTitleTest() {
        String actual = new Book("Harry Potter").getTitle();
        String expected = "Harry Potter";
        assertEquals(expected,actual);
    }
}