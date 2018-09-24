package controller.command;

import model.ItemType;
import model.Library;
import view.Input;
import view.Output;

public class CheckoutCommand implements Command {
    private ItemType itemType;

    public CheckoutCommand(ItemType itemType) {
        this.itemType = itemType;
    }

    @Override
    public void perform(Library library, Output output, Input input, Authenticator authenticator) {
        output.print("Enter the title of the item to be checked out : ");
        String requestedTitle = input.read();
        String status = library.checkout(requestedTitle,itemType) ? "Thank you! Enjoy the item.\n" : "That item is not available.\n";
        output.print(status);
    }
}
