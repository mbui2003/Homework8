public class Snack {
    private String snackName;
    private double snackPrice;
    private int snackQuantity;

    public Snack(String snackName, double snackPrice, int snackQuantity) {
        this.snackName = snackName;
        this.snackPrice = snackPrice;
        this.snackQuantity = snackQuantity;
    }

    public String getName() {
        return snackName;
    }

    public double getPrice() {
        return snackPrice;
    }

    public int getQuantity() {
        return snackQuantity;
    }

    public void setQuantity(int newQuantity) {
        this.snackQuantity = newQuantity;
    }
}
