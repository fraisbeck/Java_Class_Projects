package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java112.employee.*;

/**
 *  This will forward to the Employee Search JSP Page
 *
 *@author    fraisbeck
 */
 @WebServlet(
     name = "addNewEmployee",
     urlPatterns = { "/addNewEmployee" }
 )
 public class EmployeeAddActionServlet extends HttpServlet {

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
     public void doPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {

        // Create a session Variable
        HttpSession session = request.getSession();
        // Create a variable that references the ServletContext
        ServletContext servletContext = request.getServletContext();
        // Gets the EmployeeDirectory from the servletContext
        EmployeeDirectory empDirectory = (EmployeeDirectory) servletContext.getAttribute("employeeDirectory");

        // Get the string values from the HTML Form
        String firstName = (String) request.getParameter("first_name");
        String lastName = (String) request.getParameter("last_name");
        String ssn = (String) request.getParameter("ssn");
        String department = (String) request.getParameter("dept");
        String roomNumber = (String) request.getParameter("room");
        String phoneNumber = (String) request.getParameter("phone");

        // Put the information into an array
        String[] employeeInfo = new String[]{firstName, lastName, ssn, department, roomNumber, phoneNumber};

        // Insert the new record into the database
        empDirectory.addNewRecord(employeeInfo);

        // Set the new project4AddMessage variable
        String project4AddMessage = request.getParameter("first_name")
                + " " + request.getParameter("last_name")
                + " was successfully added to the databse";
        session.setAttribute("project4AddMessage", project4AddMessage);

        //Create the url
        String url = "/java112/employeeAddDisplay";

        //Redirect to jsp page
        response.sendRedirect(url);
     }
 }
