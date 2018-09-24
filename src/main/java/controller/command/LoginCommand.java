package controller.command;

import model.Library;
import view.Input;
import view.Output;

import java.util.Optional;


public class LoginCommand implements Command {

    @Override
    public void perform(Library library, Output output, Input input, Authenticator authenticator) {
        output.print("\nLOGIN\n");
        output.print("\nEnter the library number(xxx-xxxx) : ");
        String libraryNumber = input.read();
        output.print("\nEnter the password : ");
        String password = input.read();
        Optional<User> user = authenticator.authenticate(new Credential(new LibraryNumber(libraryNumber),new Password(password),null));
        String status = user.isPresent() ? "\nYou have successfully logged in" : "\nInvalid credentials !";
        output.print(status);

    }


}
