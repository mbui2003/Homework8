public class Driver {
    public static void main(String[] args) {
        SnackDispenseHandler dispenserChain = createSnackDispenserChain();

        VendingMachine vendingMachine = new VendingMachine(dispenserChain);

        vendingMachine.addSnack(new Snack("Coke", 1.5, 5));
        vendingMachine.addSnack(new Snack("Pepsi", 1.5, 3));
        vendingMachine.addSnack(new Snack("Cheetos", 1.0, 7));
        vendingMachine.addSnack(new Snack("Doritos", 1.25, 4));
        vendingMachine.addSnack(new Snack("KitKat", 1.0, 6));
        vendingMachine.addSnack(new Snack("Snickers", 1.25, 0));

        // Select and dispense a snack
        vendingMachine.selectSnack("Coke");
        vendingMachine.insertMoney(2.0); // Insert more money than needed
        vendingMachine.dispenseSnack();
        System.out.println();

        // Select a snack that is out of stock
        vendingMachine.selectSnack("Snickers");
        vendingMachine.insertMoney(1.5); // Insert money for out-of-stock snack
        vendingMachine.dispenseSnack();
        System.out.println();

        // Select another snack and insert sufficient money
        vendingMachine.selectSnack("Pepsi");
        vendingMachine.insertMoney(1.5); // Insert sufficient money
        vendingMachine.dispenseSnack();
        System.out.println();

        // Select another snack and insert insufficient money
        vendingMachine.selectSnack("Doritos");
        vendingMachine.insertMoney(1.0); // Insert insufficient money
        vendingMachine.dispenseSnack();
    }

    // Create the chain of responsibility for snack dispensing
    private static SnackDispenseHandler createSnackDispenserChain() {
        return new CokeHandler(new PepsiHandler(new CheetosHandler(new DoritosHandler(new KitKatHandler(new SnickersHandler(null))))));
    }
}