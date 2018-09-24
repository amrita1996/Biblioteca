package controller.command;

public class InvalidUserException extends RuntimeException {
    public InvalidUserException(String string) {
        super(string);
    }
}
