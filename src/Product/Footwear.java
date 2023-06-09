package Product;

public class Footwear extends Product {
    private final String gender;
    private final String size;
    private final String brand;
    public Footwear(int id, double price, String name, String gender, String size, String brand) {
        super(id, price, name);
        this.gender = gender;
        this.size = size;
        this.brand = brand;
    }

    public String isGender() {
        return gender;
    }

    public String getSize() {
        return size;
    }

    public String getBrand() {
        return brand;
    }
    public double getShippingCost() {
        return 0.25;
    }
    public double getTaxPercentage() {
        return 0.1;
    }
}
