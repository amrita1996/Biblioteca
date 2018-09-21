package controller;

import model.BookGenerator;
import model.Library;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.Input;
import view.InputDriver;
import view.Output;
import view.OutputDriver;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class MenuTest {

    @DisplayName("Should print the list of books")
    @Test
    void performPrintBooks() {
        Output output = mock(OutputDriver.class);
        Library library = new Library(new BookGenerator().addBooks());
        Menu menu = Menu.PRINT_BOOKS;
        menu.perform(library,output);
        verify(output).print("\nHarry potter and the prisoner of Askaban","J K Rouling","2003");
        verify(output).print("\nHarry potter and the order of pheonix","J K Rouling","2003");

    }

    @DisplayName("Should print choose another option")
    @Test
    void performPrintChooseAnotherOption() {
        Output output = mock(OutputDriver.class);
        Library library = new Library(new BookGenerator().addBooks());
        Menu menu = Menu.DEFAULT;
        menu.perform(library,output);
        verify(output).print("Select a valid option!");


    }

    @DisplayName("Should quit")
    @Test
    void performQuit() {
        Output output = mock(OutputDriver.class);
        Library library = new Library(new BookGenerator().addBooks());
        Menu menu = Menu.QUIT;
        menu.perform(library,output);
        verify(output).print("Quit !");


    }
}