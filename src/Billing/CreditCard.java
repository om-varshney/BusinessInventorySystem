package Billing;

import Exceptions.InvalidCreditCardNumberException;
import Helpers.Validation.Validator;
import Interfaces.Billing;
import Product.Product;

import java.util.Objects;

public record CreditCard(String cardNumber) implements Billing {
    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
        try {
            Validator.validateCreditCardNumber(cardNumber);
        } catch (InvalidCreditCardNumberException invCred) {
            System.out.println(invCred.getMessage());
        }
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

}
