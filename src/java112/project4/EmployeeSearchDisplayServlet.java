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
     name = "employeeSearchDisplay",
     urlPatterns = { "/employeeSearchDisplay" }
 )
 public class EmployeeSearchDisplayServlet extends HttpServlet {

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

         //Create the url
         String url = "/jsp/employeeSearch.jsp";

         //Forward to jsp page
         RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
         dispatcher.forward(request, response);
     }
 }
