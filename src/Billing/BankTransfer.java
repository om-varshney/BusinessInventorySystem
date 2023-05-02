package Billing;

import Exceptions.InvalidAccountNumberException;
import Exceptions.InvalidIFSCCodeException;
import Helpers.Validation.Validator;
import Interfaces.Billing;
import Product.Product;

import java.util.Objects;

public final class BankTransfer implements Billing {
    private final String accountNumber;
    private final String IFSCCode;

    public BankTransfer(String accountNumber, String IFSCCode) throws InvalidIFSCCodeException, InvalidAccountNumberException {
        this.accountNumber = accountNumber;
        this.IFSCCode = IFSCCode;
        Validator.validateAccountNumber(accountNumber);
        Validator.validateIFSCCode(IFSCCode);
    }

    @Override
    public double payableAmount(Product product) {
        // No delivery charges for Bank Transfer.
        double price = product.getProductPrice();
        return price + price * product.getTaxPercentage() + price * product.getShippingCost();
    }

    @Override
    public String getName() {
        return "Bank Transfer";
    }

    @Override
    public String cardNumber() {
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (BankTransfer) obj;
        return Objects.equals(this.accountNumber, that.accountNumber) &&
                Objects.equals(this.IFSCCode, that.IFSCCode);
    }

    @Override
    public String toString() {
        return "BankTransfer[" +
                "accountNumber=" + accountNumber + ", " +
                "IFSCCode=" + IFSCCode + ']';
    }

    @Override
    public String accountNumber() {
        return accountNumber;
    }

    @Override
    public String IFSCCode() {
        return IFSCCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, IFSCCode);
    }


}
