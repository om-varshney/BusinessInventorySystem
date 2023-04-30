package Interfaces;

import Product.Product;

public interface Billing {
    double payableAmount(Product product);
    String getName();
    String cardNumber();
    String accountNumber();
    String IFSCCode();
}
