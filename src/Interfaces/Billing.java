package Interfaces;

import Product.Product;

public interface Billing {
    double calculateShippingCost();
    double calculateTaxes();
    double payableAmount(Product product);
}
