package Product;

public class Cosmetics extends Product {
    private final String brand;
    Cosmetics(int id, double price, String brand) {
        super(id, price);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
}
