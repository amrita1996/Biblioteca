package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    Library library;

    @BeforeEach
    public void init() {
        library = new Library(new BookAndMovieGenerator().addBooks(),new BookAndMovieGenerator().addMovies());

    }


    @DisplayName("two libraries with same list of books should be equal")
    @Test
    void equalsTest() {
        Library library2 = new Library(new BookAndMovieGenerator().addBooks(),new BookAndMovieGenerator().addMovies());
        assertEquals(library,library2);
    }

    @Test
    void getListOfBooksTest() {
        List<String> titles = library.getDetailsOfBooks();
        List<String> expected = Arrays.asList("Harry potter and the prisoner of Askaban-J K Rouling-2003\n", "Harry potter and the order of pheonix-J K Rouling-2003\n");
        assertEquals(expected,titles);
    }

    @DisplayName("Should return true for checkoutBook for a book that exists in the library")
    @Test
    void checkoutTestTrue() {
        assertTrue(library.checkoutBook("Harry potter and the prisoner of Askaban"));



    }

    @DisplayName("Should return false for checkoutBook for a book that doesn't exist in the library")
    @Test
    void checkoutTestFalse() {
        assertFalse(library.checkoutBook("Harry potter and the prisoner of Askaban..."));



    }

    @DisplayName("Should return true for returning a book that was checked out")
    @Test
    void returnTestTrue() {
        assertAll(
                ()->assertTrue(library.checkoutBook("Harry potter and the prisoner of Askaban")),
                ()->assertTrue(library.returnBook("Harry potter and the prisoner of Askaban"))
        );


    }

    @DisplayName("Should return false for returning a book that wasn't checked out but is part of the list of books")
    @Test
    void returnTestFalseBookNotCheckedOut() {
        assertFalse(library.returnBook("Harry potter and the prisoner of Askaban"));
    }

    @DisplayName("Should return false for returning a book that wasn't part of the list of books")
    @Test
    void returnTestFalseBookNotPresentInLibrary() {
        assertFalse(library.returnBook("Harry potter and the prisoner of Askaban...."));



    }

    @Test
    void getDetailsOfMovies() {
        List<String> movies = library.getDetailsOfMovies();
        List<String> expected = Arrays.asList("Silver linings playbook-2012-David O Russel-8\n","American Hustle-2013-David O Russel-7\n");
        assertEquals(expected,movies);
    }
}