package controller;

import model.BookGenerator;
import model.Library;
import view.Input;
import view.Output;

//A system that manages books and its details.
public class LibraryManagementSystem {
    private final String welcomeMessage = "Welcome !";
    private final Output output;
    private final Input input;
    private Library library;
    Menu menu[] = Menu.values();

    public LibraryManagementSystem(Output output, Input input) {
        this.output = output;
        this.input = input;
        this.library = new Library(new BookGenerator().addBooks());
    }

    public void printWelcomeMessage() {
        output.print(welcomeMessage);
    }


    public void menuOperation() {
        int option;
        do {
            printMenu();
            option = getUserInput();
            option = Menu.values().length-1 <= option ? Menu.values().length-1 : option;
            menu[option].perform(library,output,input);
        } while (option != 0);
    }

    private void printMenu() {
        output.print("\n\nMENU\n");
        for (Menu menuOption : menu) {
            menuOption.print(output);
        }
        output.print("Choose an option : ");
    }

    private int getUserInput() {
        return Integer.parseInt(input.read());
    }

}
