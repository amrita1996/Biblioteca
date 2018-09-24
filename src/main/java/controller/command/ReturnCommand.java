package controller.command;

import model.ItemType;
import model.Library;
import view.Input;
import view.Output;

public class ReturnCommand implements Command {
    private final ItemType itemType;

    public ReturnCommand(ItemType itemType) {
        this.itemType = itemType;
    }

    @Override
    public void perform(Library library, Output output, Input input, Authenticator authenticator) {
        output.print("Enter the title of the item to be returned : ");
        String requestedTitle = input.read();
        String status = library.returnItem(requestedTitle,itemType) ? "Thank you for returning the item.\n" : "That is not a valid item to return.\n";
        output.print(status);
    }
}
