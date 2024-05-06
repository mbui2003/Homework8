import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CheetosHandlerTest {
    private CheetosHandler cheetosHandler;
    private SnackDispenseHandler nextHandler;

    @BeforeEach
    public void setUp() {
        nextHandler = new DoritosHandler(null);
        cheetosHandler = new CheetosHandler(nextHandler);
    }

    @Test
    public void testCanHandleValid() {
        Snack cheetos = new Snack("Cheetos", 1.0, 2);

        assertTrue(cheetosHandler.canHandle(cheetos, 1.5));
    }

    @Test
    public void testCanHandleInvalid() {
        Snack cheetos = new Snack("Cheetos", 1.0, 0);

        assertFalse(cheetosHandler.canHandle(cheetos, 0.5));
    }
}