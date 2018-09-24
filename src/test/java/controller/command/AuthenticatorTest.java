package controller.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticatorTest {
    Set<Credential> credentials;
    Authenticator authenticator;


    @BeforeEach
    void init() {
        credentials = new HashSet<>();
        credentials.add(new Credential(new LibraryNumber("123-45678"),new Password("password1"),new User("Amrita","amrita@gmail.com","80000800000")));
        credentials.add(new Credential(new LibraryNumber("123-45679"),new Password("password2"),new User("Jack","amrita@gmail.com","80000800000")));
        credentials.add(new Credential(new LibraryNumber("123-45688"),new Password("password3"),new User("Sam","amrita@gmail.com","80000800000")));
        credentials.add(new Credential(new LibraryNumber("123-45668"),new Password("password4"),new User("Nancy","amrita@gmail.com","80000800000")));
        credentials.add(new Credential(new LibraryNumber("123-45658"),new Password("password5"),new User("Liza","amrita@gmail.com","80000800000")));

        authenticator = new Authenticator(credentials);
    }

    @Test
    void authenticateTestTrue() {
        Credential credential = new Credential(new LibraryNumber("123-45678"),new Password("password1"),null);
        Optional<User> expected = Optional.of(new User("Amrita","amrita@gmail.com","80000800000"));
        Optional<User> actual = authenticator.authenticate(credential);
        assertEquals(expected,actual);
    }

    @Test
    void authenticateTestFalse() {
        Credential credential = new Credential(new LibraryNumber("123-45678"),new Password("password2"),null);
        Optional<User> expected = Optional.empty();
        Optional<User> actual = authenticator.authenticate(credential);
        assertEquals(expected,actual);
    }
}