class KitKatHandler extends SnackDispenseHandler {
    public KitKatHandler(SnackDispenseHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    protected boolean canHandle(Snack snack, double insertedMoney) {
        return snack.getName().equals("KitKat") && insertedMoney >= snack.getPrice() && snack.getQuantity() > 0;
    }
}