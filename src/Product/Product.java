package Product;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestWordMin;

import java.sql.*;
import java.util.Objects;

public abstract class Product {
    private final int productID;
    private final double productPrice;

    Product(int id, double price) {
        this.productID = id;
        this.productPrice = price;
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
            at.addRow("productID", "category", "subcategory", "gender", "brand", "name", "size", "price", "quantity");
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
                int quantity = rs.getInt("quantity");
                at.addRow(pid, category, subCategory, gender, brand, name, size, price, quantity);
                at.addRule();
            }
            at.getRenderer().setCWC(new CWC_LongestWordMin(15));
            System.out.println(at.render());
            System.out.println(at.render());
        } catch (ClassNotFoundException | SQLException cnf) {
            System.out.println(cnf.getMessage());
        }
    }
}
