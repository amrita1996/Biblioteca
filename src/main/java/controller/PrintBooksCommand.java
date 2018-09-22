package controller;

import model.Library;
import view.Input;
import view.Output;

public class PrintBooksCommand implements Command {
    @Override
    public void perform(Library library, Output output, Input input) {
        output.splitAndPrint("Title-Author-Year\n");
        output.printHorizontalLine(110);
        output.print(library.getDetailsOfBooks());
    }
}
