class SnickersHandler extends SnackDispenseHandler {
    public SnickersHandler(SnackDispenseHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    protected boolean canHandle(Snack snack, double insertedMoney) {
        return snack.getName().equals("Snickers") && insertedMoney >= snack.getPrice() && snack.getQuantity() > 0;
    }
}