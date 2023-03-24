/*
 * Auth: James Lang
 * Date: 03-23-23
 */

package util;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletResponse;

public class UtilPrint {

  public static void createHTMLOut(HttpServletResponse response, ResultSet rs) {
    try {
      // Initializes Printwriter in order to be able to print html code using response
      PrintWriter out = response.getWriter();
      response.setContentType("text/html");
      
      // Uses util.PrintHTML to help w/ printing out HTML design for page
      out.println(util.PrintHTML.firstHTML);

      // This loop iterates through a result set in order to parse and print each task and description being read from a mysql statement result.
      while (rs.next()) {
        String task = rs.getString("TASKS");
        String description = rs.getString("DESCRIPTIONS");
        out.println(
          "<tr><td>" + task + "</td><td>" + description + "</td></tr>"
        );
      }
      
      // Uses util.PrintHTML to help w/ printing out HTML design for page
      out.println(util.PrintHTML.secondHTML);
      
      // Catches exceptions given by MySQL or from ResultSet
    } catch (SQLException | IOException e) {
      e.printStackTrace();
    }
  }
}
   
