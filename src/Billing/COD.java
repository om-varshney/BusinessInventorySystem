package Billing;

import Interfaces.Billing;
import Product.Product;

public class COD implements Billing {
    private double mrp;
    public COD(double mrp) {
        this.mrp = mrp;
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
