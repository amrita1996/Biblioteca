package controller.command;

import controller.CredentialBuilder;
import model.BookAndMovieGenerator;
import model.ItemType;
import model.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.Input;
import view.Output;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CheckoutCommandTest {
    Output output;
    Input input ;
    Library library ;
    User user;
    CheckoutCommand checkoutBookCommand;
    CheckoutCommand checkoutMovieCommand;
    private Authenticator authenticator;

    @BeforeEach
    void init() {
        output = mock(Output.class);
        input = mock(Input.class);
        user = new User("Amrita","xyz@gmail.com","317468713");
        authenticator = mock(Authenticator.class);
        library = new Library(new BookAndMovieGenerator().generate());
        checkoutBookCommand = new CheckoutCommand(ItemType.BOOK);
        checkoutMovieCommand = new CheckoutCommand(ItemType.MOVIE);
    }

    @DisplayName("Should return a book that was checked out")
    @Test
    void checkoutBookValidCase() {
        when(authenticator.getSessionUser()).thenReturn(Optional.of(user));
        when(input.read()).thenReturn("Harry potter and the prisoner of Askaban");
        checkoutBookCommand.perform(library,output,input, authenticator);

        verify(output).print("Enter the title of the item to be checked out : ");
        verify(output).print("Thank you! Enjoy the item.\n");


    }

    @DisplayName("Should not return a book that was not checked out")
    @Test
    void checkoutBookInValidCase() {
        when(authenticator.getSessionUser()).thenReturn(Optional.of(user));
        when(input.read()).thenReturn("Harry potter and the prisoner of Askaban....");
        checkoutBookCommand.perform(library,output,input, authenticator);

        verify(output).print("Enter the title of the item to be checked out : ");
        verify(output).print("That item is not available.\n");


    }
}