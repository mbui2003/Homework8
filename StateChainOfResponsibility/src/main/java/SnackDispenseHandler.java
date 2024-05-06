public abstract class SnackDispenseHandler {
    private SnackDispenseHandler nextHandler;

    public SnackDispenseHandler(SnackDispenseHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void dispense(Snack snack, double insertedMoney) {
        if (canHandle(snack, insertedMoney)) {
            System.out.println("Dispensing " + snack.getName());
            snack.setQuantity(snack.getQuantity() - 1);
        } else if (nextHandler != null) {
            nextHandler.dispense(snack, insertedMoney);
        } else {
            System.out.println("Sorry, unable to dispense " + snack.getName());
        }
    }

    protected abstract boolean canHandle(Snack snack, double insertedMoney);
}
