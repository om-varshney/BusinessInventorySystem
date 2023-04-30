package Product;

public class Electronics extends Product {
    private final String subCategory;
    Electronics(int id, double price, String subCategory) {
        super(id, price);
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
