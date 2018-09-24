package model;

import controller.command.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Library {

    private final List<Item> allItems;
    private final List<Item> currentItems;
    private final Set<User> users;

    public Library(List<Item> items) {
        this.allItems = items;
        currentItems = new ArrayList<>(items);
        users = new HashSet<>();
    }

    public List<String> getDetailsOfBooks() {
        List<String> details = new ArrayList<>();
        for (Item item : currentItems) {
            if(item.getType() == ItemType.BOOK) {
                details.add(item.toString());
            }
        }
        return details;
    }

    public List<String> getDetailsOfMovies() {
        List<String> details = new ArrayList<>();
        for (Item item : currentItems) {
            if(item.getType() == ItemType.MOVIE) {
                details.add(item.toString());
            }
        }
        return details;
    }

    public boolean checkout(String requestedTitle, ItemType itemType) {
        Item requestedItem = new Item(requestedTitle,itemType);
        if(currentItems.contains(requestedItem)) {
            currentItems.remove(requestedItem);
            return true;
        }
        return false;
    }

    public boolean returnItem(String requestedTitle, ItemType itemType) {
        Item requestedItem = new Item(requestedTitle,itemType);
        if(allItems.contains(requestedItem) && !currentItems.contains(requestedItem)) {
            getItemFromListAndAdd(requestedItem);
            return true;
        }
        return false;
    }

    private void getItemFromListAndAdd(Item requestedItem) {
        for (Item item: allItems) {
            if(item.equals(requestedItem)) {
                currentItems.add(item);

            }
        }
    }

}
