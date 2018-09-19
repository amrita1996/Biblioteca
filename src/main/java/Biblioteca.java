import view.Output;
import view.OutputDriver;

public class Biblioteca {


    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.start();
    }

    private void start() {
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(new OutputDriver());
        libraryManagementSystem.printWelcomeMessage();
        libraryManagementSystem.printListOfBooks();
    }




}
