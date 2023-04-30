package Admin;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestWordMin;

import java.sql.*;
import java.util.Objects;

public class AdminView {
    public void viewOrders() {
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/businessinventorysystem",
                    "root",
                    "om2516"
            );
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM orders");
            AsciiTable at = new AsciiTable();
            at.setPadding(5);
            at.addRule();
            at.addRow("orderID", "productID", "userID", "quantity", "payment mode", "CC No.", "Acc No.", "IFSC");
            at.addRule();
            while (rs.next()) {
                int oid = rs.getInt("orderID");
                int pid = rs.getInt("productID");
                int uid = rs.getInt("userID");
                int qty = rs.getInt("quantity");
                String payment = Objects.requireNonNullElse(rs.getString("paymentType"), "NA");
                String cc = Objects.requireNonNullElse(rs.getString("creditCardNo"), "NA");
                String acn = Objects.requireNonNullElse(rs.getString("accountNo"), "NA");
                String ifsc = Objects.requireNonNullElse(rs.getString("IFSC"), "NA");
                at.addRow(oid, pid, uid, qty, payment, cc, acn, ifsc);
                at.addRule();
            }
            at.getRenderer().setCWC(new CWC_LongestWordMin(15));
            System.out.println(at.render());
        } catch(ClassNotFoundException | SQLException cnf) {
            System.out.println(cnf.getMessage());
        }
    }

    public void viewCriticalProducts() {
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/businessinventorysystem",
                    "root",
                    "om2516"
            );
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM products WHERE quantity < 10;");
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
        } catch (ClassNotFoundException | SQLException cnf) {
            System.out.println(cnf.getMessage());
        }
    }

}
