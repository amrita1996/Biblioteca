package controller;

import controller.command.Credential;
import controller.command.LibraryNumber;
import controller.command.Password;
import controller.command.User;

import java.util.HashSet;
import java.util.Set;

public class CredentialBuilder {
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


