package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
    private String jdbcURL = "jdbc:mysql://localhost:3306/sinhvien?useSSL=false";;
    private final String USER = "root";
    private final String PASS = "123456";

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(jdbcURL, USER, PASS);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        context.DBContext dbContext = new context.DBContext();
        System.out.println(dbContext.getConnection());
    }
}

