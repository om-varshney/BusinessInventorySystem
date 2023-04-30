package Product;

public class Clothing extends Product {
    private boolean gender;
    private int size;
    Clothing(int id, double price, int quantity, boolean gender, int size) {
        super(id, price, quantity);
        this.gender = gender;
        this.size = size;
    }
}
