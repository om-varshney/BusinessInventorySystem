package Billing;

import Interfaces.Billing;
import Product.Product;

public class CreditCard implements Billing {
    private final String cardNumber;

    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }
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

    public String getCardNumber() {
        return cardNumber;
    }

    @Override
    public String getAccountNumber() {
        return null;
    }

    @Override
    public String getIFSCCode() {
        return null;
    }
}
