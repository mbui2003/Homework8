import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CokeHandlerTest {
    private CokeHandler cokeHandler;
    private SnackDispenseHandler nextHandler;

    @BeforeEach
    public void setUp() {
        nextHandler = new DoritosHandler(null);
        cokeHandler = new CokeHandler(nextHandler);
    }

    @Test
    @DisplayName("Test canHandle method with valid conditions")
    public void testCanHandleValid() {
        Snack coke = new Snack("Coke", 1.5, 2);

        assertTrue(cokeHandler.canHandle(coke, 2.0));
    }

    @Test
    @DisplayName("Test canHandle method with invalid conditions")
    public void testCanHandleInvalid() {
        Snack coke = new Snack("Coke", 1.5, 0);

        assertFalse(cokeHandler.canHandle(coke, 2.0));
    }
}