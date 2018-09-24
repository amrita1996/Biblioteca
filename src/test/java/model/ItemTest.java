package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void equalsTestTrue() {
        Item item1 = new Item("something",ItemType.MOVIE);
        Item item2 = new Item("something",ItemType.MOVIE);
        assertEquals(item1,item2);
    }
    @Test
    void equalsTestFalse() {
        Item item1 = new Item("something",ItemType.MOVIE);
        Item item2 = new Item("something",ItemType.BOOK);
        assertNotEquals(item1,item2);
    }

    @Test
    void getType() {
        ItemType expected = ItemType.BOOK;
        ItemType actual = new Item("Something",ItemType.BOOK).getType();
        assertEquals(expected,actual);
    }
}