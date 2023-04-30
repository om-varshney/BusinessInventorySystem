package Billing;

import Interfaces.Billing;
import Product.Product;

public class CreditCard implements Billing {
    private long cardNumber;

    public CreditCard(long cardNumber) {
        this.cardNumber = cardNumber;
    }
    @Override
    public double payableAmount(Product product) {
        // Discount is applicable for credit cards.
        double price = product.getProductPrice();
        double discount = 0.23;
        return price + price * product.getTaxPercentage() + price * product.getShippingCost() - discount * price;
    }
}
