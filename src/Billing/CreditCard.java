package Billing;

import Interfaces.Billing;
import Product.Product;

public class CreditCard implements Billing {
    private long cardNumber;
    public CreditCard(long cardNumber) {
        this.cardNumber = cardNumber;
    }
    @Override
    public double calculateShippingCost() {
        return 0;
    }

    @Override
    public double calculateTaxes() {
        return 0;
    }

    @Override
    public double payableAmount(Product product) {
        return 0;
    }
}
