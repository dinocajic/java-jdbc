import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DBConnection {

    private static final String USERNAME = "android";
    private static final String PASSWORD = "password";
    private static final String CONN     = "jdbc:mysql://localhost:8889/android_wheels";

    static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONN, USERNAME, PASSWORD);
    }
}
