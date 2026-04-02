// DBConnectDemo.java
// Demonstrates a basic JDBC connection and simple query to test database access.
// Requires mysql-connector-j JAR on the classpath.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DBConnectDemo {
    public static void main(String[] args) {

        // Database connection details
        String host = "mariadb-83979-0.cloudclusters.net";
        int port = 16652;
        String db   = "sakila";
        String user = "csc222";
        String pass = "csc222@3600";

        // Load the MySQL driver (for mysql-connector-j)
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found on classpath.");
            e.printStackTrace();
            return;
        }

        // Build connection URL
        String jdbcUrl = String.format("jdbc:mysql://%s:%d/%s", host, port, db);

        // Setup connection properties
        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", pass);
        // Uncomment if host requires SSL:
        // props.setProperty("sslMode", "REQUIRED");

        System.out.println("Attempting to connect to database...");

        // Attempt connection and run test query
        try (Connection conn = DriverManager.getConnection(jdbcUrl, props)) {

            if (conn != null && !conn.isClosed()) {
                System.out.println("Connection successful!");
            }

            // --- Example query: display first 5 actors ---
            System.out.println("\nRunning sample query: SELECT first_name, last_name FROM actor LIMIT 5;");
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT actor_id, first_name, last_name FROM actor LIMIT 5;")) {

                System.out.println("Results:");
                System.out.println("-------------------------");
                while (rs.next()) {
                    int aID = rs.getInt("actor_id");
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    System.out.println(aID + " " + firstName + " " + lastName);
                }
                System.out.println("-------------------------");
                System.out.println("Query completed successfully.");
            }

            // Connection auto-closes because of try-with-resources
            System.out.println("Closing connection...");

        } catch (Exception e) {
            System.out.println("Database connection failed:");
            e.printStackTrace();
        }
    }
}