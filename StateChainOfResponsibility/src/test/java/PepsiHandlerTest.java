import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PepsiHandlerTest {
    private PepsiHandler pepsiHandler;
    private SnackDispenseHandler nextHandler;

    @BeforeEach
    public void setUp() {
        nextHandler = new CheetosHandler(null);
        pepsiHandler = new PepsiHandler(nextHandler);
    }

    @Test
    public void testCanHandleValid() {
        Snack pepsi = new Snack("Pepsi", 1.0, 2);

        assertTrue(pepsiHandler.canHandle(pepsi, 1.5));
    }

    @Test
    public void testCanHandleInvalid() {
        Snack pepsi = new Snack("Pepsi", 1.0, 0);

        assertFalse(pepsiHandler.canHandle(pepsi, 0.5));
    }
}