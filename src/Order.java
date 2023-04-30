import Interfaces.Billing;
import Product.*;

import java.util.ArrayList;

public class Order {
    private final ArrayList<Integer> orders;
    private final Billing billingService;
    private final ArrayList<Product> products = new ArrayList<>();

    public Order(ArrayList<Integer> orders, Billing billingService) {
        this.orders = orders;
        this.billingService = billingService;
    }

    public void fetchProducts() {
        for (int orderID: this.orders) {
            this.products.add(GetProduct.getProduct(orderID));
        }
    }

    public double calculateBill() {
        this.fetchProducts();
        double bill = 0;
        for (Product product: this.products) {
            bill += billingService.payableAmount(product);
        }
        return bill;
    }
}
