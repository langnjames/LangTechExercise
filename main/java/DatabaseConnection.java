/*
 * Auth: James Lang
 * Date: 03-23-23
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// This class can be used to initialize the database connection
public class DatabaseConnection {

  protected static Connection initializeDatabase()
    throws SQLException, ClassNotFoundException {
    // Set params used to initialize DB connection
    String url =
      "jdbc:mysql://langserverhost.ddns.net:3306/TechEx" + "?useSSL=false";
    String user = "langjamesremoteuser";
    String password = "whitesmallchick3n";

    // Create an empty connection to be used later
    Connection connection = null;

    //Tries to find driver for java database connector
    try {
      Class.forName("com.mysql.cj.jdbc.Driver"); // ("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      System.out.println("Where is your MySQL JDBC Driver?");
      e.printStackTrace();
    }

    // Shows user we have found the driver
    System.out.println("Driver Registered");
    connection = null;

    // Tries to setup connection, sets connection var if successful
    try {
      connection = DriverManager.getConnection(url, user, password);
    } catch (SQLException e) {
      System.out.println("Connection Failed! Check output console");
      e.printStackTrace();
    }
    // Makes sure connection is not still empty, if not then we have connected.
    if (connection != null) {
      System.out.println("Connected to DB");
    } else {
      System.out.println("Failed to make connection!");
    }
    return connection;
  }
}
