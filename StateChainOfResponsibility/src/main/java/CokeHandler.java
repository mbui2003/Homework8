class CokeHandler extends SnackDispenseHandler {
    public CokeHandler(SnackDispenseHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    protected boolean canHandle(Snack snack, double insertedMoney) {
        return snack.getName().equals("Coke") && insertedMoney >= snack.getPrice() && snack.getQuantity() > 0;
    }
}