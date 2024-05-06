import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VendingMachineTest {
    private VendingMachine vendingMachine;
    private SnackDispenseHandler dispenserChain;
    private Snack expectedSnack;

    @BeforeEach
    public void setUp() {
        dispenserChain = new CokeHandler(new PepsiHandler(null));
        vendingMachine = new VendingMachine(dispenserChain);
        expectedSnack = new Snack("Coke", 1.5, 2);
        vendingMachine.addSnack(expectedSnack);
        vendingMachine.setSelectedSnack("Coke");
    }

    @Test
    public void testSetState() {
        vendingMachine.setState(new DispensingSnackState(vendingMachine));
        assertTrue(vendingMachine.getState() instanceof DispensingSnackState);
    }

    @Test
    public void testSetSelectedSnack() {
        expectedSnack = new Snack("Pepsi", 1.5, 2);
        vendingMachine.addSnack(expectedSnack);
        vendingMachine.setSelectedSnack("Pepsi");

        Snack actualSnack = vendingMachine.getSelectedSnack();

        assertEquals(expectedSnack, actualSnack);
    }

    @Test
    public void testGetSelectedSnack() {
        Snack actualSnack = vendingMachine.getSelectedSnack();

        assertEquals(expectedSnack, actualSnack);
    }

    @Test
    public void testInsertMoney() {
        vendingMachine.setState(new WaitingForMoneyState(vendingMachine));
        vendingMachine.insertMoney(2.0);
        assertTrue(vendingMachine.getState() instanceof DispensingSnackState); // After inserting money, the state should transition to WaitingForMoneyState
    }

    @Test
    public void testSelectSnack() {
        vendingMachine.setState(new IdleState(vendingMachine));
        vendingMachine.selectSnack("Coke");
        assertTrue(vendingMachine.getState() instanceof WaitingForMoneyState); // After selecting a snack, the state should transition to WaitingForMoneyState
    }

    @Test
    public void testDispenseSnack() {
        vendingMachine.setState(new DispensingSnackState(vendingMachine));
        vendingMachine.dispenseSnack();
        assertTrue(vendingMachine.getState() instanceof IdleState); // After dispensing a snack, the state should transition to IdleState
    }

    @Test
    public void testAddSnack() {
        Snack coke = new Snack("Coke", 1.5, 2);
        vendingMachine.addSnack(coke);
        assertNotNull(vendingMachine.getSelectedSnack());
    }
}
