package Product;

public abstract class Product {
    private int productID;
    private double productPrice;
    private int productQuantity;

    Product(int id, double price, int quantity) {
        this.productID = id;
        this.productPrice = price;
        this.productQuantity = quantity;
    }
}
