package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java112.utilities.*;
import java112.employee.*;

/**
 *  This will perform searches for employees in the employee database
 *
 *@author    fraisbeck
 */
 @WebServlet(
     name = "employeeSearchResults",
     urlPatterns = { "/employeeSearchResults" }
 )
 public class EmployeeSearchResultsServlet extends HttpServlet implements PropertiesLoader {

     /**
      *  Handles HTTP GET requests.
      *
      *@param  request               the HttpRequest
      *@param  response              the HttpResponse
      *@exception  ServletException  if there is a general
      *                              servlet exception
      *@exception  IOException       if there is a general
      *                              I/O exception
      */
     public void doGet(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {

        // Create a session Variable
        HttpSession session = request.getSession();
        // Create a variable that references the ServletContext
        ServletContext servletContext = request.getServletContext();
        // Gets the EmployeeDirectory from the servletContext
        EmployeeDirectory empDirectory = (EmployeeDirectory) servletContext.getAttribute("employeeDirectory");

        // Get the search Type from the html form
        String searchType = (String) request.getParameter("searchType");

        // Get the search Term from the html form
        String searchTerm = (String) request.getParameter("searchTerm");

        // Searches the employee database using the Type and Term from above
        Search employeeSearch = empDirectory.searchEmployeeDatabase(searchTerm, searchType);

        // Place the search object from above into the session
        session.setAttribute("EmployeeSearchResults", employeeSearch);

        //Create the url
        String url = "/jsp/employeeSearchResults.jsp";

        //Forward to jsp page
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
     }
 }
