public class DispensingSnackState implements StateOfVendingMachine {
    private VendingMachine vendingMachine;

    public DispensingSnackState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectSnack(String snackName) {
        System.out.println("Dispensing a snack, please wait.");
    }

    @Override
    public void insertMoney(double amountInserted) {
        System.out.println("Dispensing a snack, please wait.");
    }

    @Override
    public void dispenseSnack() {
        Snack selectedSnack = vendingMachine.getSelectedSnack();
        if(isInStock(selectedSnack)) {
            System.out.println("Dispensing " + selectedSnack.getName());
            selectedSnack.setQuantity(selectedSnack.getQuantity() - 1);
        } else {
            System.out.println("Sorry, " + selectedSnack.getName() + " is out of stock.");
        }
        vendingMachine.setState(new IdleState(vendingMachine));
    }

    private boolean isInStock(Snack selectedSnack) {
        return selectedSnack.getQuantity() > 0;
    }
}