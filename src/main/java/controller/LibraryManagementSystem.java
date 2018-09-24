package controller;

import controller.command.*;
import model.Library;
import view.Input;
import view.Output;

//A system that manages books and its details.
public class LibraryManagementSystem {
    private final String welcomeMessage = "Welcome !";
    private final Output output;
    private final Input input;
    private final Library library;
    private final Authenticator authenticator;
    Menu menu[] = Menu.values();

    public LibraryManagementSystem(Output output, Input input,Library library, Authenticator authenticator) {
        this.output = output;
        this.input = input;
        this.library = library;
        this.authenticator = authenticator;
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
            menu[option].perform(library,output,input,authenticator);
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
