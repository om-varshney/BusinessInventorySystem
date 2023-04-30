package Billing;

import Interfaces.Billing;
import Product.Product;

public class BankTransfer implements Billing {
    private long accountNumber;
    private String IFSCCode;

    public BankTransfer(long accountNumber, String IFSCCode) {
        this.accountNumber = accountNumber;
        this.IFSCCode = IFSCCode;
    }

    @Override
    public double payableAmount(Product product) {
        // No delivery charges for Bank Transfer.
        double price = product.getProductPrice();
        return price + price * product.getTaxPercentage();
    }
}
