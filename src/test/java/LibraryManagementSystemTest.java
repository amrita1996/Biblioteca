import view.Output;
import view.OutputDriver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LibraryManagementSystemTest {

    @DisplayName("should return the welcome message")
    @Test
    public void shouldReturnMessage() {
        OutputDriver output = mock(OutputDriver.class);
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(output);
        libraryManagementSystem.printWelcomeMessage();
        verify(output).print("Welcome !");
    }
}
