/**
 */
package util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @since JavaSE-1.8
 */
public class UtilPrint {
    
   
   public static void createHTMLOut(HttpServletRequest request, HttpServletResponse response, Connection connection, ResultSet rs) {
		try {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");  
	         out.println(util.PrintHTML.firstHTML); 
	          
	         while (rs.next()) 
	         {  
	             String task = rs.getString("TASKS");  
	             String description = rs.getString("DESCRIPTIONS");     
	             out.println("<tr><td>" + task + "</td><td>" + description + "</td></tr>");   
	         }  
	         out.println(util.PrintHTML.secondHTML);  
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
	}
   }
   
