package model;

import java.util.Objects;

public class Item {
    protected final String title;
    protected final ItemType type;

    public Item(String title, ItemType type) {
        this.title = title;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        Item item = (Item) o;
        return title.equals(item.title) &&
                type == item.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type);
    }

    public ItemType getType() {
        return type;
    }
}
