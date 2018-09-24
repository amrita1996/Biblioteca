package controller.command;

import controller.CredentialBuilder;
import model.BookAndMovieGenerator;
import model.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.Input;
import view.Output;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class LoginCommandTest {
    Library library;
    Output output;
    Input input;
    LoginCommand loginCommand;
    User user;
    Authenticator authenticator;

    @BeforeEach
    void init() {
        library = new Library(new BookAndMovieGenerator().generate());
        output = mock(Output.class);
        input = mock(Input.class);
        authenticator = new Authenticator(new CredentialBuilder().generate());
        loginCommand = new LoginCommand();
        user = new User("Amrita","amrita@gmail.com","80000800000");
    }

    @DisplayName("Should authenticate a user with valid credentials")
    @Test
    void authenticationTest() {
        when(input.read()).thenReturn("123-4567").thenReturn("password1");
        loginCommand.perform(library,output,input, authenticator);
        verify(output).print("\nEnter the library number(xxx-xxxx) : ");
        verify(output).print("\nEnter the password : ");
        verify(output).print("\nYou have successfully logged in");
    }

    @DisplayName("Should not authenticate a user with valid credentials")
    @Test
    void authenticationTestFalse() {
        when(input.read()).thenReturn("123-45678").thenReturn("password12");
        loginCommand.perform(library,output,input, authenticator);
        verify(output).print("\nEnter the library number(xxx-xxxx) : ");
        verify(output).print("\nEnter the password : ");
        verify(output).print("\nInvalid credentials !");
    }

}