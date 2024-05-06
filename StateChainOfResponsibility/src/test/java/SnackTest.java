import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SnackTest {
    private Snack snack;

    @BeforeEach
    public void setUp() {
        snack = new Snack("Cheetos", 1.0, 2);
    }

    @Test
    public void testGetName() {
        String expectedName = "Cheetos";
        String actualName = snack.getName();

        assertEquals(expectedName, actualName);
    }

    @Test
    public void testGetPrice() {
        double expectedPrice = 1.0;
        double actualPrice = snack.getPrice();

        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void testGetQuantity() {
        int expectedQuantity = 2;
        int actualQuantity = snack.getQuantity();

        assertEquals(expectedQuantity, actualQuantity);
    }

    @Test
    public void testSetQuantity() {
        snack.setQuantity(3);

        int expectedQuantity = 3;
        int actualQuantity = snack.getQuantity();

        assertEquals(expectedQuantity, actualQuantity);
    }
}