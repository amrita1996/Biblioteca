package controller.command;

import java.util.Objects;

public class LibraryNumber {
    String libraryNumber;

    public LibraryNumber(String libraryNumber) {
        this.libraryNumber = libraryNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibraryNumber that = (LibraryNumber) o;
        return libraryNumber.equals(that.libraryNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libraryNumber);
    }
}
