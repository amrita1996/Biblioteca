package controller;

import controller.command.Authenticator;
import controller.command.User;
import model.BookAndMovieGenerator;
import model.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.Input;
import view.InputDriver;
import view.Output;
import view.OutputDriver;

import java.util.Optional;

import static org.mockito.Mockito.*;

class MenuTest {

    Output output;
    Input input;
    Library library;
    LibraryManagementSystem libraryManagementSystem;
    User user;
    Authenticator authenticator;

    @BeforeEach
    public void init() {
        output = mock(OutputDriver.class);
        input = mock(InputDriver.class);
        library = new Library(new BookAndMovieGenerator().generate());
        user = new User("Amrita","xyz@gmail.com","4663547623");
        authenticator = mock(Authenticator.class);
        libraryManagementSystem = new LibraryManagementSystem(output,input,library,authenticator);

    }

    @DisplayName("Should print the list of books")
    @Test
    void printMessageForPrintBooks() {
        Menu menu = Menu.PRINT_BOOKS;
        menu.print(output);
        verify(output).print(menu.ordinal()+". "+menu.getString());
    }

    @DisplayName("Should print quit as an option")
    @Test
    void printMessageForQuit() {
        Menu menu = Menu.QUIT;
        menu.print(output);
        verify(output).print(menu.ordinal()+". "+menu.getString());
    }

    @DisplayName("Should print the message for checkout")
    @Test
    void printMessageForCheckOut() {
        Menu menu = Menu.CHECKOUT_BOOK;
        menu.print(output);
        verify(output).print(menu.ordinal()+". "+menu.getString());
    }



    @DisplayName("Should print the list of books")
    @Test
    void performPrintBooks() {
        Menu menu = Menu.PRINT_BOOKS;
        menu.perform(library, output,input,authenticator);
        verify(output).splitAndPrint("Title-Author-Year\n");
        verify(output).print(library.getDetailsOfBooks());

    }

    @DisplayName("Should print choose another option")
    @Test
    void performPrintChooseAnotherOption() {
        Menu menu = Menu.DEFAULT;
        menu.perform(library, output,input,authenticator);
        verify(output).print("Select a valid option!");


    }

    @DisplayName("Should print the list of movies")
    @Test
    void performPrintMovies() {
        Menu menu = Menu.PRINT_MOVIES;
        menu.perform(library, output,input,authenticator);
        verify(output).print(library.getDetailsOfMovies());

    }

    @DisplayName("Should quit")
    @Test
    void performQuit() {
        Menu menu = Menu.QUIT;
        menu.perform(library, output,input,authenticator);
        verify(output).print("Quit !");


    }

    @DisplayName("Should checkout a book that exists and should display message")
    @Test
    void performCheckoutTrue() {
        Menu menu = Menu.CHECKOUT_BOOK;
        when(authenticator.getSessionUser()).thenReturn(Optional.of(user));
        when(input.read()).thenReturn("Harry potter and the prisoner of Askaban");
        menu.perform(library, output,input,authenticator);
        verify(output).print("Thank you! Enjoy the item.\n");


    }

    @DisplayName("Should not checkout a book that doesn't exist and should display message")
    @Test
    void performCheckoutFalse() {
        Menu menu = Menu.CHECKOUT_BOOK;
        when(authenticator.getSessionUser()).thenReturn(Optional.of(user));
        when(input.read()).thenReturn("Harry potter and the prisoner of Askaban.....");
        menu.perform(library, output,input,authenticator);
        verify(output).print("That item is not available.\n");


    }

    @DisplayName("Should return a book that exists and should display message")
    @Test
    void performReturnTrue() {
        Menu menuCheckout = Menu.CHECKOUT_BOOK;
        Menu menuReturn = Menu.RETURN_BOOK;
        when(authenticator.getSessionUser()).thenReturn(Optional.of(user));
        when(input.read()).thenReturn("Harry potter and the prisoner of Askaban").thenReturn("Harry potter and the prisoner of Askaban");
        menuCheckout.perform(library, output,input,authenticator);
        menuReturn.perform(library,output,input,authenticator);
        verify(output).print("Thank you! Enjoy the item.\n");


    }

    @DisplayName("Should not checkout a book that doesn't exist and should display message")
    @Test
    void performReturnFalse() {
        Menu menu = Menu.RETURN_BOOK;
        when(authenticator.getSessionUser()).thenReturn(Optional.of(user));
        when(input.read()).thenReturn("Harry potter");
        menu.perform(library, output,input,authenticator);
        verify(output).print("That is not a valid item to return.\n");


    }
}