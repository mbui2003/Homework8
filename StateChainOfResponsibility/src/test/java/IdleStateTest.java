import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class IdleStateTest {
    private VendingMachine vendingMachine;
    private StateOfVendingMachine state;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        SnackDispenseHandler dispenserChain =
                new CokeHandler(new PepsiHandler(new CheetosHandler(new DoritosHandler(new KitKatHandler(new SnickersHandler(null))))));
        vendingMachine = new VendingMachine(dispenserChain);

        state = new IdleState(vendingMachine);
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testSelectSnack() {
        state.selectSnack("Coke");

        String expectedOutput = "Snack selected: Coke";
        String actualOutput = outContent.toString().trim();

        assertEquals(expectedOutput, actualOutput);
        assertTrue(vendingMachine.getState() instanceof WaitingForMoneyState);
    }

    @Test
    public void testInsertMoney() {
        state.insertMoney(2.0);

        String expectedOutput = "Please select a snack first.";
        String actualOutput = outContent.toString().trim();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testDispenseSnack() {
        state.dispenseSnack();

        String expectedOutput = "Please select a snack first.";
        String actualOutput = outContent.toString().trim();

        assertEquals(expectedOutput, actualOutput);
    }
}
