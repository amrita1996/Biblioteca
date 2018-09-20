package controller;

import model.BookGenerator;
import model.Library;
import view.Output;

//A system that manages books and its details.
public class LibraryManagementSystem {
    private final String welcomeMessage = "Welcome !";
    private final Output output;
    private Library library;

    public LibraryManagementSystem(Output output) {
        this.output = output;
        this.library = new Library(new BookGenerator().addBooks());
    }

    public void printWelcomeMessage() {
        output.print(welcomeMessage);
    }

    public void printListOfBooks() {
        for (String title: library.getTitlesOfBooks()) {
            output.print(title);
        }

    }
}
