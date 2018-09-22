package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    @Test
    void equalsTestTrue() {
        Movie expected = new Movie("Silver linings playbook", new Year(2012),"David O Russel",new Rating(8));
        Movie actual = new Movie("Silver linings playbook", new Year(2012),"David O Russel",new Rating(8));
        assertEquals(expected,actual);
    }

    @Test
    void equalsTestFalse() {
        Movie expected = new Movie("Silver linings playbook", new Year(2012),"David O Russel",new Rating(8));
        Movie actual = new Movie("American Hustle", new Year(2013),"David O Russel",new Rating(7));
        assertNotEquals(expected,actual);
    }

    @Test
    void toStringTest() {
        String expected = "Silver linings playbook-2012-David O Russel-8\n";
        String actual = new Movie("Silver linings playbook", new Year(2012),"David O Russel",new Rating(8)).toString();
        assertEquals(expected,actual);
    }
}