package sql;//package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnection {

    private static String serveur = "localhost";
    private static String baseName = "postgres";
    private static String user = "leo";
    private static String password = "leo";

    private static Connection connection;

    public static Connection getInstance() {

        if (connection == null) {
            String url = "jdbc:postgresql://" + serveur + "/" + baseName;
            try {
                connection = DriverManager.getConnection(url, user, password );
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return connection;
    }
}