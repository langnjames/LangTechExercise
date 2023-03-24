import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// This class can be used to initialize the database connection
public class DatabaseConnection {
	protected static Connection initializeDatabase()
		throws SQLException, ClassNotFoundException
	{
		
	    String url = "jdbc:mysql://langserverhost.ddns.net:3306/TechEx" + "?useSSL=false";
	    String user = "langjamesremoteuser";
	    String password = "whitesmallchick3n";
	    Connection connection = null;
		
		try {
	         Class.forName("com.mysql.cj.jdbc.Driver");// ("com.mysql.jdbc.Driver");
	      } catch (ClassNotFoundException e) {
	         System.out.println("Where is your MySQL JDBC Driver?");
	         e.printStackTrace();
	      }
			System.out.println("Driver Registered");
			connection = null;
	      try {
	         connection = DriverManager.getConnection(url, user, password);
	      } catch (SQLException e) {
	         System.out.println("Connection Failed! Check output console");
	         e.printStackTrace();
	      }
	      if (connection != null) {
	    	  System.out.println("Connected to DB");
	      } else {
	         System.out.println("Failed to make connection!");
	      }
		return connection;
	}
}
