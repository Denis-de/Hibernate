package jm.task.core.jdbc.util;
import java.sql.*;

public class Util {
    String URL = "jdbc:mysql://localhost:3306/mytestjava";
    String USERNAME = "root";
    String PASSWORD = "genius201";

    public Connection getConnection() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = null;
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("Соединение с БД установлено");
            }

            if (connection.isClosed()) {
                System.out.println("Соединение с БД закрыто");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}