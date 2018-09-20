package controller;

import model.*;
import view.OutputDriver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LibraryManagementSystemTest {

    @DisplayName("should return the welcome message")
    @Test
    public void shouldPrintMessage() {
        OutputDriver output = mock(OutputDriver.class);
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(output);
        libraryManagementSystem.printWelcomeMessage();
        verify(output).print("Welcome !");
    }

    @DisplayName("should print list of books")
    @Test
    public void shouldPrintListOfBooks() {
        OutputDriver output = mock(OutputDriver.class);
        List<Book> books = new BookGenerator().addBooks();
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(output);
        libraryManagementSystem.printListOfBooks();
        verify(output).print(books.get(0).getTitle());
        verify(output).print(books.get(1).getTitle());

    }

}
