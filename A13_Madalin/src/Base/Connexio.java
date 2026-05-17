package Base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * connects to the database
 * @author radum
 */
public class Connexio {

    public static String url = "jdbc:mysql://localhost:3306/a13m";
    public static String user = "Madalin";
    public static String password = "MadalinioanDB12";
    public static Connection conn = null;

    public Connection connect() {

        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Connection not established");
            e.printStackTrace();
        }

        return conn;
    }
}
