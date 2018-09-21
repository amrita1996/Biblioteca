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
        String menu = "List of options\n1. List books\n0. Quit\nChoose an option : ";
        output.print(menu);
        performOperation();
    }

    private int getUserInput() {
        return Integer.parseInt(input.read());
    }

    private void performOperation() {
        int input;
        do {
            input = getUserInput();
            input = Menu.values().length-1 <= input ? Menu.values().length-1 : input;
            menu[input].perform(library,output);
        } while (input != 0);
    }



}
