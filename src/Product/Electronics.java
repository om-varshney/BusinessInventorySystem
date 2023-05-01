package Product;

public class Electronics extends Product {
    private final String subCategory;
    public Electronics(int id, double price, String name, String subCategory) {
        super(id, price, name);
        this.subCategory = subCategory;
    }

    public String getSubCategory() {
        return subCategory;
    }
    public double getShippingCost() {
        return 0.15;
    }
    public double getTaxPercentage() {
        return 0.1;
    }
}
