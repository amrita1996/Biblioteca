import view.Output;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LibraryManagementSystem {
    private final String welcomeMessage = "Welcome !";
    private Output output;

    private List<Book> books = new ArrayList<>();

    LibraryManagementSystem(Output output) {
        this.output = output;
    }

    public void printWelcomeMessage() {
        output.print(welcomeMessage);
    }

    public void printListOfBooks() {
            output.print(books);
    }
}
