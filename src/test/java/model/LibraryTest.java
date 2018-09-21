package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @DisplayName("Should display the list of books in string format")
    @Test
    void toStringTest() {
        Library library = new Library(new BookGenerator().addBooks());
        String expected = "[Harry potter and the prisoner of Askaban J K Rouling 2003\n" +
                ", Harry potter and the order of pheonix J K Rouling 2003\n" +
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
        List<String> titles = library.getDetailsOfBooks();
        List<String> expected = Arrays.asList("Harry potter and the prisoner of Askaban J K Rouling 2003", "Harry potter and the order of pheonix J K Rouling 2003");
        assertEquals(expected,titles);
    }

    @DisplayName("Should return true for checkout for a book that exists in the library")
    @Test
    void checkoutTestTrue() {
        Library library = new Library(new BookGenerator().addBooks());
        List<String> beforeActual = library.getDetailsOfBooks();
        List<String> beforeExpected = Arrays.asList("\nHarry potter and the prisoner of Askaban-J K Rouling-2003","\nHarry potter and the order of pheonix-J K Rouling-2003");
        List<String> afterActual = library.getDetailsOfBooks();
        List<String> afterExpected = Arrays.asList("\nHarry potter and the order of pheonix-J K Rouling-2003");
        assertAll(
                ()->assertTrue(library.checkout("Harry potter and the prisoner of Askaban")),
                ()-> assertEquals(beforeExpected,beforeActual),
                ()-> assertEquals(afterExpected,afterActual),
                ()-> assertNotEquals(afterActual,beforeActual)
        );


    }

    @DisplayName("Should return false for checkout for a book that doesn't exist in the library")
    @Test
    void checkoutTestFalse() {
        Library library = new Library(new BookGenerator().addBooks());
        List<String> beforeActual = library.getDetailsOfBooks();
        List<String> beforeExpected = Arrays.asList("\nHarry potter and the prisoner of Askaban-J K Rouling-2003","\nHarry potter and the order of pheonix-J K Rouling-2003");
        List<String> afterActual = library.getDetailsOfBooks();
        List<String> afterExpected = Arrays.asList("\nHarry potter and the prisoner of Askaban-J K Rouling-2003","\nHarry potter and the order of pheonix-J K Rouling-2003");
        assertAll(
                ()-> assertFalse(library.checkout("Harry potter and the prisoner of Askaban...")),
                ()-> assertEquals(beforeExpected,beforeActual),
                ()-> assertEquals(afterExpected,afterActual),
                ()-> assertEquals(afterActual,beforeActual)
        );


    }

    @DisplayName("Should return true for returning a book that was checked out")
    @Test
    void returnTestTrue() {
        Library library = new Library(new BookGenerator().addBooks());
        assertAll(
                ()->assertTrue(library.checkout("Harry potter and the prisoner of Askaban")),
                ()->assertTrue(library.returnBook("Harry potter and the prisoner of Askaban"))
        );


    }

    @DisplayName("Should return false for returning a book that wasn't checked out but is part of the list of books")
    @Test
    void returnTestFalseBookNotCheckedOut() {
        Library library = new Library(new BookGenerator().addBooks());
        assertAll(
                ()-> assertFalse(library.returnBook("Harry potter and the prisoner of Askaban"))

        );


    }

    @DisplayName("Should return false for returning a book that wasn't part of the list of books")
    @Test
    void returnTestFalseBookNotPresentInLibrary() {
        Library library = new Library(new BookGenerator().addBooks());
        assertAll(
                ()-> assertFalse(library.returnBook("Harry potter and the prisoner of Askaban...."))

        );


    }
}