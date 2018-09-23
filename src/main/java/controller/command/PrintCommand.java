package controller.command;

import model.ItemType;
import model.Library;
import view.Input;
import view.Output;

public class PrintCommand implements Command {
    private final ItemType itemType;

    public PrintCommand(ItemType itemType) {
        this.itemType = itemType;
    }

    @Override
    public void perform(Library library, Output output, Input input) {
        if (itemType == ItemType.BOOK) {
            printBooks(library, output);
        } else {
            printMovies(library, output);
        }

    }

    private void printMovies(Library library, Output output) {
        output.splitAndPrint("Title-Author-Year\n");
        output.printHorizontalLine(160);
        output.print(library.getDetailsOfMovies());
    }

    private void printBooks(Library library, Output output) {
        output.splitAndPrint("Title-Author-Year\n");
        output.printHorizontalLine(110);
        output.print(library.getDetailsOfBooks());
    }
}
