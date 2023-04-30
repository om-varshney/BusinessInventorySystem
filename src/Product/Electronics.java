package Product;

public class Electronics extends Product {
    private String category;
    Electronics(int id, double price, int quantity, String category) {
        super(id, price, quantity);
        this.category = category;
    }
}
