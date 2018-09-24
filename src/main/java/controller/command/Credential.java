package controller.command;

import java.util.Objects;

public class Credential {
    private final LibraryNumber libraryNumber;
    private final Password password;
    private final User user;

    public Credential(LibraryNumber libraryNumber, Password password, User user) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Credential that = (Credential) o;
        return libraryNumber.equals(that.libraryNumber) &&
               password.equals(that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libraryNumber, password);
    }
}
