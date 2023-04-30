package Interfaces;

public interface Billing {
    double calculateShippingCost();
    double calculateTaxes();
    double payableAmount();
}
