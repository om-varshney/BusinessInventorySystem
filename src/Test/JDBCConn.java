package Test;

import java.sql.*;

public class JDBCConn {
    public static void main(String[] args) {
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/scirev",
                    "root", "om2516"
            );
            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery("select * from api_goal");
            String name, code;
            while (resultSet.next()) {
                name = resultSet.getString("name").trim();
                code = resultSet.getString("code");
                System.out.println("Code : " + code + " Name : " + name);
            }
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (ClassNotFoundException | SQLException cnf) {
            System.out.println(cnf.getMessage());
        }
    }
}
