import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryManagementSystemTest {

    @DisplayName("should return the welcome message")
    @Test
    public void shouldReturnMessage() {
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem();
        String actual = libraryManagementSystem.getWelcomeMessage();
        String expected =  "Welcome !";

        assertEquals(expected,actual);
    }
}
