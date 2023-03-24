import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.UtilDB;

/**
 * Servlet implementation class DatabaseSearch
 */
@WebServlet("/DatabaseSearch")
public class DatabaseSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DatabaseSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//Sets up connection from DatabaseConnection class and makes connection
			Connection connection = DatabaseConnection.initializeDatabase();
			// Gets keyword from HTML form
			String keyword = request.getParameter("keyword");
			if(keyword.length() > 25) {
				keyword = keyword.substring(0,24);
			}
			
			
			// Creates a statement that can be sent to MySQL database
			Statement stmt = connection.createStatement();
			
			//Creates a ResultSet object that takes in the results from executing the statement provided
			
			ResultSet rs = null;
			if(keyword != "")
			{
				 rs = stmt.executeQuery("select * from Tasks where TASKS='"+ keyword +"'");
			}
			else {
				 rs = stmt.executeQuery("select * from Tasks");
			}
	        
			
	        // Uses database helper method in order to print out HTML code for the page
			UtilDB.createHTMLOut(request, response, connection, rs);
			
			//Ensure to close the statement
			stmt.close();
			
			// Ensure to close the connection
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
