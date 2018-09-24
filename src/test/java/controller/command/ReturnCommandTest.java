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

class ReturnCommandTest {
    Output output;
    Input input ;
    Library library ;
    Authenticator authenticator;
    User user;
    CheckoutCommand checkoutBookCommand;
    ReturnCommand returnBookCommand;
    CheckoutCommand checkoutMovieCommand;
    ReturnCommand returnMovieCommand;

    @BeforeEach
    void init() {
        output = mock(Output.class);
        input = mock(Input.class);
        user = new User("Amrita","xyz@gmail.com","6345716345");
        authenticator = mock(Authenticator.class);
        library = new Library(new BookAndMovieGenerator().generate());
        checkoutBookCommand = new CheckoutCommand(ItemType.BOOK);
        returnBookCommand = new ReturnCommand(ItemType.BOOK);
        checkoutMovieCommand = new CheckoutCommand(ItemType.MOVIE);
        returnMovieCommand = new ReturnCommand(ItemType.MOVIE);
    }

    @DisplayName("Should return a book that was checked out")
    @Test
    void returnBookValidCase() {

        when(authenticator.getSessionUser()).thenReturn(Optional.of(user));
        when(input.read()).thenReturn("Harry potter and the prisoner of Askaban").thenReturn("Harry potter and the prisoner of Askaban");
        checkoutBookCommand.perform(library,output,input, authenticator);
        returnBookCommand.perform(library,output,input, authenticator);

        verify(output).print("Enter the title of the item to be returned : ");
        verify(output).print("Thank you for returning the item.\n");


    }

    @DisplayName("Should not return a book that was not checked out")
    @Test
    void returnBookInValidCase() {
        when(authenticator.getSessionUser()).thenReturn(Optional.of(user));
        when(input.read()).thenReturn("Harry potter and the prisoner of Askaban");
        returnBookCommand.perform(library,output,input, authenticator);

        verify(output).print("Enter the title of the item to be returned : ");
        verify(output).print("That is not a valid item to return.\n");


    }
}