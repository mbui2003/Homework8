class CheetosHandler extends SnackDispenseHandler {
    public CheetosHandler(SnackDispenseHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    protected boolean canHandle(Snack snack, double insertedMoney) {
        return snack.getName().equals("Cheetos") && insertedMoney >= snack.getPrice() && snack.getQuantity() > 0;
    }
}