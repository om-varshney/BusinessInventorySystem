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
    public double getShippingCost() {
        return 0.2;
    }
    public double getTaxPercentage() {
        return 0.15;
    }
}
