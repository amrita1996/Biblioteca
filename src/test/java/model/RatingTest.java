package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RatingTest {

    @Test
    void equalsTestTrue() {
        Rating expected = new Rating(5);
        Rating actual = new Rating(5);
        assertEquals(expected,actual);
    }

    @Test
    void equalsTestFalse() {
        Rating expected = new Rating(5);
        Rating actual = new Rating();
        assertNotEquals(expected,actual);
    }

    @Test
    void toStringTestRated() {
        String expected = "5";
        String actual = new Rating(5).toString();
        assertEquals(expected,actual);
    }

    @Test
    void toStringTestUnRated() {
        String expected = "UNRATED";
        String actual = new Rating().toString();
        assertEquals(expected,actual);
    }
}