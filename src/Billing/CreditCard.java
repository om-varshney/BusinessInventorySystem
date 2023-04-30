package Billing;

import Interfaces.Billing;
import Product.Product;

public record CreditCard(String cardNumber) implements Billing {
    @Override
    public double payableAmount(Product product) {
        // Discount is applicable for credit cards.
        double price = product.getProductPrice();
        double discount = 0.23;
        return price + price * product.getTaxPercentage() + price * product.getShippingCost() - discount * price;
    }

    @Override
    public String getName() {
        return "CC";
    }

    @Override
    public String accountNumber() {
        return null;
    }

    @Override
    public String IFSCCode() {
        return null;
    }
}
