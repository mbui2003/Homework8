import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class WaitingForMoneyStateTest {
    private VendingMachine vendingMachine;
    private WaitingForMoneyState state;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        SnackDispenseHandler dispenserChain =
                new CokeHandler(new PepsiHandler(new CheetosHandler(new DoritosHandler(new KitKatHandler(new SnickersHandler(null))))));
        vendingMachine = new VendingMachine(dispenserChain);

        vendingMachine.addSnack(new Snack("Coke", 1.5, 1));
        vendingMachine.selectSnack("Coke");

        state = new WaitingForMoneyState(vendingMachine);
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testSelectSnack() {
        state.selectSnack("Pepsi");

        String expectedOutput = "Waiting for money, cannot select another snack.";
        String actualOutput = outContent.toString().trim();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testInsertMoneySufficient() {
        state.insertMoney(2.0);

        String expectedOutput = "";
        String actualOutput = outContent.toString().trim();

        assertEquals(expectedOutput, actualOutput);
        assertTrue(vendingMachine.getState() instanceof DispensingSnackState);
    }

    @Test
    public void testInsertMoneyInsufficient() {
        state.insertMoney(0.5);

        String expectedOutput = "Insufficient funds inserted. Please insert more money.";
        String actualOutput = outContent.toString().trim();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testDispenseSnack() {
        state.dispenseSnack();

        String expectedOutput = "Please insert money first.";
        String actualOutput = outContent.toString().trim();

        assertEquals(expectedOutput, actualOutput);
    }
}
