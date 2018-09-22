package controller;

import model.BookAndMovieGenerator;
import model.Library;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.Input;
import view.Output;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class PrintMoviesCommandTest {

    @DisplayName("Should display list of books")
    @Test
    void perform() {
        Output output = mock(Output.class);
        Input input = mock(Input.class);
        Library library = new Library(new BookAndMovieGenerator().addBooks(),new BookAndMovieGenerator().addMovies());
        PrintMoviesCommand printMoviesCommand = new PrintMoviesCommand();

        printMoviesCommand.perform(library,output,input);

        verify(output).splitAndPrint("Name-Year-Director-Rating");
        verify(output).print(library.getDetailsOfMovies());
    }
}