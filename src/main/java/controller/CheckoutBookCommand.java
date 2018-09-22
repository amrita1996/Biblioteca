package controller;

import model.Library;
import view.Input;
import view.Output;

public class CheckoutBookCommand implements Command {
    @Override
    public void perform(Library library, Output output, Input input) {
        output.print("Enter the title of the book to be checked out : ");
        String requestedTitle = input.read();
        String status = library.checkoutBook(requestedTitle) ? "Thank you! Enjoy the book.\n" : "That book is not available.\n";
        output.print(status);
    }
}
