package Product;

public class Clothing extends Product {
    private final String gender;
    private final String size;

    public Clothing(int id, double price, String name, String gender, String size) {
        super(id, price, name);
        this.gender = gender;
        this.size = size;
    }

    public String isGender() {
        return gender;
    }

    public String getSize() {
        return size;
    }

    public double getShippingCost() {
        return 0.1;
    }
    public double getTaxPercentage() {
        return 0.3;
    }
}
