package Helpers;

import Product.Product;
import Product.Clothing;
import Product.Cosmetics;
import Product.Electronics;
import Product.Footwear;
import Exceptions.ProductUnavailableException;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestWordMin;

import java.sql.*;
import java.util.Objects;

public class GetProduct {
    @org.jetbrains.annotations.Nullable
    public static Product getProduct(int productID) throws ProductUnavailableException {
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/businessinventorysystem",
                    "root",
                    "om2516"
            );
            Statement statement = connection.createStatement();
            ResultSet cs = statement.executeQuery("SELECT COUNT(*) FROM orders");
            cs.next();
            int count = cs.getInt(1);
            if (productID < 0 | productID > count) {
                throw new ProductUnavailableException("Invalid Product ID");
            }
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM products WHERE productID = ?");
            pstmt.setInt(1, productID);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            String category = rs.getString("category");
            int quantity = rs.getInt("quantity");
            if (quantity == 0) {
                throw new ProductUnavailableException("This product is unavailable");
            }
            switch (category) {
                case "Electronics" -> {
                    return new Electronics(
                            productID,
                            rs.getDouble("price"),
                            rs.getString("name"),
                            rs.getString("subcategory")
                    );
                }
                case "Cosmetics" -> {
                    return new Cosmetics(
                            productID,
                            rs.getDouble("price"),
                            rs.getString("name"),
                            rs.getString("brand")
                    );
                }
                case "Clothes" -> {
                    return new Clothing(
                            productID,
                            rs.getDouble("price"),
                            rs.getString("name"),
                            rs.getString("gender"),
                            rs.getString("size")
                    );
                }
                case "Footwear" -> {
                    return new Footwear(
                            productID,
                            rs.getDouble("price"),
                            rs.getString("name"),
                            rs.getString("gender"),
                            rs.getString("size"),
                            rs.getString("brand")
                    );
                }
            }
        } catch (ClassNotFoundException | SQLException cnf) {
            System.out.println(cnf.getMessage());
        }
        return null;
    }

    public static void displayAllProducts() {
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/businessinventorysystem",
                    "root",
                    "om2516"
            );
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM products");
            AsciiTable at = new AsciiTable();
            at.setPadding(5);
            at.addRule();
            at.addRow("productID", "category", "subcategory", "gender", "brand", "name", "size", "price");
            at.addRule();
            while (rs.next()) {
                int pid = rs.getInt("productID");
                String category = Objects.requireNonNullElse(rs.getString("category"), "NA");
                String subCategory = Objects.requireNonNullElse(rs.getString("subcategory"), "NA");
                String gender = Objects.requireNonNullElse(rs.getString("gender"), "NA");
                String brand = Objects.requireNonNullElse(rs.getString("brand"), "NA");
                String name = Objects.requireNonNullElse(rs.getString("name"), "NA");
                String size = Objects.requireNonNullElse(rs.getString("size"), "NA");
                float price = rs.getFloat("price");
                at.addRow(pid, category, subCategory, gender, brand, name, size, price);
                at.addRule();
            }
            at.getRenderer().setCWC(new CWC_LongestWordMin(15));
            System.out.println(at.render());
        } catch (ClassNotFoundException | SQLException cnf) {
            System.out.println(cnf.getMessage());
        }
    }
}
