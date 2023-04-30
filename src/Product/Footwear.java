package Product;

public class Footwear extends Product {
    private boolean gender;
    private int size;
    private String brand;
    Footwear(int id, double price, int quantity, boolean gender, int size, String brand) {
        super(id, price, quantity);
        this.gender = gender;
        this.size = size;
        this.brand = brand;
    }
}
