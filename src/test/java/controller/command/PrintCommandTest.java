package controller.command;

import model.BookAndMovieGenerator;
import model.ItemType;
import model.Library;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.Input;
import view.Output;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class PrintCommandTest {

    @DisplayName("Should display list of books")
    @Test
    void perform() {
        Output output = mock(Output.class);
        Input input = mock(Input.class);
        Library library = new Library(new BookAndMovieGenerator().generate());
        PrintCommand printCommand = new PrintCommand(ItemType.BOOK);

        printCommand.perform(library,output,input);

        verify(output).splitAndPrint("Title-Author-Year\n");
        verify(output).print(library.getDetailsOfBooks());
    }
}