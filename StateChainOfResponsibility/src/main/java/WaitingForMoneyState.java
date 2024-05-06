public class WaitingForMoneyState implements StateOfVendingMachine {
    private VendingMachine vendingMachine;

    public WaitingForMoneyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectSnack(String snackName) {
        System.out.println("Waiting for money, cannot select another snack.");
    }

    @Override
    public void insertMoney(double amountInserted) {
        if(amountInsertedIsSufficient(amountInserted)) {
            vendingMachine.setState(new DispensingSnackState(vendingMachine));
        } else {
            System.out.println("Insufficient funds inserted. Please insert more money.");
        }
    }

    private boolean amountInsertedIsSufficient(double amountInserted) {
        return amountInserted >= vendingMachine.getSelectedSnack().getPrice();
    }

    @Override
    public void dispenseSnack() {
        System.out.println("Please insert money first.");
    }
}
