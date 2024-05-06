import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SnickersHandlerTest {
    private SnickersHandler snickersHandler;
    private SnackDispenseHandler nextHandler;

    @BeforeEach
    public void setUp() {
        nextHandler = new KitKatHandler(null);
        snickersHandler = new SnickersHandler(nextHandler);
    }

    @Test
    public void testCanHandleValid() {
        Snack snickers = new Snack("Snickers", 1.0, 2);

        assertTrue(snickersHandler.canHandle(snickers, 1.5));
    }

    @Test
    public void testCanHandleInvalid() {
        Snack snickers = new Snack("Snickers", 1.0, 0);

        assertFalse(snickersHandler.canHandle(snickers, 0.5));
    }
}
