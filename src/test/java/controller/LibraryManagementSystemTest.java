package controller;

import view.InputDriver;
import view.OutputDriver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LibraryManagementSystemTest {

    @DisplayName("should return the welcome message")
    @Test
    public void shouldPrintMessage() {
        OutputDriver output = mock(OutputDriver.class);
        InputDriver input = mock(InputDriver.class);
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(output, input);
        libraryManagementSystem.printWelcomeMessage();
        verify(output).print("Welcome !");
    }

    @DisplayName("should print a menu")
    @Test
    public void menuOperation() {
        OutputDriver output = mock(OutputDriver.class);
        InputDriver input = mock(InputDriver.class);
        String menu = "List of options\n1. List books\nx. Quit\nChoose an option : ";
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(output, input);
        libraryManagementSystem.menuOperation();
        verify(output).print(menu);

    }


}
