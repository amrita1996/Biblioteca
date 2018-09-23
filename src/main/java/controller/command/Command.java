package controller.command;

import model.Library;
import view.Input;
import view.Output;

public interface Command {

    void perform(Library library, Output output, Input input);
}
