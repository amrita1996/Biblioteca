import controller.CredentialBuilder;
import controller.LibraryManagementSystem;
import controller.command.Authenticator;
import model.BookAndMovieGenerator;
import model.Library;
import view.InputDriver;
import view.OutputDriver;

//An application that drives the library management system.
public class BibliotecaApplication {


    public static void main(String[] args) {
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication();
        bibliotecaApplication.start();
    }

    private void start() {
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(
                new OutputDriver(),
                new InputDriver(),
                new Library(new BookAndMovieGenerator().generate()),
                new Authenticator(new CredentialBuilder().generate()));
        libraryManagementSystem.printWelcomeMessage();
        libraryManagementSystem.menuOperation();
   }


}
