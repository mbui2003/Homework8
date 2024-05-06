import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DispensingSnackStateTest {
    private VendingMachine vendingMachine;
    private StateOfVendingMachine state;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        SnackDispenseHandler dispenserChain =
                new CokeHandler(new PepsiHandler(new CheetosHandler(new DoritosHandler(new KitKatHandler(new SnickersHandler(null))))));
        vendingMachine = new VendingMachine(dispenserChain);

        vendingMachine.addSnack(new Snack("Coke", 1.5, 1));
        vendingMachine.selectSnack("Coke");

        state = new DispensingSnackState(vendingMachine);

        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testSelectSnack() {
        state.selectSnack("Pepsi");

        String expectedOutput = "Dispensing a snack, please wait.";
        String actualOutput = outContent.toString().trim();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testInsertMoney() {
        state.insertMoney(2.0);

        String expectedOutput = "Dispensing a snack, please wait.";
        String actualOutput = outContent.toString().trim();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testDispenseSnackAvailable() {
        state.dispenseSnack();

        int expectedQuantity = 0;
        int actualQuantity = vendingMachine.getSelectedSnack().getQuantity();

        assertEquals(expectedQuantity, actualQuantity);
        assertTrue(vendingMachine.getState() instanceof IdleState);
    }

    @Test
    public void testDispenseSnackNotAvailable() {
        state.dispenseSnack();
        state.dispenseSnack();

        String expectedOutput = "Dispensing Coke\nSorry, Coke is out of stock.";
        String actualOutput = outContent.toString().trim();

        assertEquals(expectedOutput, actualOutput);
    }
}
