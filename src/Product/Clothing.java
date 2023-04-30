package Product;

public class Clothing extends Product {
    private final String gender;
    private final String size;

    Clothing(int id, double price, String gender, String size) {
        super(id, price);
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
