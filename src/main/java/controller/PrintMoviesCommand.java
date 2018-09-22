package controller;

import model.Library;
import view.Input;
import view.Output;

public class PrintMoviesCommand implements Command {
    @Override
    public void perform(Library library, Output output, Input input) {
        output.splitAndPrint("Name-Year-Director-Rating");
        output.printHorizontalLine(165);
        output.print(library.getDetailsOfMovies());
    }
}
