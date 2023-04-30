package Billing;

import Interfaces.Billing;
import Product.Product;

public class COD implements Billing {
    public COD() {}
    @Override
    public double payableAmount(Product product) {
        double price = product.getProductPrice();
        return price + price * product.getTaxPercentage() + price * product.getShippingCost();
    }

    @Override
    public String getName() {
        return "COD";
    }

    @Override
    public String cardNumber() {
        return null;
    }

    @Override
    public String accountNumber() {
        return null;
    }

    @Override
    public String IFSCCode() {
        return null;
    }
}
