public class BibliotecaApplication {
    public static void main(String[] args) {
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication();
        bibliotecaApplication.start();
    }

    private void start() {
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem();
        System.out.print(libraryManagementSystem.getWelcomeMessage());

    }
}
