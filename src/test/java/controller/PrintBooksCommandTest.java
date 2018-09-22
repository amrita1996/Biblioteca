package controller;

import model.BookGenerator;
import model.Library;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.Input;
import view.Output;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

class PrintBooksCommandTest {

    @DisplayName("Should display list of books")
    @Test
    void perform() {
        Output output = mock(Output.class);
        Input input = mock(Input.class);
        Library library = new Library(new BookGenerator().addBooks());
        PrintBooksCommand printBooksCommand = new PrintBooksCommand();

        printBooksCommand.perform(library,output,input);

        verify(output).splitAndPrint("Title-Author-Year\n");
        verify(output).print(library.getDetailsOfBooks());
    }
}