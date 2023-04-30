package Product;

public class Cosmetics extends Product {
    private String brand;
    Cosmetics(int id, double price, int quantity, String brand) {
        super(id, price, quantity);
        this.brand = brand;
    }
}
