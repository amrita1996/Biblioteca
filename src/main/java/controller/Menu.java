package controller;

import model.Library;
import view.Output;

public enum Menu {
    QUIT("Quit") {
        @Override
        public void perform(Library library, Output output) {
            output.print("Quit !");
        }
    },
    PRINT_BOOKS("Print the list of books") {
        @Override
        public void perform(Library library,Output output) {
            for (String string : library.getDetailsOfBooks()) {
                String strings[] = string.split("-");
                output.print(strings[0], strings[1], strings[2]);
            }
        }
    },
    DEFAULT("Select a valid option!") {
        @Override
        public void perform(Library library, Output output) {
            output.print("Select a valid option!");
        }
    };


    private final String string;

    Menu(String string) {
        this.string = string;
    }

    abstract void perform(Library library, Output output);

}
