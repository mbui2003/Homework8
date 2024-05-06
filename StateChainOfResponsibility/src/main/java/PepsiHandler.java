class PepsiHandler extends SnackDispenseHandler {
    public PepsiHandler(SnackDispenseHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    protected boolean canHandle(Snack snack, double insertedMoney) {
        return snack.getName().equals("Pepsi") && insertedMoney >= snack.getPrice() && snack.getQuantity() > 0;
    }
}