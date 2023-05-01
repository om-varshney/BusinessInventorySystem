import Exceptions.UnauthenticatedUser;
import java.sql.*;

public class User {
    private final String userName;
    private final String password;
    private final String phoneNumber;
    private final String emailId;
    private final int distanceFromWarehouse;

    public static int login(String userName, String password) {
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/businessinventorysystem",
                    "root",
                    "om2516"
            );
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            String username, passwd;
            int userID;
            while (resultSet.next()) {
                username = resultSet.getString("username").trim();
                passwd = resultSet.getString("password");
                userID = resultSet.getInt("userID");
                if (username.equals(userName) && passwd.equals(password)) {
                    resultSet.close();
                    statement.close();
                    connection.close();
                    return userID;
                }
            }
        } catch (ClassNotFoundException | SQLException cnf) {
            System.out.println(cnf.getMessage());
        }
        System.out.println("Login Unsuccessful!");
        return 0;
    }

    public int signup() {
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
            ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM users");
            rs.next();
            int count = rs.getInt(1);
            PreparedStatement pstmt = connection.prepareStatement("""
                    INSERT INTO users (userID, username, password, phoneno, emailid, distance)
                    VALUES (?, ?, ?, ?, ?, ?);"""
            );
            pstmt.setInt(1, count + 1);
            pstmt.setString(2, this.userName);
            pstmt.setString(3, this.password);
            pstmt.setString(4, this.phoneNumber);
            pstmt.setString(5, this.emailId);
            pstmt.setInt(6, this.distanceFromWarehouse);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                return count + 1;
            }
        } catch (ClassNotFoundException | SQLException cnf) {
            System.out.println(cnf.getMessage());
        }
        System.out.println("Signup Unsuccessful!");
        return 0;
    }
    public User(String userName, String password, String phoneNumber, String emailId, int distanceFromWarehouse) {
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.distanceFromWarehouse = distanceFromWarehouse;
    }
}
