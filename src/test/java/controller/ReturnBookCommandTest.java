package controller;

import model.BookGenerator;
import model.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.Input;
import view.Output;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ReturnBookCommandTest {
    Output output;
    Input input ;
    Library library ;
    CheckoutBookCommand checkoutBookCommand;
    ReturnBookCommand returnBookCommand;

    @BeforeEach
    void init() {
        output = mock(Output.class);
        input = mock(Input.class);
        library = new Library(new BookGenerator().addBooks());
        checkoutBookCommand = new CheckoutBookCommand();
        returnBookCommand = new ReturnBookCommand();
    }

    @DisplayName("Should return a book that was checked out")
    @Test
    void returnBookValidCase() {

        when(input.read()).thenReturn("Harry potter and the prisoner of Askaban").thenReturn("Harry potter and the prisoner of Askaban");
        checkoutBookCommand.perform(library,output,input);
        returnBookCommand.perform(library,output,input);

        verify(output).print("Enter the title of the book to be returned : ");
        verify(output).print("Thank you for returning the book.\n");


    }

    @DisplayName("Should not return a book that was not checked out")
    @Test
    void returnBookInValidCase() {

        when(input.read()).thenReturn("Harry potter and the prisoner of Askaban");
        returnBookCommand.perform(library,output,input);

        verify(output).print("Enter the title of the book to be returned : ");
        verify(output).print("That is not a valid book to return.\n");


    }
}