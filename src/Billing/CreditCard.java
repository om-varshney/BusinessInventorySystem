package Billing;

import Exceptions.InvalidCreditCardNumberException;
import Helpers.Validation.Validator;
import Interfaces.Billing;
import Product.Product;

import java.util.Objects;

public final class CreditCard implements Billing {
    private final String cardNumber;

    public CreditCard(String cardNumber) throws InvalidCreditCardNumberException {
        this.cardNumber = cardNumber;
        Validator.validateCreditCardNumber(cardNumber);
    }

    @Override
    public double payableAmount(Product product) {
        double price = product.getProductPrice();
        return price + price * product.getTaxPercentage() + price * product.getShippingCost();
    }

    @Override
    public String getName() {
        return "CC";
    }

    @Override
    public String accountNumber() {
        return null;
    }

    @Override
    public String IFSCCode() {
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (CreditCard) obj;
        return Objects.equals(this.cardNumber, that.cardNumber);
    }

    @Override
    public String toString() {
        return "CreditCard[" +
                "cardNumber=" + cardNumber + ']';
    }

    @Override
    public String cardNumber() {
        return cardNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber);
    }


}
