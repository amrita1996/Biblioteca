package controller;

import controller.command.*;
import model.ItemType;
import model.Library;
import view.Input;
import view.Output;

public enum Menu {
    QUIT("Quit",null) {
        @Override
        public void perform(Library library, Output output, Input input, Authenticator authenticator) {
            output.print("Quit !");
        }

    },
    PRINT_BOOKS("Print the list of books",new PrintCommand(ItemType.BOOK)),
    CHECKOUT_BOOK("Checkout a book",new CheckoutCommand(ItemType.BOOK)),
    RETURN_BOOK("Return a book",new ReturnCommand(ItemType.BOOK)),
    PRINT_MOVIES("Print the list of movies",new PrintCommand(ItemType.MOVIE)),
    CHECKOUT_MOVIE("Checkout a movie",new CheckoutCommand(ItemType.MOVIE)),
    RETURN_MOVIE("Return a movie",new ReturnCommand(ItemType.MOVIE)),
    DEFAULT("Select a valid option!",null) {
        @Override
        public void perform(Library library, Output output, Input input, Authenticator authenticator) {
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

    void perform(Library library, Output output, Input input, Authenticator authenticator){
        this.action.perform(library,output,input,authenticator);
    }
    void print(Output output) {
        output.print(this.ordinal()+". "+getString());
    }


}
