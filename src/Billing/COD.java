package Billing;

import Interfaces.Billing;
import Product.Product;

public class COD implements Billing {
    private double mrp;
    public COD(double mrp) {
        this.mrp = mrp;
    }
    @Override
    public double payableAmount(Product product) {
        double price = product.getProductPrice();
        return price + price * product.getTaxPercentage() + price * product.getShippingCost();
    }
}
