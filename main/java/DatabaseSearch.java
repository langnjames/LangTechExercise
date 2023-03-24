/*
 * Auth: James Lang
 * Date: 03-23-23
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.UtilPrint;

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

      // Gets keyword from HTML form
      String keyword = request.getParameter("keyword");
      // If the input is too long, truncate it
      if (keyword.length() > 25) {
        keyword = keyword.substring(0, 24);
      }

      // Creates a statement object that can be sent to MySQL database
      Statement stmt = connection.createStatement();

      //Creates a ResultSet object to be used later
      ResultSet rs = null;

      // If there is input, execute query statement to find that task, else find all tasks
      if (keyword != "") {
        rs =
          stmt.executeQuery(
            "select * from Tasks where TASKS='" + keyword + "'"
          );
      } else {
        rs = stmt.executeQuery("select * from Tasks");
      }

      // Uses database helper method in order to print out HTML code for the page
      UtilPrint.createHTMLOut(response, rs);

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
  protected void doPost(
    HttpServletRequest request,
    HttpServletResponse response
  ) throws ServletException, IOException {
    doGet(request, response);
  }
}
