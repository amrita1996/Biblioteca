package controller.command;

import model.BookAndMovieGenerator;
import model.ItemType;
import model.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.Input;
import view.Output;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CheckoutCommandTest {
    Output output;
    Input input ;
    Library library ;
    CheckoutCommand checkoutBookCommand;
    CheckoutCommand checkoutMovieCommand;

    @BeforeEach
    void init() {
        output = mock(Output.class);
        input = mock(Input.class);
        library = new Library(new BookAndMovieGenerator().generate());
        checkoutBookCommand = new CheckoutCommand(ItemType.BOOK);
        checkoutMovieCommand = new CheckoutCommand(ItemType.MOVIE);
    }

    @DisplayName("Should return a book that was checked out")
    @Test
    void checkoutBookValidCase() {

        when(input.read()).thenReturn("Harry potter and the prisoner of Askaban");
        checkoutBookCommand.perform(library,output,input);

        verify(output).print("Enter the title of the book to be checked out : ");
        verify(output).print("Thank you! Enjoy the book.\n");


    }

    @DisplayName("Should not return a book that was not checked out")
    @Test
    void checkoutBookInValidCase() {

        when(input.read()).thenReturn("Harry potter and the prisoner of Askaban....");
        checkoutBookCommand.perform(library,output,input);

        verify(output).print("Enter the title of the book to be checked out : ");
        verify(output).print("That book is not available.\n");


    }
}