package controller;

import model.BookGenerator;
import model.Library;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.Input;
import view.InputDriver;
import view.Output;
import view.OutputDriver;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class MenuTest {

    @DisplayName("Should print the list of books")
    @Test
    void printMessageForPrintBooks() {
        Output output = mock(OutputDriver.class);
        Menu menu = Menu.PRINT_BOOKS;
        menu.print(output);
        verify(output).print(menu.ordinal()+". "+menu.getString());
    }

    @DisplayName("Should print quit as an option")
    @Test
    void printMessageForQuit() {
        Output output = mock(OutputDriver.class);
        Menu menu = Menu.QUIT;
        menu.print(output);
        verify(output).print(menu.ordinal()+". "+menu.getString());
    }

    @DisplayName("Should print the message for checkout")
    @Test
    void printMessageForCheckOut() {
        Output output = mock(OutputDriver.class);
        Menu menu = Menu.CHECKOUT_BOOK;
        menu.print(output);
        verify(output).print(menu.ordinal()+". "+menu.getString());
    }



    @DisplayName("Should print the list of books")
    @Test
    void performPrintBooks() {
        Output output = mock(OutputDriver.class);
        Input input = mock(InputDriver.class);
        Library library = new Library(new BookGenerator().addBooks());
        Menu menu = Menu.PRINT_BOOKS;
        menu.perform(library, output,input);
        verify(output).print("Title-Author-Year\n");
        verify(output).print(library.getDetailsOfBooks());

    }

    @DisplayName("Should print choose another option")
    @Test
    void performPrintChooseAnotherOption() {
        Output output = mock(OutputDriver.class);
        Input input = mock(InputDriver.class);
        Library library = new Library(new BookGenerator().addBooks());
        Menu menu = Menu.DEFAULT;
        menu.perform(library, output,input);
        verify(output).print("Select a valid option!");


    }

    @DisplayName("Should quit")
    @Test
    void performQuit() {
        Output output = mock(OutputDriver.class);
        Input input = mock(InputDriver.class);
        Library library = new Library(new BookGenerator().addBooks());
        Menu menu = Menu.QUIT;
        menu.perform(library, output,input);
        verify(output).print("Quit !");


    }

    @DisplayName("Should checkout a book that exists and should display message")
    @Test
    void performCheckoutTrue() {
        Output output = mock(OutputDriver.class);
        Input input = mock(InputDriver.class);
        Library library = new Library(new BookGenerator().addBooks());
        Menu menu = Menu.CHECKOUT_BOOK;
        when(input.read()).thenReturn("Harry potter and the prisoner of Askaban");
        menu.perform(library, output,input);
        verify(output).print("Thank you! Enjoy the book.\n");


    }

    @DisplayName("Should not checkout a book that doesn't exist and should display message")
    @Test
    void performCheckoutFalse() {
        Output output = mock(OutputDriver.class);
        Input input = mock(InputDriver.class);
        Library library = new Library(new BookGenerator().addBooks());
        Menu menu = Menu.CHECKOUT_BOOK;
        when(input.read()).thenReturn("Harry potter and the prisoner of Askaban.....");
        menu.perform(library, output,input);
        verify(output).print("That book is not available.\n");


    }

    @DisplayName("Should return a book that exists and should display message")
    @Test
    void performReturnTrue() {
        Output output = mock(OutputDriver.class);
        Input input = mock(InputDriver.class);
        Library library = new Library(new BookGenerator().addBooks());
        Menu menuCheckout = Menu.CHECKOUT_BOOK;
        Menu menuReturn = Menu.RETURN_BOOK;
        when(input.read()).thenReturn("Harry potter and the prisoner of Askaban").thenReturn("Harry potter and the prisoner of Askaban");
        menuCheckout.perform(library, output,input);
        menuReturn.perform(library,output,input);
        verify(output).print("Thank you! Enjoy the book.\n");


    }

    @DisplayName("Should not checkout a book that doesn't exist and should display message")
    @Test
    void performReturnFalse() {
        Output output = mock(OutputDriver.class);
        Input input = mock(InputDriver.class);
        Library library = new Library(new BookGenerator().addBooks());
        Menu menu = Menu.RETURN_BOOK;
        when(input.read()).thenReturn("Harry potter");
        menu.perform(library, output,input);
        verify(output).print("That is not a valid book to return.\n");


    }
}