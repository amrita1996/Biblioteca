package view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputDriverTest {

    @DisplayName("should read input")
    @Test
    void readTest() {
        setSystemIn("2");
        InputDriver inputDriver = new InputDriver();
        assertEquals("2",inputDriver.read());

    }

    void setSystemIn(String string) {
        System.setIn(new ByteArrayInputStream(string.getBytes()));
    }

    @AfterEach
    void setUp() {
        System.setIn(System.in);
    }
}