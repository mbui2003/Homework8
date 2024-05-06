import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private StateOfVendingMachine state;
    private Snack selectedSnack;
    private Map<String, Snack> snacks;
    private SnackDispenseHandler dispenserChain;

    public VendingMachine(SnackDispenseHandler dispenserChain) {
        this.state = new IdleState(this);
        this.snacks = new HashMap<>();
        this.dispenserChain = dispenserChain;
    }

    public void setState(StateOfVendingMachine newState) {
        this.state = newState;
    }

    public StateOfVendingMachine getState() {
        return state;
    }

    public void setSelectedSnack(String snackName) {
        this.selectedSnack = snacks.get(snackName);
    }

    public Snack getSelectedSnack() {
        return selectedSnack;
    }

    public void insertMoney(double amountInserted) {
        state.insertMoney(amountInserted);
    }

    public void selectSnack(String snackName) {
        state.selectSnack(snackName);
    }

    public void dispenseSnack() {
        state.dispenseSnack();
    }

    public void addSnack(Snack snack) {
        snacks.put(snack.getName(), snack);
    }
}
