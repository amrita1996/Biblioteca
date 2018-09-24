package controller;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import view.Input;
import view.InputDriver;
import view.Output;
import view.OutputDriver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class LibraryManagementSystemTest {
    Output output;
    Input input;
    Library library;
    LibraryManagementSystem libraryManagementSystem;

    @BeforeEach
    public void init() {
        output = mock(OutputDriver.class);
        input = mock(InputDriver.class);
        library = new Library(new BookAndMovieGenerator().generate());
        libraryManagementSystem = new LibraryManagementSystem(output,input,library);

    }

    @DisplayName("should return the welcome message")
    @Test
    public void shouldPrintMessage() {
        libraryManagementSystem.printWelcomeMessage();
        verify(output).print("Welcome !");
    }

    @DisplayName("should print a menu and print list of books when 1 is pressed")
    @Test
    public void menuOperationToPrintListOfBooks() {
        List<String> books = Arrays.asList("Harry potter and the prisoner of Askaban-J K Rouling-2003\n","Harry potter and the order of pheonix-J K Rouling-2003\n");

        when(input.read()).thenReturn("1").thenReturn("0");
        libraryManagementSystem.menuOperation();

        verify(output,times(2)).print("\n\nMENU\n");

        verify(output).print(books);

        verify(output).print("Quit !");

    }

    @DisplayName("should print a menu and print list of movies when 4 is pressed")
    @Test
    public void menuOperationToPrintListOfMovies() {
        List<String> movies = Arrays.asList("Silver linings playbook-2012-David O Russel-8\n","American Hustle-2013-David O Russel-7\n");

        when(input.read()).thenReturn("4").thenReturn("0");
        libraryManagementSystem.menuOperation();

        verify(output,times(2)).print("\n\nMENU\n");

        verify(output).print(movies);

        verify(output).print("Quit !");

    }

    @DisplayName("should print a menu and print quit when 0 is pressed")
    @Test
    public void menuOperationToPrintQuit() {

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

        when(input.read()).thenReturn("10").thenReturn("0");
        libraryManagementSystem.menuOperation();

        verify(output).print("Select a valid option!");
        verify(output).print("Quit !");

    }

    @DisplayName("should print a menu and checkout a book that exists and print checkout successfull")
    @Test
    public void menuOperationToCheckoutValidBook() {

        when(input.read()).thenReturn("2").thenReturn("Harry potter and the prisoner of Askaban").thenReturn("0");
        libraryManagementSystem.menuOperation();

        verify(output,times(2)).print("\n\nMENU\n");
        verify(output).print("Enter the title of the item to be checked out : ");
        verify(output).print("Thank you! Enjoy the item.\n");
        verify(output).print("Quit !");

    }

    @DisplayName("should print a menu and shouldn't checkout a book that doesn't exist and print checkout unsuccessfull")
    @Test
    public void menuOperationToCheckoutInValidBook() {

        when(input.read()).thenReturn("2").thenReturn("Harry potter and the prisoner of Askaban....").thenReturn("0");
        libraryManagementSystem.menuOperation();

        verify(output).print("Enter the title of the item to be checked out : ");
        verify(output).print("That item is not available.\n");
        verify(output).print("Quit !");

    }

    @DisplayName("should print a menu and return a book that was checked out and print thank you for returning")
    @Test
    public void menuOperationToReturnValidBook() {

        when(input.read()).thenReturn("2").thenReturn("Harry potter and the prisoner of Askaban").thenReturn("3").thenReturn("Harry potter and the prisoner of Askaban").thenReturn("0");
        libraryManagementSystem.menuOperation();

        verify(output).print("Enter the title of the item to be returned : ");
        verify(output).print("Thank you for returning the item.\n");
        verify(output).print("Quit !");

    }

    @DisplayName("should print a menu and shouldn't return a book that wasn't checked out and print return unsuccessfull")
    @Test
    public void menuOperationToReturnInValidBook() {

        when(input.read()).thenReturn("3").thenReturn("Harry potter and the prisoner of Askaban").thenReturn("0");
        libraryManagementSystem.menuOperation();

        verify(output).print("Enter the title of the item to be returned : ");
        verify(output).print("That is not a valid item to return.\n");
        verify(output).print("Quit !");

    }

    @DisplayName("should print a menu and shouldn't return a book that isn't present and print return unsuccessfull")
    @Test
    public void menuOperationToReturnInValidBookNotPresent() {

        when(input.read()).thenReturn("3").thenReturn("Harry potter and the prisoner of Askaban...").thenReturn("0");
        libraryManagementSystem.menuOperation();

        verify(output).print("Enter the title of the item to be returned : ");
        verify(output).print("That is not a valid item to return.\n");
        verify(output).print("Quit !");

    }


}
