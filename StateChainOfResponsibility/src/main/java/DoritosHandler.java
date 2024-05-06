class DoritosHandler extends SnackDispenseHandler {
    public DoritosHandler(SnackDispenseHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    protected boolean canHandle(Snack snack, double insertedMoney) {
        return snack.getName().equals("Doritos") && insertedMoney >= snack.getPrice() && snack.getQuantity() > 0;
    }
}