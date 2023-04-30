package Product;

import org.apache.commons.lang3.ObjectUtils;

import java.sql.*;

public class GetProduct {
    @org.jetbrains.annotations.Nullable
    public static Product getProduct(int productID) {
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/businessinventorysystem",
                    "root",
                    "om2516"
            );
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM products WHERE productID = ?");
            pstmt.setInt(1, productID);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            String category = rs.getString("category");
            switch (category) {
                case "Electronics" -> {
                    return new Electronics(
                            productID,
                            rs.getDouble("price"),
                            rs.getString("subcategory")
                    );
                }
                case "Cosmetics" -> {
                    return new Cosmetics(
                            productID,
                            rs.getDouble("price"),
                            rs.getString("brand")
                    );
                }
                case "Clothes" -> {
                    return new Clothing(
                            productID,
                            rs.getDouble("price"),
                            rs.getString("gender"),
                            rs.getString("size")
                    );
                }
                case "Footwear" -> {
                    return new Footwear(
                            productID,
                            rs.getDouble("price"),
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
}
