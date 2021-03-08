package java112.project2;

import java.io.*;
import java.util.*;
import java112.utilities.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  This is part of a lab and is the first servlet for the course.
 *
 *@author    eknapp
 */
@WebServlet(
    name = "project2PropertiesServlet",
    urlPatterns = { "/project2Properties" }
)
public class Project2PropertiesServlet extends HttpServlet implements PropertiesLoader {

    /**
     * Declare instance variables
     */
    private Properties properties;

    /**
     * Loads the properties file upon loading the web page
     * @throws ServletException [description]
     */
    public void init() throws ServletException {
        properties = loadProperties("/project2.properties");
    }

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        // set the response type before sending data
        PrintWriter  out  = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD><TITLE>Project 2 Properties Servlet Output</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1>Frank Raisbeck Properties Servlet</h1>");
        out.print("<a href='/java112'>Back to the homepage</a>");
        out.print("</br></br>");
        out.print("<table style='width:75%'>");
        out.print(tableHeaders());
        out.print(tableData());
        out.print("</table>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }

    /**
     * cycles through and prints out the table headers from the properties file
     */
    public String tableHeaders() {
        String output = ("<tr>");
        Set<String> propertyHeaders = properties.stringPropertyNames();
        for (String key : propertyHeaders) {
            output += ("<th>" + key + "</th>");
        }
        output += ("</tr>");
        return output;
    }

    /**
     * cycles through and prints out the table data from the properties file
     */
    public String tableData() {
        String output = ("<tr>");
        Set<String> propertyHeaders = properties.stringPropertyNames();
        for (String key : propertyHeaders) {
            output += ("<td>" + properties.getProperty(key) + "</td>");
        }
        output += ("</tr>");
        return output;
    }



}
