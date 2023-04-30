package Billing;

import Interfaces.Billing;
import Product.Product;

public class BankTransfer implements Billing {
    private final String accountNumber;
    private final String IFSCCode;
    public BankTransfer(String accountNumber, String IFSCCode) {
        this.accountNumber = accountNumber;
        this.IFSCCode = IFSCCode;
    }

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
    public String getCardNumber() {
        return null;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getIFSCCode() {
        return IFSCCode;
    }
}
