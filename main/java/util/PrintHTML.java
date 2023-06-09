/*
 * Auth: James Lang
 * Date: 03-23-23
 */
package util;

public interface PrintHTML {
  // These two strings wrap around database calls to retrieve DB info to print to table
  public String firstHTML =
    "<html>\r\n" +
    "<head>\r\n" +
    "<style>\r\n" +
    "header {\r\n" +
    "    background-color:#444444;\r\n" +
    "    color:white;\r\n" +
    "    text-align:center;\r\n" +
    "    padding:5px;	 \r\n" +
    "}\r\n" +
    "nav {\r\n" +
    "    line-height:30px;\r\n" +
    "    background-color:#eeeeee;\r\n" +
    "    height:300px;\r\n" +
    "    width:100px;\r\n" +
    "    float:left;\r\n" +
    "    padding:5px;	      \r\n" +
    "}\r\n" +
    "section {\r\n" +
    "    width:40%;\r\n" +
    "    height:50%;\r\n" +
    "    float:left;\r\n" +
    "    padding:10px;	 	 \r\n" +
    "}\r\n" +
    "div{\r\n" +
    "	width:49%;\r\n" +
    "    padding:10px;\r\n" +
    "	float:right;\r\n" +
    "}\r\n" +
    "footer {\r\n" +
    "    background-color:#444444;\r\n" +
    "    color:white;\r\n" +
    "    clear:both;\r\n" +
    "    width:100%;\r\n" +
    "    height:100%;\r\n" +
    "    text-align:center; 	 \r\n" +
    "}\r\n" +
    "p {\r\n" +
    "	font-size: 25px;\r\n" +
    "	font-weight:bold;\r\n" +
    "}\r\n" +
    "table{\r\n" +
    "	border:1px solid;\r\n" +
    "	border-collapse:collapse;\r\n" +
    "	width:100%;\r\n" +
    "	height:100%\r\n" +
    "}\r\n" +
    "th, td {\r\n" +
    "  text-align: center;\r\n" +
    "  padding: 8px;\r\n" +
    "  font-weight:bold;\r\n" +
    "  font-size:25px;\r\n" +
    "}\r\n" +
    "\r\n" +
    "tr:nth-child(even){background-color: #f2f2f2}\r\n" +
    "\r\n" +
    "th {\r\n" +
    "  background-color: #444444;\r\n" +
    "  color: white;\r\n" +
    "}\r\n" +
    "</style>\r\n" +
    "</head>\r\n" +
    "\r\n" +
    "<body>\r\n" +
    "<header>\r\n" +
    "<h1> To - Do List </h1>\r\n" +
    "</header>\r\n" +
    "\r\n" +
    "<section>\r\n" +
    "<table>\r\n" +
    "<tr><th>Task</th><th>Description</th><tr>";
  public String secondHTML =
    "</table>\r\n" +
    "</section>\r\n" +
    "\r\n" +
    "<div>\r\n" +
    "	<form action=\"DatabaseInsert\" method=\"POST\">\r\n" +
    "		<h1>Insert</h1>\r\n" +
    "		Task: <input type=\"text\" name=\"task\"> <br />\r\n" +
    "		Description: <input type=\"text\" name=\"description\"> <br />\r\n" +
    "		\r\n" +
    "		<input type=\"submit\" value=\"Insert\" />\r\n" +
    "	</form>\r\n" +
    "	<form action=\"DatabaseSearch\" method=\"POST\">\r\n" +
    "			<h1>Search</h1>\r\n" +
    "		 <input type=\"text\" name=\"keyword\"> <br />\r\n" +
    "		\r\n" +
    "		<input type=\"submit\" value=\"Search\" />\r\n" +
    "	</form>\r\n" +
    "	<form action=\"DatabaseDelete\" method=\"POST\">\r\n" +
    "		<h1>Delete</h1>\r\n" +
    "		 <input type=\"text\" name=\"task\"> <br />\r\n" +
    "		\r\n" +
    "		<input type=\"submit\" value=\"Delete\" />\r\n" +
    "	</form>\r\n" +
    "\r\n" +
    "</div>\r\n" +
    "\r\n" +
    "<footer>\r\n" +
    "\r\n" +
    "</footer>\r\n" +
    "</body>\r\n" +
    "</html>";
}
