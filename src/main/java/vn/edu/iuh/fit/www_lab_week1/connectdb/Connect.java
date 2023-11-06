package vn.edu.iuh.fit.www_lab_week1.connectdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    private static Connect instance;
    private final Connection connection;

    private Connect() {
        try {
            DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/" +
                    "mydb?user=root&password=08062002");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connect getInstance() {
        if(instance == null)
            instance = new Connect();
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public static void main(String[] args) {
        Connection conn = Connect.getInstance().getConnection();
        System.out.println(conn);
    }
}
