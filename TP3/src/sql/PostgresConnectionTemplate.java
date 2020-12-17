package sql;//package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnectionTemplate {

    // Use this template to create a "PostgresConnection.java"

    private final static String server = "localhost";
    private final static String baseName = "postgres";
    private final static String user = "login";
    private final static String password = "password";

    private static Connection connection;

    public static Connection getInstance() {

        if (connection == null) {
            String url = "jdbc:postgresql://" + server + "/" + baseName;
            try {
                connection = DriverManager.getConnection(url, user, password );
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return connection;
    }
}