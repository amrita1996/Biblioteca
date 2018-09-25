package controller;

import controller.command.Authenticator;
import controller.command.Command;
import model.Library;
import view.Input;
import view.Output;

public class ViewUserDetailsCommand implements Command {
    @Override
    public void perform(Library library, Output output, Input input, Authenticator authenticator) {
        output.print(authenticator.getSessionUser().get().toString());
    }
}
