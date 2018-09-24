package controller.command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CredentialTest {

    @Test
    void equalsTestTrue() {
        Credential credential1 = new Credential(new LibraryNumber("123-5678"),new Password("password"),new User("Jack","jack@gmail.com","90000900000"));
        Credential credential2 = new Credential(new LibraryNumber("123-5678"),new Password("password"),new User("Jack","jack@gmail.com","90000900000"));
        assertEquals(credential1,credential2);
    }

    @Test
    void equalsTestFalse() {
        Credential credential1 = new Credential(new LibraryNumber("123-5678"),new Password("password"),new User("Jack","jack@gmail.com","90000900000"));
        Credential credential2 = new Credential(new LibraryNumber("123-5678"),new Password("password..."),new User("Jack","jack@gmail.com","90000900000"));
        assertNotEquals(credential1,credential2);
    }
}