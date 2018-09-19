import view.Output;

public class LibraryManagementSystem {
    private final String welcomeMessage = "Welcome !";
    private Output output;

    LibraryManagementSystem(Output output) {
        this.output = output;
    }

    public void printWelcomeMessage() {
        output.print(welcomeMessage);
    }
}
