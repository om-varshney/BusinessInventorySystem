package Product;

public class Footwear extends Product {
    private final String gender;
    private final String size;
    private final String brand;
    Footwear(int id, double price, String gender, String size, String brand) {
        super(id, price);
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
}
