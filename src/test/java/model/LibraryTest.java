package model;

import controller.command.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    Library library;
    User user;

    @BeforeEach
    public void init() {
        library = new Library(new BookAndMovieGenerator().generate());
        user = new User("Amrita","xyz@gmail.com","81237492364823");

    }

    @Test
    void getListOfBooksTest() {
        List<String> titles = library.getDetailsOfBooks();
        List<String> expected = Arrays.asList("Harry potter and the prisoner of Askaban-J K Rouling-2003\n", "Harry potter and the order of pheonix-J K Rouling-2003\n");
        assertEquals(expected,titles);
    }

    @DisplayName("Should return true for checkout for a book that exists in the library")
    @Test
    void checkoutBookTestTrue() {
        assertTrue(library.checkout("Harry potter and the prisoner of Askaban",ItemType.BOOK, user));



    }

    @DisplayName("Should return false for checkout for a book that doesn't exist in the library")
    @Test
    void checkoutBookTestFalse() {
        assertFalse(library.checkout("Harry potter and the prisoner of Askaban...",ItemType.BOOK, user));



    }

    @DisplayName("Should return true for returning a book that was checked out")
    @Test
    void returnTestTrue() {
        assertAll(
                ()->assertTrue(library.checkout("Harry potter and the prisoner of Askaban",ItemType.BOOK, user)),
                ()->assertTrue(library.returnItem("Harry potter and the prisoner of Askaban",ItemType.BOOK))
        );


    }

    @DisplayName("Should return false for returning a book that wasn't checked out but is part of the list of books")
    @Test
    void returnTestFalseBookNotCheckedOut() {
        assertFalse(library.returnItem("Harry potter and the prisoner of Askaban",ItemType.BOOK));
    }

    @DisplayName("Should return false for returning a book that wasn't part of the list of books")
    @Test
    void returnTestFalseBookNotPresentInLibrary() {
        assertFalse(library.returnItem("Harry potter and the prisoner of Askaban....",ItemType.BOOK));



    }

    @Test
    void getDetailsOfMovies() {
        List<String> movies = library.getDetailsOfMovies();
        List<String> expected = Arrays.asList("Silver linings playbook-2012-David O Russel-8\n","American Hustle-2013-David O Russel-7\n");
        assertEquals(expected,movies);
    }

    @DisplayName("Should return true for checkout for a movie that exists in the library")
    @Test
    void checkoutMovieTestTrue() {
        assertTrue(library.checkout("American Hustle",ItemType.MOVIE,user));



    }

    @DisplayName("Should return false for checkout for a movie that doesn't exist in the library")
    @Test
    void checkoutMovieTestFalse() {
        assertFalse(library.checkout("American Hustle....",ItemType.MOVIE, user));



    }

    @DisplayName("Should return true for checkout for a book that exists in the library")
    @Test
    void checkoutBookAndAddUser() {
        assertTrue(library.checkout("Harry potter and the prisoner of Askaban",ItemType.BOOK, user));
        assertTrue(user.containsItem(new Item("Harry potter and the prisoner of Askaban",ItemType.BOOK)));



    }
}