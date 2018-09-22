package controller;

import model.Library;
import view.Input;
import view.Output;

public class ReturnBookCommand implements Command {
    @Override
    public void perform(Library library, Output output, Input input) {
        output.print("Enter the title of the book to be returned : ");
        String requestedTitle = input.read();
        String status = library.returnBook(requestedTitle) ? "Thank you for returning the book.\n" : "That is not a valid book to return.\n";
        output.print(status);
    }
}
