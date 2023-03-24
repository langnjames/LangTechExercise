/*
 * Auth: James Lang
 * Date: 03-23-23
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.UtilPrint;

/**
 * Servlet implementation class DatabaseDelete
 */
@WebServlet("/DatabaseDelete")
public class DatabaseDelete extends HttpServlet {

  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public DatabaseDelete() {
    super();
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(
    HttpServletRequest request,
    HttpServletResponse response
  ) throws ServletException, IOException {
    try {
      //Sets up connection from DatabaseConnection class and makes connection
      Connection connection = DatabaseConnection.initializeDatabase();

      // Gets task from HTML form
      String task = request.getParameter("task");

      // If the input is too long, truncate it
      if (task.length() > 25) {
        task = task.substring(0, 24);
      }

      // Initializes a query for prepare statement to be later exectued
      String sql = "delete from Tasks where TASKS='" + task + "'";

      // Prepares the statement object that inserts the query into it
      PreparedStatement prepStmt = connection.prepareStatement(sql);

      // Executes delete statement that we would like to use on DB
      prepStmt.execute();

      // Creates a statement object that can be sent to MySQL database
      Statement stmt = connection.createStatement();

      // Exectues statement and gets back the results in a ResultSet
      ResultSet rs = stmt.executeQuery("select * from Tasks");

      // Uses database helper method in order to print out HTML code for the page
      UtilPrint.createHTMLOut(response, rs);

      //Ensure to close the statements
      prepStmt.close();
      stmt.close();

      // Ensure to close the connection
      connection.close();
      // Catches any exceptions
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(
    HttpServletRequest request,
    HttpServletResponse response
  ) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }
}
