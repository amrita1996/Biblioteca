import controller.LibraryManagementSystem;
import view.InputDriver;
import view.OutputDriver;

//An application that drives the library management system.
public class BibliotecaApplication {


    public static void main(String[] args) {
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication();
        bibliotecaApplication.start();
    }

    private void start() {
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(new OutputDriver(),new InputDriver());
        libraryManagementSystem.printWelcomeMessage();
        libraryManagementSystem.menuOperation();
    }


}
