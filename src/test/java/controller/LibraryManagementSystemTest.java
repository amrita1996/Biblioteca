package controller;

import model.Book;
import model.BookGenerator;
import view.InputDriver;
import view.OutputDriver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

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

    @DisplayName("should print a menu and print list of books when 1 is pressed")
    @Test
    public void menuOperationToPrintListOfBooks() {
        OutputDriver output = mock(OutputDriver.class);
        InputDriver input = mock(InputDriver.class);
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(output, input);
        List<String> books = new ArrayList<>();
        for (Book book:new BookGenerator().addBooks()) {
            books.add(book.toString());
        }

        when(input.read()).thenReturn("1").thenReturn("0");
        libraryManagementSystem.menuOperation();

        verify(output,times(2)).print("\n\nMENU\n");

        verify(output).print(books);

        verify(output).print("Quit !");

    }

    @DisplayName("should print a menu and print quit when 0 is pressed")
    @Test
    public void menuOperationToPrintQuit() {
        OutputDriver output = mock(OutputDriver.class);
        InputDriver input = mock(InputDriver.class);
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(output, input);

        when(input.read()).thenReturn("0");
        libraryManagementSystem.menuOperation();

        verify(output).print(Menu.QUIT.ordinal()+". "+Menu.QUIT.getString());
        verify(output).print(Menu.PRINT_BOOKS.ordinal()+". "+Menu.PRINT_BOOKS.getString());
        verify(output).print("Choose an option : ");
        verify(output).print("Quit !");

    }

    @DisplayName("should print a menu and print choose a valid option when wrong input is pressed")
    @Test
    public void menuOperationToPrintChooseValidOption() {
        OutputDriver output = mock(OutputDriver.class);
        InputDriver input = mock(InputDriver.class);
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(output, input);

        when(input.read()).thenReturn("5").thenReturn("0");
        libraryManagementSystem.menuOperation();

        verify(output).print("Select a valid option!");
        verify(output).print("Quit !");

    }

    @DisplayName("should print a menu and checkout a book that exists and print checkout successfull")
    @Test
    public void menuOperationToCheckoutValidBook() {
        OutputDriver output = mock(OutputDriver.class);
        InputDriver input = mock(InputDriver.class);
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(output, input);

        when(input.read()).thenReturn("2").thenReturn("Harry potter and the prisoner of Askaban").thenReturn("0");
        libraryManagementSystem.menuOperation();

        verify(output).print("Enter the title of the book to be checked out : ");
        verify(output).print("Thank you! Enjoy the book.\n");
        verify(output).print("Quit !");

    }

    @DisplayName("should print a menu and shouldn't checkout a book that doesn't exist and print checkout unsuccessfull")
    @Test
    public void menuOperationToCheckoutInValidBook() {
        OutputDriver output = mock(OutputDriver.class);
        InputDriver input = mock(InputDriver.class);
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(output, input);

        when(input.read()).thenReturn("2").thenReturn("Harry potter and the prisoner of Askaban....").thenReturn("0");
        libraryManagementSystem.menuOperation();

        verify(output).print("Enter the title of the book to be checked out : ");
        verify(output).print("That book is not available.\n");
        verify(output).print("Quit !");

    }

    @DisplayName("should print a menu and return a book that was checked out and print thank you for returning")
    @Test
    public void menuOperationToReturnValidBook() {
        OutputDriver output = mock(OutputDriver.class);
        InputDriver input = mock(InputDriver.class);
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(output, input);

        when(input.read()).thenReturn("2").thenReturn("Harry potter and the prisoner of Askaban").thenReturn("3").thenReturn("Harry potter and the prisoner of Askaban").thenReturn("0");
        libraryManagementSystem.menuOperation();

        verify(output).print("Enter the title of the book to be returned : ");
        verify(output).print("Thank you for returning the book.\n");
        verify(output).print("Quit !");

    }

    @DisplayName("should print a menu and shouldn't return a book that wasn't checked out and print return unsuccessfull")
    @Test
    public void menuOperationToReturnInValidBook() {
        OutputDriver output = mock(OutputDriver.class);
        InputDriver input = mock(InputDriver.class);
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(output, input);

        when(input.read()).thenReturn("3").thenReturn("Harry potter and the prisoner of Askaban").thenReturn("0");
        libraryManagementSystem.menuOperation();

        verify(output).print("Enter the title of the book to be returned : ");
        verify(output).print("That is not a valid book to return.\n");
        verify(output).print("Quit !");

    }

    @DisplayName("should print a menu and shouldn't return a book that isn't present and print return unsuccessfull")
    @Test
    public void menuOperationToReturnInValidBookNotPresent() {
        OutputDriver output = mock(OutputDriver.class);
        InputDriver input = mock(InputDriver.class);
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(output, input);

        when(input.read()).thenReturn("3").thenReturn("Harry potter and the prisoner of Askaban...").thenReturn("0");
        libraryManagementSystem.menuOperation();

        verify(output).print("Enter the title of the book to be returned : ");
        verify(output).print("That is not a valid book to return.\n");
        verify(output).print("Quit !");

    }


}
