package Product;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestWordMin;

import java.sql.*;
import java.util.Objects;

public abstract class Product {
    private final int productID;
    private final double productPrice;
    private final String productName;

    Product(int id, double price, String productName) {
        this.productID = id;
        this.productPrice = price;
        this.productName = productName;
    }
    public int getProductID() {
        return productID;
    }
    public double getProductPrice() {
        return productPrice;
    }
    public abstract double getShippingCost();
    public abstract double getTaxPercentage();
    public String getProductName() {
        return productName;
    }
}
