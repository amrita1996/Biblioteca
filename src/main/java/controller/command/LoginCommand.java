package controller.command;

import model.Library;
import view.Input;
import view.Output;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


public class LoginCommand implements Command {
    Authenticator authenticator;

    public LoginCommand() {
        this.authenticator = new Authenticator(new CredentialBuilder().generate());
    }

    @Override
    public void perform(Library library, Output output, Input input) {
        output.print("\nLOGIN\n");
        output.print("\nEnter the library number(xxx-xxxx) : ");
        String libraryNumber = input.read();
        output.print("\nEnter the password : ");
        String password = input.read();
        Optional<User> user = authenticator.authenticate(new Credential(new LibraryNumber(libraryNumber),new Password(password),null));
        String status = user.isPresent() ? "\nYou have successfully logged in" : "\nInvalid credentials !";
        output.print(status);

    }

    private class CredentialBuilder {
        public Set<Credential> generate() {
            Set<Credential> credentials = new HashSet<>();
            credentials.add(new Credential(new LibraryNumber("123-45678"),new Password("password1"),new User("Amrita","amrita@gmail.com","80000800000")));
            credentials.add(new Credential(new LibraryNumber("123-45679"),new Password("password2"),new User("Jack","amrita@gmail.com","80000800000")));
            credentials.add(new Credential(new LibraryNumber("123-45688"),new Password("password3"),new User("Sam","amrita@gmail.com","80000800000")));
            credentials.add(new Credential(new LibraryNumber("123-45668"),new Password("password4"),new User("Nancy","amrita@gmail.com","80000800000")));
            credentials.add(new Credential(new LibraryNumber("123-45658"),new Password("password5"),new User("Liza","amrita@gmail.com","80000800000")));

            return credentials;
        }
    }
}
