package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcSingleton {
    private static JdbcSingleton instance;
    private Connection connection;

    private static final String SERVER_NAME = "DESKTOP-P0KN5L0\\MSSQLSERVER01";
    private static final String PORT = "1433";
    private static final String DATABASE_NAME = "Cook";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "17012004";

    private JdbcSingleton() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlserver://" + SERVER_NAME + ":" + PORT
                    + ";database=" + DATABASE_NAME
                    + ";user=" + USERNAME
                    + ";password=" + PASSWORD
                    + ";encrypt=true;trustServerCertificate=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static JdbcSingleton getInstance() {
        if (instance == null) {
            instance = new JdbcSingleton();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public synchronized void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
