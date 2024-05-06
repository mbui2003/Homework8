import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KitKatHandlerTest {
    private KitKatHandler kitKatHandler;
    private SnackDispenseHandler nextHandler;

    @BeforeEach
    public void setUp() {
        nextHandler = new SnickersHandler(null);
        kitKatHandler = new KitKatHandler(nextHandler);
    }

    @Test
    public void testCanHandleValid() {
        Snack kitKat = new Snack("KitKat", 1.0, 2);

        assertTrue(kitKatHandler.canHandle(kitKat, 1.5));
    }

    @Test
    public void testCanHandleInvalid() {
        Snack kitKat = new Snack("KitKat", 1.0, 0);

        assertFalse(kitKatHandler.canHandle(kitKat, 0.5));
    }
}
