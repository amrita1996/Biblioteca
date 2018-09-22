package controller;

import model.Library;
import view.Input;
import view.Output;

public enum Menu {
    QUIT("Quit",null) {
        @Override
        public void perform(Library library, Output output, Input input) {
            output.print("Quit !");
        }

    },
    PRINT_BOOKS("Print the list of books",new PrintBooksCommand()),
    CHECKOUT_BOOK("Checkout a book",new CheckoutBookCommand()),
    RETURN_BOOK("Return a book",new ReturnBookCommand()),
    DEFAULT("Select a valid option!",null) {
        @Override
        public void perform(Library library, Output output, Input input) {
            output.print("Select a valid option!");
        }

        void print(Output output) {

        }

    };


    private final String string;
    private final Command action;

    Menu(String string, Command action) {
        this.string = string;
        this.action = action;
    }

    public String getString() {
        return string;
    }

    void perform(Library library, Output output, Input input){
        this.action.perform(library,output,input);
    }
    void print(Output output) {
        output.print(this.ordinal()+". "+getString());
    }


}
