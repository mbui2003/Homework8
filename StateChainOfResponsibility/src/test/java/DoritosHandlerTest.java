import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DoritosHandlerTest {
    private DoritosHandler doritosHandler;
    private SnackDispenseHandler nextHandler;

    @BeforeEach
    public void setUp() {
        nextHandler = new KitKatHandler(null);
        doritosHandler = new DoritosHandler(nextHandler);
    }

    @Test
    public void testCanHandleValid() {
        Snack doritos = new Snack("Doritos", 1.0, 2);

        assertTrue(doritosHandler.canHandle(doritos, 1.5));
    }

    @Test
    public void testCanHandleInvalid() {
        Snack doritos = new Snack("Doritos", 1.0, 0);

        assertFalse(doritosHandler.canHandle(doritos, 0.5));
    }
}
