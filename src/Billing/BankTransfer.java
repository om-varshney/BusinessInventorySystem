package Billing;

import Interfaces.Billing;
import Product.Product;

public record BankTransfer(String accountNumber, String IFSCCode) implements Billing {

    @Override
    public double payableAmount(Product product) {
        // No delivery charges for Bank Transfer.
        double price = product.getProductPrice();
        return price + price * product.getTaxPercentage();
    }

    @Override
    public String getName() {
        return "Bank Transfer";
    }

    @Override
    public String cardNumber() {
        return null;
    }
}
