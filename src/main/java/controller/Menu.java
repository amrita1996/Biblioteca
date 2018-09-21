package controller;

import model.Library;
import view.Input;
import view.Output;

public enum Menu {
    QUIT("Quit") {
        @Override
        public void perform(Library library, Output output, Input input) {
            output.print("Quit !");
        }

        void print(Output output) {
            output.print(this.ordinal()+". "+getString());
        }
    },
    PRINT_BOOKS("Print the list of books") {
        @Override
        public void perform(Library library,Output output, Input input) {
            output.print("Title","Author","Year");
            output.printHorizontalLine(110);
            for (String string : library.getDetailsOfBooks()) {
                String strings[] = string.split("-");
                output.print(strings[0], strings[1], strings[2]);
            }
        }

        void print(Output output) {
            output.print(this.ordinal()+". "+getString());
        }
    },
    CHECKOUT("Checkout a book") {
        @Override
        void perform(Library library, Output output, Input input) {
            output.print("Enter the title of the book to be checked out : ");
            String requestedTitle = input.read();
            String status = library.checkout(requestedTitle) ? "Thank you! Enjoy the book.\n" : "That book is not available.\n";
            output.print(status);
        }

        @Override
        void print(Output output) {
            output.print(this.ordinal()+". "+getString());
        }
    },
    RETURN("Return a book") {
        @Override
        void perform(Library library, Output output, Input input) {
            output.print("Enter the title of the book to be returned : ");
            String requestedTitle = input.read();
            String status = library.returnBook(requestedTitle) ? "Thank you for returning the book.\n" : "That is not a valid book to return.\n";
            output.print(status);
        }

        @Override
        void print(Output output) {
            output.print(this.ordinal()+". "+getString());
        }
    },
    DEFAULT("Select a valid option!") {
        @Override
        public void perform(Library library, Output output, Input input) {
            output.print("Select a valid option!");
        }

        void print(Output output) {

        }

    };


    private final String string;

    Menu(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    abstract void perform(Library library, Output output, Input input);
    abstract void print(Output output);


}
