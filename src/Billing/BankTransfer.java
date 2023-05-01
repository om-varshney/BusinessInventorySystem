package Billing;

import Exceptions.InvalidAccountNumberException;
import Exceptions.InvalidIFSCCodeException;
import Helpers.Validation.Validator;
import Interfaces.Billing;
import Product.Product;

import java.util.Objects;

public record BankTransfer(String accountNumber, String IFSCCode) implements Billing {
    public BankTransfer(String accountNumber, String IFSCCode) {
        this.accountNumber = accountNumber;
        this.IFSCCode = IFSCCode;
        try {
            Validator.validateAccountNumber(accountNumber);
            Validator.validateIFSCCode(IFSCCode);
        } catch (InvalidAccountNumberException | InvalidIFSCCodeException invCred) {
            System.out.println(invCred.getMessage());
        }
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

}
