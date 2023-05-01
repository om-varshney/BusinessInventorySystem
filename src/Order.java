import Helpers.GetProduct;
import Interfaces.Billing;
import Product.*;

import java.util.ArrayList;
import java.sql.*;

public class Order {
    private final ArrayList<Integer> orders;
    private final Billing billingService;
    private final int userID;
    private final ArrayList<Product> products = new ArrayList<>();

    public Order(ArrayList<Integer> orders, Billing billingService, int userID) {
        this.orders = orders;
        this.billingService = billingService;
        this.userID = userID;
    }

    public void fetchProducts() {
        for (int orderID: this.orders) {
            this.products.add(GetProduct.getProduct(orderID));
        }
    }

    public void placeOrder(int productID) {
        Connection connection;
        Statement statement;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/businessinventorysystem",
                    "root",
                    "om2516"
            );
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM orders");
            rs.next();
            int count = rs.getInt(1);
            PreparedStatement pstmt = connection.prepareStatement("""
                    INSERT INTO orders (orderID, userID, productID, quantity, paymentType, creditCardNo, accountNo, IFSC)
                    VALUES (?, ?, ?, 1, ?, ?, ?, ?);"""
            );
            pstmt.setInt(1, count + 1);
            pstmt.setInt(2, this.userID);
            pstmt.setInt(3, productID);
            pstmt.setString(4, this.billingService.getName());
            pstmt.setString(5, this.billingService.cardNumber());
            pstmt.setString(6, this.billingService.accountNumber());
            pstmt.setString(7, this.billingService.IFSCCode());
            pstmt.execute();
            // Update the products table once order is placed.
            PreparedStatement updateQuantity = connection.prepareStatement("""
                    UPDATE products
                    SET quantity = quantity - 1
                    WHERE productID = ?;"""
            );
            updateQuantity.setInt(1, productID);
            updateQuantity.execute();
        } catch (ClassNotFoundException | SQLException cnf) {
            System.out.println(cnf.getMessage());
        }
    }

    public double calculateBill() {
        this.fetchProducts();
        double bill = 0;
        for (Product product: this.products) {
            bill += billingService.payableAmount(product);
            this.placeOrder(product.getProductID());
        }
        return bill;
    }
}
